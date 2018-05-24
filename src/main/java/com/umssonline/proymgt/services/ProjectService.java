package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.Backlog;
import com.umssonline.proymgt.models.Project;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectService {

    //region Properties
    @Resource
    private ProjectRepository projRepository;

    @Resource
    private BacklogRepository backlogRepository;
    //endregion

    //region CRUD Methods
    public Collection<Project> getAll() {
        return projRepository.findAll();
    }

    public Project find(Long projectId) throws Exception {
        Optional<Project> projectFromDb = projRepository.findById(projectId);

        if (!projectFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID does not exist.");
        }

        return projectFromDb.get();
    }

    public Project create(Project project) {
        return projRepository.save(project);
    }

    public Project edit(Project editedProject) throws Exception {
        Optional<Project> projectFromDb = projRepository.findById(editedProject.getId());

        if (!projectFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        projectFromDb.get().setName(editedProject.getName());
        projectFromDb.get().setCompletedDateEstimation(editedProject.getCompletedDateEstimation());

        return projRepository.saveAndFlush(projectFromDb.get());
    }

    public void remove(Long projectId) throws Exception {
        Optional<Project> projectFromDb = projRepository.findById(projectId);

        if (!projectFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID can not be found, process has been terminated");
        }

        projRepository.delete(projectFromDb.get());
    }

    public Backlog loadBacklog(Long projectId) throws Exception {

        Optional<Backlog> backlogFromDb = backlogRepository.findByProjectId(projectId);

        if (!backlogFromDb.isPresent()) {
            throw new Exception("Backlog with specified ID does not exist.");
        }

        return backlogFromDb.get();
    }
    //endregion
}
