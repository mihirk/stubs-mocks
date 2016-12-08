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
        return applyInternalLogic(validate(entityDao.get(entityId)));
    }

    private Entity validate(Entity entity) {
        if (entity != null && entity.getId() > 0 && entity.getName() != null && entity.getName().trim().length() > 0) {
            return entity;
        }
        throw new NullPointerException("Entity is null");
    }

    private Entity applyInternalLogic(Entity entity) {
        entity.setCapName(entity.getName().toUpperCase());
        if (!entity.getName().startsWith("Entity")) {
            entity.setName("Entity " + entity.getName());
        }
        return entity;
    }

}
