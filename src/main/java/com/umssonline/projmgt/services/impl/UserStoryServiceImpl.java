package com.umssonline.projmgt.services.impl;

import com.umssonline.projmgt.models.entity.Task;
import com.umssonline.projmgt.models.entity.UserStory;
import com.umssonline.projmgt.repositories.TaskRepository;
import com.umssonline.projmgt.repositories.UserStoryRepository;
import com.umssonline.projmgt.services.api.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    //region Properties
    @Autowired
    private UserStoryRepository usRepository;

    @Autowired
    private TaskRepository taskRepository;
    //endregion

    //region CrudService Members

    @Transactional
    @Override
    public UserStory save(UserStory userStory) {
        return usRepository.save(userStory);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<UserStory> finAll() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public UserStory findById(Long id) {

        if (!usRepository.existsById(id)) {
            throw new EntityNotFoundException("UserStory with specified ID does not exist.");
        }

        return usRepository.getOne(id);
    }

    @Transactional
    @Override
    public UserStory update(UserStory userStory) {

        if (!usRepository.existsById(userStory.getId())) {
            throw new EntityNotFoundException("UserStory with specified ID does not exist.");
        }

        return usRepository.save(userStory);
    }

    @Transactional
    public void delete(Long id) {
        usRepository.deleteById(id);
    }
    //endregion

    //region UserStoryService Members

    @Transactional
    @Override
    public Task addTask(Long userStoryId, Task task) {

        if (!usRepository.existsById(userStoryId)) {
            throw new EntityNotFoundException("UserStory with specified ID does not exist.");
        }

        UserStory foundUserStory = usRepository.getOne(userStoryId);
        task.setUserStory(foundUserStory);

        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public void deleteTask(Long userStoryId, Long taskId) {

        if (!usRepository.existsById(userStoryId)) {
            throw new EntityNotFoundException("UserStory with specified ID does not exist.");
        }

        if (!taskRepository.existsById(taskId)) {
            throw new EntityNotFoundException("Task with specified ID does not exist.");
        }

        taskRepository.deleteByIdAndUserStoryId(taskId, userStoryId);
    }

    //endregion
}
