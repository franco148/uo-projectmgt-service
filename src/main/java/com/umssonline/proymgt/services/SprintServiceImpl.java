package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.repositories.SprintRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class SprintServiceImpl implements SprintService {

    //region Properties
    @Resource
    private SprintRepository sprintRepository;
    //endregion

    //region CrudService Members

    public Sprint save(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Iterable<Sprint> finAll() {
        throw new RuntimeException("Not implemented exception");
    }

    @Override
    public Sprint findById(Long id) {
        Sprint sprintFound = sprintRepository.findById(id)
                             .orElseThrow(() -> new EntityNotFoundException("Sprint with specified ID does not exist."));

        return sprintFound;
    }

    @Override
    public Sprint update(Sprint sprint) {
        Sprint sprintFromDb = sprintRepository.findById(sprint.getId())
                              .orElseThrow(() -> new EntityNotFoundException("Sprint with specified ID does not exist."));

        sprintFromDb.setName(sprint.getName());
        sprintFromDb.setStartedOn(sprint.getStartedOn());
        sprintFromDb.setCompletedOn(sprint.getCompletedOn());

        return sprintRepository.saveAndFlush(sprintFromDb);
    }

    @Override
    public void delete(Long sprintId) {

        sprintRepository.deleteById(sprintId);
    }

    //endregion

    //region SprintService Members

    @Override
    public Iterable<Sprint> findAllByProject(Long projectId) {
        Iterable<Sprint> sprintFromDb = sprintRepository.findByProjectId(projectId);

        return sprintFromDb;
    }
    //endregion
}
