package com.umssonline.proymgt.services.api;

import java.io.Serializable;

public interface CrudService<TEntity> {

    TEntity save(TEntity entity);
    Iterable<TEntity> finAll();
    TEntity findById(Long id);
    TEntity update(TEntity entity);
    void delete(Long id);
}
