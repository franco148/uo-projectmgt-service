package com.umssonline.projmgt.services.api;

import com.umssonline.projmgt.models.entity.Project;
import com.umssonline.projmgt.models.entity.Sprint;

public interface ProjectService extends CrudService<Project> {

    Iterable<Project> findByUserIdOrSharedWithMe(Long userId);

    Sprint addSprint(Long projectId, Sprint sprint);

    Project loadProjectSprints(Long projectId);

    int findEntityByTypeAndId(String entityType, Long entityId);
}
