package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.repositories.ProjectRepository;
import com.umssonline.proymgt.services.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    //region Properties
    @Autowired
    private ProjectRepository projectRepository;

    //endregion

    //region CRUDService Members

    @Transactional
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Project> finAll() {
        return projectRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Project findById(Long id) {
        Project projectFromDb = projectRepository.findById(id)
                                              .orElseThrow(() -> new EntityNotFoundException("Project with specified ID does not exist."));


        return projectFromDb;
    }

    @Override
    public Project update(Project project) {

        if (!projectRepository.existsById(project.getId())) {
            throw new EntityNotFoundException("Project with specified ID can not be found, process has been terminated");
        }

        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {

        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project with specified ID can not be found, process has been terminated");
        }

        projectRepository.deleteById(id);
    }
    //endregion

    //region SprintService Members

    @Transactional
    @Override
    public Sprint addSprint(Long projectId, Sprint sprint) {
        Project foundProject = projectRepository.findById(projectId)
                               .orElseThrow(() -> new EntityNotFoundException("Project with specified ID can not be found."));

        foundProject.addSprint(sprint);
        projectRepository.saveAndFlush(foundProject);

        return sprint;
    }

    @Transactional(readOnly = true)
    @Override
    public Project loadProjectSprints(Long projectId) {
        Project foundProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project with specified ID can not be found."));

        foundProject.getSprints();

        return foundProject;
    }

    //endregion
}
