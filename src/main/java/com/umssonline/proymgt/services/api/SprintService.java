package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Sprint;

public interface SprintService extends CrudService<Sprint> {

    Iterable<Sprint> findAllByProject(Long projectId);
}
