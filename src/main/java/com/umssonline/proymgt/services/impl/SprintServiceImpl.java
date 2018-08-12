package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.repositories.SprintRepository;
import com.umssonline.proymgt.repositories.UserStoryRepository;
import com.umssonline.proymgt.services.api.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class SprintServiceImpl implements SprintService {

    //region Properties
    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private UserStoryRepository userStoryRepository;
    //endregion

    //region CrudService Members

    @Transactional
    @Override
    public Sprint save(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Sprint> finAll() {
        throw new RuntimeException("Not implemented exception");
    }

    @Transactional(readOnly = true)
    @Override
    public Sprint findById(Long id) {

        if (!sprintRepository.existsById(id)) {
            throw new EntityNotFoundException("Sprint with specified ID does not exist.");
        }

        return sprintRepository.getOne(id);
    }

    @Transactional
    @Override
    public Sprint update(Sprint sprint) {
//        Sprint sprintFromDb = sprintRepository.findById(sprint.getId())
//                              .orElseThrow(() -> new EntityNotFoundException("Sprint with specified ID does not exist."));
//
//        sprintFromDb.setName(sprint.getName());
//        sprintFromDb.setStartedOn(sprint.getStartedOn());
//        sprintFromDb.setCompletedOn(sprint.getCompletedOn());

        if (!sprintRepository.existsById(sprint.getId())) {
            throw new EntityNotFoundException("Sprint with specified ID does not exist.");
        }

        return sprintRepository.saveAndFlush(sprint);
    }

    @Transactional
    @Override
    public void delete(Long sprintId) {
        sprintRepository.deleteById(sprintId);
    }

    //endregion

    //region SprintService Members

    @Transactional
    @Override
    public void moveTaskToAnotherSprint(Long sourceSprint, Long targetSprint, Long userStoryId) {
        if (!sprintRepository.existsById(sourceSprint)) {
            throw new EntityNotFoundException("Source Sprint with specified ID does not exist.");
        }

        if (!sprintRepository.existsById(targetSprint)) {
            throw new EntityNotFoundException("Target Sprint with specified ID does not exist.");
        }

        if (!userStoryRepository.existsById(userStoryId)) {
            throw new EntityNotFoundException("User Story with specified ID does not exist.");
        }

        UserStory foundUserStory = userStoryRepository.findByIdAndSprintId(userStoryId, sourceSprint);
        if (foundUserStory == null) {
            throw new EntityNotFoundException("User Story with specified ID does not exist in the specified source sprint.");
        }

        Sprint foundTargetSprint = sprintRepository.getOne(targetSprint);
        foundUserStory.setSprint(foundTargetSprint);

        userStoryRepository.saveAndFlush(foundUserStory);
    }

    @Transactional
    @Override
    public void activateSprint(Long sprintId) {

    }

    @Transactional
    @Override
    public void markAsEnded(Long sprintId) {

    }


    //endregion
}
