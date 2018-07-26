package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class BacklogServiceImpl implements BacklogService {

    //region Properties
    @Resource
    private BacklogRepository repository;

    @Resource
    private ProjectRepository projectRepository;
    //endregion


    //region CrudService Members
    @Override
    public Backlog save(Backlog backlog) {
//        Optional<Project> projectForBacklog = projectRepository.findById(1L);
//
//        if (!projectForBacklog.isPresent()) {
//            throw new Exception("Project in which needs to be created a backlog does not exist.");
//        }
//
//        Backlog backlogToSave = new Backlog();
//        backlogToSave.setDescription(backlog.getDescription());
//        backlogToSave.setAmountOfTasks(0);
//        backlogToSave.setCreatedAt(LocalDateTime.now());
//        backlogToSave.setUpdatedAt(LocalDateTime.now());
//
//        Backlog savedBacklog = repository.save(backlogToSave);
//
//        projectForBacklog.get().setBacklog(backlogToSave);
//        //backlogToSave.setProject(projectForBacklog.get());
//        projectRepository.saveAndFlush(projectForBacklog.get());
//
//        return savedBacklog;
        throw new RuntimeException("Not implemented exception");
    }

    @Override
    public Iterable<Backlog> finAll() {
        return repository.findAll();
    }

    @Override
    public Backlog findById(Long id) {
        Backlog backlog = repository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID does not exist."));

        return backlog;
    }

    @Override
    public Backlog update(Backlog backlog) {
//        Optional<Backlog> backlogFromDb = repository.findById(1L);
//
//        if (!backlogFromDb.isPresent()) {
//            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
//        }
//
//        backlogFromDb.get().setDescription(backlog.getDescription());
//        backlogFromDb.get().setUpdatedAt(LocalDateTime.now());
//
//        return repository.saveAndFlush(backlogFromDb.get());
        throw new RuntimeException("Not implemented exception");
    }

    @Override
    public void delete(Long id) {

        Backlog backlogFromDb = repository.findById(id)
                                          .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID can not be found, process has been terminated"));

        repository.delete(backlogFromDb);
    }
    //endregion

    //region BacklogService Members

    public Collection<UserStory> loadUserStories(Long id) {
        Backlog backlogFromDb = repository.findById(id)
                                          .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID can not be found, process has been terminated"));

        Set<UserStory> userStories = new HashSet<>(backlogFromDb.getUserStories());

        return userStories;
    }


    //endregion
}
