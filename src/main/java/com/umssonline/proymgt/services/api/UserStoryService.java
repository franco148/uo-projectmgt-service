package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Task;
import com.umssonline.proymgt.models.entity.UserStory;

public interface UserStoryService extends CrudService<UserStory> {

    Task addTask(Long userStoryId, Task task);
    void deleteTask(Long userStoryId, Long taskId);
    // UserStory loadTasks(Long userStoryId);
}
