package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.egov.bootcamp.model.Entity;

public class EntityService {

    private EntityDao entityDao;

    public EntityService() {
        this.entityDao = new EntityDao();
    }

    public Entity getLow(Integer entityId) {
        return applyInternalLogic(validate(entityDao.get(entityId + 1)));
    }

    public Entity getMedium(Integer entityId) {
        return applyInternalLogic(validate(entityDao.get(entityId + 1)));
    }

    public Entity getHigh(Integer entityId) {
        return applyInternalLogic(validate(entityDao.get(entityId + 1)));
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
    /*
    1. Happy Path
    2. Entity returned from dao is null
    3. Entity returned with id < 0
    4. Entity name is null
    5. Entity name is empty
    6. Entity name is only spaces
    7. Entity name starts with Entity
    */

}
