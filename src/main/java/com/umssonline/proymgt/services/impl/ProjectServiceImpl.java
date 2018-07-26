package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
import com.umssonline.proymgt.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    //region Properties
    @Autowired
    private ProjectRepository projRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private SprintRepository sprintRepository;
    //endregion

    //region CRUDService Members

    @Transactional
    @Override
    public Project save(Project project) {
        return projRepository.save(project);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Project> finAll() {
        return projRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Project findById(Long id) {
        Project projectFromDb = projRepository.findById(id)
                                              .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID does not exist."));


        return projectFromDb;
    }

    @Override
    public Project update(Project project) {
        Project projectFromDb = projRepository.findById(project.getId())
                                              .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID can not be found, process has been terminated"));

        //projectFromDb.setName(editedProject.getName());
        //projectFromDb.setCompletedDateEstimation(editedProject.getCompletedDateEstimation());

        return projRepository.saveAndFlush(projectFromDb);
    }

    @Override
    public void delete(Long id) {

        Project projectFromDb = projRepository.findById(id)
                                              .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID can not be found, process has been terminated"));

        projRepository.delete(projectFromDb);
    }
    //endregion

    //region SprintService Members
    @Override
    public Backlog getBacklog(Long projectId) {
//        Backlog backlogFromDb = backlogRepository.findByProjectId(projectId)
//                .orElseThrow(() -> new EntityNotFoundException("Backlog with specified ID does not exist."));
//
//        return backlogFromDb;
        return null;
    }

    @Override
    public Iterable<Sprint> loadSprints(Long projectId) {
        Iterable<Sprint> sprintsList = sprintRepository.findByProjectId(projectId);
        return sprintsList;
    }
    //endregion
}
