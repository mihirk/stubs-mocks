package org.egov.bootcamp.service;

import org.egov.bootcamp.model.Entity;

public class LogicService {
    public Entity applyLogic(Entity entity) {
        entity.setName(entity.getName() + " Hello World");
        return entity;
    }
}
