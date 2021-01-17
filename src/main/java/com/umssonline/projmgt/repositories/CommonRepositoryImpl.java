package com.umssonline.projmgt.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

@Repository
public class CommonRepositoryImpl implements CommonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int findEntityTypeAndId(String entityType, Long entityId) {
        final String sqlQuery = "SELECT COUNT(1) FROM %1$s WHERE id = :entityId";
        Query queryResult = entityManager.createNativeQuery(String.format(sqlQuery, entityType))
                            .setParameter("entityId", entityId);

        int records = ((BigInteger) queryResult.getSingleResult()).intValue();
        return records;
    }
}
