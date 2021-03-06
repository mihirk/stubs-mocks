package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.egov.bootcamp.mapper.EntityMapper;
import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.model.EntityDTO;

public class EntityService {

    private EntityDao entityDao;

    public EntityService() {
        this.entityDao = new EntityDao();
    }

    public EntityDTO getLow(Integer entityId) {
        return applyInternalLogic(validate(entityDao.get(entityId + 1)));
    }

    public EntityDTO getMedium(Integer entityId) {
        return applyInternalLogic(validate(entityDao.get(entityId + 1)));
    }

    public EntityDTO getHigh(Integer entityId) {
        return applyInternalLogic(validate(entityDao.get(entityId + 1)));
    }

    private Entity validate(Entity entity) {
        if (entity == null) {
            throw new NullPointerException("Entity is null");
        }
        if (entity.getId() < 1) {
            throw new NullPointerException("Invalid Id");
        }
        if (entity.getName() == null) {
            throw new NullPointerException("Name is null");
        }
        if (entity.getName().trim().length() <= 0) {
            throw new NullPointerException("Name is mempty");
        }
        return entity;
    }

    private EntityDTO applyInternalLogic(Entity entity) {
        entity.setCapName(entity.getName().toUpperCase());
        if (!entity.getName().startsWith("Entity")) {
            entity.setName("Entity " + entity.getName());
        }
        return EntityMapper.map(entity);
    }
}
