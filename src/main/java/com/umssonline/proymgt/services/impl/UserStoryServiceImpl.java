package com.umssonline.proymgt.services.impl;

import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.repositories.TaskRepository;
import com.umssonline.proymgt.repositories.UserStoryRepository;
import com.umssonline.proymgt.services.api.UserStoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    //region Properties
    @Resource
    private UserStoryRepository usRepository;

    @Resource
    private TaskRepository taskRepository;
    //endregion

    //region Methods
    public UserStory find(Long id) throws Exception {

        Optional<UserStory> usrStoryFromDb = usRepository.findById(id);

        if (!usrStoryFromDb.isPresent()) {
            throw new Exception("UserStory with specified ID does not exist.");
        }

        return usrStoryFromDb.get();
    }

    public UserStory save(UserStory userStory) {
        return usRepository.save(userStory);
    }

    @Override
    public Iterable<UserStory> finAll() {
        return null;
    }

    @Override
    public UserStory findById(Long id) {
        return null;
    }

    @Override
    public UserStory update(UserStory userStory) {
        return null;
    }

    public UserStory edit(UserStory editedUserStory) {

        return usRepository.save(editedUserStory);
    }

    public void delete(Long id) {
        usRepository.deleteById(id);
    }
    //endregion
}
