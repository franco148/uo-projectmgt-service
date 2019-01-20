package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.exceptions.InvalidResourceException;
import com.umssonline.proymgt.feign.UsersFeignClient;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.models.entity.User;
import com.umssonline.proymgt.repositories.CommonRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
import com.umssonline.proymgt.repositories.SprintRepository;
import com.umssonline.proymgt.repositories.UserRepository;
import com.umssonline.proymgt.services.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    //region Properties
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private SprintRepository sprintRepository;

//    @Qualifier("authService")
    @Autowired
    private UsersFeignClient usersClient;

    //endregion

    //region CRUDService Members

    @Transactional
    @Override
    public Project save(Project project) {
        User authUser = usersClient.findById(project.getCreatedBy().getId());
        if (authUser == null) {
            throw new InvalidResourceException("User with the specified ID could not be found.");
        }

        User savedUser = userRepository.save(authUser);
        project.getBacklog().setProject(project);
        project.getBacklog().setCreatedBy(savedUser);

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

        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project with specified ID does not exist.");
        }

        return projectRepository.getOne(id);
    }

    @Override
    public Project update(Project project) {

        if (!projectRepository.existsById(project.getId())) {
            throw new EntityNotFoundException("Project with specified ID can not be found, process has been terminated");
        }

        User authUser = usersClient.findById(project.getUpdatedBy().getId());
        if (authUser == null) {
            throw new InvalidResourceException("User with the specified ID could not be found.");
        }

        User savedUser = userRepository.save(authUser);
        project.getBacklog().setUpdatedBy(savedUser);

        Project sourceProject = projectRepository.getOne(project.getId());
        // modelMapper.map(project, projectToUpdate);
        project.setIsDeleted(sourceProject.getIsDeleted());
//        project.setCreatedBy(sourceProject.getCreatedBy());
//        project.setCreatedAt(sourceProject.getCreatedAt());
        project.getBacklog().setAmountOfUserStories(sourceProject.getBacklog().getAmountOfUserStories());
        project.getBacklog().setIsDeleted(sourceProject.getBacklog().getIsDeleted());
        //project.getBacklog().setCreatedAt(sourceProject.getBacklog().getCreatedAt());
//        project.getBacklog().setCreatedAt(LocalDateTime.now());
//        project.getBacklog().setCreatedBy(sourceProject.getBacklog().getCreatedBy());

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

    @Override
    public Iterable<Project> findByUserIdOrSharedWithMe(Long userId) {
        Iterable<Project> userProjects = projectRepository.findByCreatedById(userId);

        return userProjects;
    }

    @Transactional
    @Override
    public Sprint addSprint(Long projectId, Sprint sprint) {

        if (!projectRepository.existsById(projectId)) {
            throw new EntityNotFoundException("Project with specified ID can not be found.");
        }

        User authUser = usersClient.findById(sprint.getCreatedBy().getId());
        if (authUser == null) {
            throw new InvalidResourceException("User with the specified ID could not be found.");
        }

        User savedUser = userRepository.save(authUser);

        Project foundProject = projectRepository.getOne(projectId);

        sprint.setProject(foundProject);
        sprint.setCreatedBy(savedUser);

        return sprintRepository.save(sprint);
    }

    @Transactional(readOnly = true)
    @Override
    public Project loadProjectSprints(Long projectId) {
        Project foundProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project with specified ID can not be found."));

        foundProject.getSprints();

        return foundProject;
    }

    @Transactional(readOnly = true)
    @Override
    public int findEntityByTypeAndId(String entityType, Long entityId) {

        if (entityId < 1) {
            throw new EntityNotFoundException("The specified entity ID is not valid.");
        }

        return commonRepository.findEntityTypeAndId(entityType, entityId);
    }

    //endregion
}
