package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.Backlog;
import com.umssonline.proymgt.models.UserStory;
import com.umssonline.proymgt.repositories.BacklogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BacklogService {

    //region Properties
    @Resource
    private BacklogRepository repository;
    //endregion

    //region CRUD Methods
    public Backlog find(Long id) throws Exception {
        Optional<Backlog> backlogFromDb = repository.findById(id);

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID does not exist.");
        }

        return backlogFromDb.get();
    }

    public Backlog create(Backlog backlog) {
        return repository.save(backlog);
    }

    public Backlog edit(Backlog backlog) throws Exception {
        Optional<Backlog> backlogFromDb = repository.findById(backlog.getId());

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        backlogFromDb.get().setDescription(backlog.getDescription());
        backlogFromDb.get().setAmountOfTasks(backlog.getAmountOfTasks());
        backlogFromDb.get().setUpdatedOn(LocalDateTime.now());

        return repository.saveAndFlush(backlogFromDb.get());
    }

    public void remove(Long backlogId) throws Exception {
        Optional<Backlog> backlogFromDb = repository.findById(backlogId);

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        repository.delete(backlogFromDb.get());
    }

    public Collection<UserStory> loadUserStories(Long backlogId) throws Exception {
        Optional<Backlog> backlogFromDb = repository.findById(backlogId);

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        Set<UserStory> userStories = new HashSet<>(backlogFromDb.get().getUserStories());

        return userStories;
    }
    //endregion
}
