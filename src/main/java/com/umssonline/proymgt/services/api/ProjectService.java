package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;

public interface ProjectService extends CrudService<Project> {

    Backlog getBacklog(Long projectId);
    Iterable<Sprint> loadSprints(Long projectId);

    Sprint addSprintToProject(Long projectId, Sprint sprint);
}
