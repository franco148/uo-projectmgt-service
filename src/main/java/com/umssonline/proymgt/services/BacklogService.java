package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.dto.CreateBacklogDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
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

    @Resource
    private ProjectRepository projectRepository;
    //endregion

    //region CRUD Methods
    public Backlog find(Long id) throws Exception {
        Optional<Backlog> backlogFromDb = repository.findById(id);

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID does not exist.");
        }

        return backlogFromDb.get();
    }

    public Backlog create(CreateBacklogDto backlog) throws Exception {

        Optional<Project> projectForBacklog = projectRepository.findById(backlog.getProjectId());

        if (!projectForBacklog.isPresent()) {
            throw new Exception("Project in which needs to be created a backlog does not exist.");
        }

        Backlog backlogToSave = new Backlog();
        backlogToSave.setDescription(backlog.getDescription());
        backlogToSave.setAmountOfTasks(0);
        backlogToSave.setCreatedAt(LocalDateTime.now());
        backlogToSave.setUpdatedAt(LocalDateTime.now());

        Backlog savedBacklog = repository.save(backlogToSave);

        projectForBacklog.get().setBacklog(backlogToSave);
        backlogToSave.setProject(projectForBacklog.get());
        projectRepository.saveAndFlush(projectForBacklog.get());

        return savedBacklog;
    }

    public Backlog edit(CreateBacklogDto backlog) throws Exception {
        Optional<Backlog> backlogFromDb = repository.findById(backlog.getId());

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        backlogFromDb.get().setDescription(backlog.getDescription());
        backlogFromDb.get().setUpdatedAt(LocalDateTime.now());

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
