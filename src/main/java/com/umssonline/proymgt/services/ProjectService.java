package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.Project;
import com.umssonline.proymgt.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectService {

    //region Properties
    @Resource
    private ProjectRepository repository;
    //endregion

    //region CRUD Methods
    public Collection<Project> getAll() {
        return repository.findAll();
    }

    public Project find(Long projectId) throws Exception {
        Optional<Project> projectFromDb = repository.findById(projectId);

        if (!projectFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID does not exist.");
        }

        return projectFromDb.get();
    }

    public Project create(Project project) {
        return repository.save(project);
    }

    public Project edit(Project editedProject) throws Exception {
        Optional<Project> projectFromDb = repository.findById(editedProject.getId());

        if (!projectFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        projectFromDb.get().setName(editedProject.getName());
        projectFromDb.get().setCompletedDateEstimation(editedProject.getCompletedDateEstimation());

        return repository.saveAndFlush(projectFromDb.get());
    }

    public void remove(Long projectId) throws Exception {
        Optional<Project> projectFromDb = repository.findById(projectId);

        if (!projectFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        repository.delete(projectFromDb.get());
    }
    //endregion
}
