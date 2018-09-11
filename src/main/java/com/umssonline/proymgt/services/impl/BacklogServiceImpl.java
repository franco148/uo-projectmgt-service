package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.exceptions.InvalidResourceException;
import com.umssonline.proymgt.feign.UsersFeignClient;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.models.entity.User;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.SprintRepository;
import com.umssonline.proymgt.repositories.UserRepository;
import com.umssonline.proymgt.repositories.UserStoryRepository;
import com.umssonline.proymgt.services.api.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class BacklogServiceImpl implements BacklogService {

    //region Properties
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersFeignClient usersClient;
    //endregion


    //region CrudService Members
    @Override
    public Backlog save(Backlog backlog) {
        throw new RuntimeException("save - Not implemented exception");
    }

    @Override
    public Iterable<Backlog> finAll() {
        throw new RuntimeException("finAll - Not implemented exception");
    }

    @Transactional(readOnly = true)
    @Override
    public Backlog findById(Long id) {

        if (!backlogRepository.existsById(id)) {
            throw new EntityNotFoundException("Backlog with specified ID does not exist.");
        }

        return backlogRepository.getOne(id);
    }

    @Override
    public Backlog update(Backlog backlog) {
        throw new RuntimeException("update - Not implemented exception");
    }

    @Override
    public void delete(Long id) {
        throw new RuntimeException("delete - Not implemented exception");
    }
    //endregion

    //region BacklogService Members

    @Transactional
    @Override
    public UserStory addUserStory(Long backlogId, UserStory userStory) {

        if (!backlogRepository.existsById(backlogId)) {
            throw new EntityNotFoundException("Backlog with specified ID can not be found.");
        }

        User authUser = usersClient.findById(userStory.getCreatedBy().getId());
        if (authUser == null) {
            throw new InvalidResourceException("User with the specified ID could not be found.");
        }

        User savedUserCreatedBy = userRepository.save(authUser);

        if (userStory.getAssignedTo() != null) {
            User assignedUser = usersClient.findById(userStory.getAssignedTo().getId());
            if (assignedUser == null) {
                throw new InvalidResourceException("User with the specified ID could not be found.");
            }

            User assignedToUser = userRepository.save(assignedUser);
            userStory.setAssignedTo(assignedToUser);
        }


        Backlog backlog = backlogRepository.getOne(backlogId);
        userStory.setBacklog(backlog);
        userStory.setCreatedBy(savedUserCreatedBy);

        return userStoryRepository.save(userStory);
    }

    @Transactional
    @Override
    public void sendUserStoryToSprint(Long backlogId, Long userStoryId, Long sprintId) {

        UserStory storyToMove = userStoryRepository.findByIdAndBacklogId(userStoryId, backlogId);
        if (storyToMove == null) {
            throw new EntityNotFoundException("UserStory to move to a sprint does not exist in the specified backlog.");
        }

        if (!sprintRepository.existsById(sprintId)) {
            throw new EntityNotFoundException("Target Sprint does not exist.");
        }

        Sprint targetSprint = sprintRepository.getOne(sprintId);
        //storyToMove.setSprint(targetSprint);
        targetSprint.addSprintItems(storyToMove);
        sprintRepository.save(targetSprint);
    }

    @Transactional
    @Override
    public void deleteUserStory(Long backlogId, Long userStoryId) {

        UserStory storyToDelete = userStoryRepository.findByIdAndBacklogId(userStoryId, backlogId);

        if (storyToDelete == null) {
            throw new EntityNotFoundException("Delete operation can not be completed, UserStory does not exist in the backlog.");
        }

        userStoryRepository.delete(storyToDelete);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<UserStory> loadUserStories(Long backlogId) {

        if (!backlogRepository.existsById(backlogId)) {
            throw new InvalidResourceException("Backlog with the specified ID could not be found.");
        }

//        Backlog backlogWithUserStories = backlogRepository.getOne(backlogId);
//        backlogWithUserStories.getUserStories();

        Iterable<UserStory> storiesList = userStoryRepository.findByBacklogId(backlogId);
//        System.out.println(storiesList);

        return storiesList;
    }


    //endregion
}
