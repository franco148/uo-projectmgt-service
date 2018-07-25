package com.umssonline.proymgt.services;

import com.umssonline.proymgt.models.dto.SprintDto;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.repositories.SprintRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@Service
public class SprintService {

    //region Properties
    @Resource
    private SprintRepository sprintRepository;
    //endregion

    //region Methods

    public Sprint find(Long id) throws Exception {
        Optional<Sprint> sprintFromDb = sprintRepository.findById(id);

        if (!sprintFromDb.isPresent()) {
            throw new Exception("Sprint with specified ID does not exist.");
        }

        return sprintFromDb.get();
    }

    public Collection<Sprint> findAllByProjectId(Long projectId) {
        Collection<Sprint> sprintFromDb = sprintRepository.findByProjectId(projectId);

        return sprintFromDb;
    }

    public Sprint save(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    public Sprint edit(SprintDto editedSprint) throws Exception {

        Optional<Sprint> sprintFromDb = sprintRepository.findById(editedSprint.getId());

        if (!sprintFromDb.isPresent()) {
            throw new Exception("Sprint with specified ID does not exist.");
        }

        sprintFromDb.get().setName(editedSprint.getName());
        sprintFromDb.get().setStartedOn(editedSprint.getStartedOn());
        sprintFromDb.get().setCompletedOn(editedSprint.getCompletedOn());

        return sprintRepository.saveAndFlush(sprintFromDb.get());
    }

    public void delete(Long sprintId) {

//        Optional<Sprint> sprintFromDb = sprintRepository.findById(sprintId);
//
//        if (!sprintFromDb.isPresent()) {
//            throw new Exception("Sprint with specified ID does not exist.");
//        }
        sprintRepository.deleteById(sprintId);
    }
    //endregion
}
