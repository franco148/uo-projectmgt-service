package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.models.entity.Task;
import com.umssonline.proymgt.repositories.TaskRepository;
import com.umssonline.proymgt.services.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class TaskServiceImpl implements TaskService {

    //region Properties

    @Autowired
    private TaskRepository taskRepository;
    //endregion

    //region CrudService Members

    @Transactional
    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Task> finAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Task findById(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new EntityNotFoundException("Task with specified ID does not exist.");
        }

        return taskRepository.getOne(id);
    }

    @Transactional
    @Override
    public Task update(Task task) {

        if (!taskRepository.existsById(task.getId())) {
            throw new EntityNotFoundException("Task with specified ID does not exist.");
        }

        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
    //endregion

    //region TaskService Members
    //endregion
}
