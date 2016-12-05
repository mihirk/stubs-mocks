package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.egov.bootcamp.model.Entity;

public class EntityService {

    private EntityDao entityDao;

    public EntityService() {
        this.entityDao = new EntityDao();
    }

    public EntityService(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    public Entity get(Integer entityId) {
        return entityDao.get(entityId);
    }
}
