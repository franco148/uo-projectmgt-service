package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
import com.umssonline.proymgt.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectService {

    //region Properties
    @Autowired
    private ProjectRepository projRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private SprintRepository sprintRepository;
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

    public Collection<Sprint> loadSprints(Long projectId) {
        Collection<Sprint> sprintFromDb = sprintRepository.findByProjectId(projectId);

        return sprintFromDb;
    }
    //endregion
}
