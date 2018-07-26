package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;

public interface BacklogService extends CrudService<Backlog> {

    Iterable<UserStory> loadUserStories(Long backlogId);
}
