package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;

public interface ProjectService extends CrudService<Project> {

    Iterable<Project> findByUserIdOrSharedWithMe(Long userId);

//    Sprint addSprint(Long projectId, Sprint sprint);

    Project loadProjectSprints(Long projectId);

//    int findEntityByTypeAndId(String entityType, Long entityId);
}
