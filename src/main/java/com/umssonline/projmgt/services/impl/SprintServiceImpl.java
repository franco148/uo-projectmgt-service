package com.umssonline.projmgt.services.impl;

import com.umssonline.projmgt.exceptions.InvalidPreConditionException;
import com.umssonline.projmgt.exceptions.InvalidResourceException;
import com.umssonline.projmgt.models.entity.Sprint;
import com.umssonline.projmgt.models.entity.UserStory;
import com.umssonline.projmgt.repositories.SprintRepository;
import com.umssonline.projmgt.repositories.UserStoryRepository;
import com.umssonline.projmgt.services.api.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        if (!sprintRepository.existsById(sprintId)) {
            throw new EntityNotFoundException("Sprint with specified ID does not exits.");
        }

        Long activeSprints = sprintRepository.countActiveSprints(true);
        if (activeSprints > 0) {
            throw new InvalidPreConditionException("There already exist Active Sprint(s), you need to mark them as ended before continue.");
        }

        Sprint sprintToActivate = sprintRepository.getOne(sprintId);
        sprintToActivate.setActive(true);
        sprintToActivate.setStartedOn(LocalDate.now());
        sprintToActivate.setUpdatedAt(LocalDateTime.now());

        sprintRepository.flush();
    }

    @Transactional
    @Override
    public void markAsEnded(Long sprintId) {

        if (!sprintRepository.existsById(sprintId)) {
            throw new EntityNotFoundException("Sprint with specified ID does not exits.");
        }

        Sprint sprintToEnd = sprintRepository.getOne(sprintId);
        sprintToEnd.setActive(false);
        sprintToEnd.setCompletedOn(LocalDate.now());
        sprintToEnd.setUpdatedAt(LocalDateTime.now());

        sprintRepository.flush();
    }

    @Override
    public Iterable<UserStory> loadUserStories(Long sprintId) {
        if (!sprintRepository.existsById(sprintId)) {
            throw new InvalidResourceException("Sprint with the specified ID could not be found.");
        }

        return userStoryRepository.findBySprintId(sprintId);
    }


    //endregion
}
