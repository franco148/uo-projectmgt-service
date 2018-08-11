package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.repositories.BacklogRepository;
import com.umssonline.proymgt.repositories.ProjectRepository;
import com.umssonline.proymgt.services.api.BacklogService;
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
    private BacklogRepository backlogRepository;

    @Resource
    private ProjectRepository projectRepository;
    //endregion


    //region CrudService Members
    @Override
    public Backlog save(Backlog backlog) {
        throw new RuntimeException("save - Not implemented exception");
    }

    @Override
    public Iterable<Backlog> finAll() {
        throw new RuntimeException("finAll - Not implemented exception");
    }

    @Override
    public Backlog findById(Long id) {

        if (!backlogRepository.existsById(id)) {
            throw new EntityNotFoundException("Backlog with specified ID does not exist.");
        }

        return backlogRepository.getOne(id);
    }

    @Override
    public Backlog update(Backlog backlog) {
        throw new RuntimeException("update - Not implemented exception");
    }

    @Override
    public void delete(Long id) {
        throw new RuntimeException("delete - Not implemented exception");
    }
    //endregion

    //region BacklogService Members

    @Override
    public UserStory addUserStory(Long backlogId, UserStory userStory) {
        return null;
    }

    @Override
    public boolean sendUserStoryToSprint(Long backlogId, Long userStoryId, Long sprintId) {
        return false;
    }

    @Override
    public void deleteUserStory(Long backlogId, Long userStoryId) {

    }

    @Override
    public Backlog loadUserStories(Long backlogId) {
        return null;
    }


    //endregion
}
