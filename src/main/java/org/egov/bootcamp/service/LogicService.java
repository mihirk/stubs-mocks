package org.egov.bootcamp.service;

import org.egov.bootcamp.model.EntityDTO;

public class LogicService {
    public EntityDTO applyLogic(EntityDTO entity) {
        entity.setName(entity.getName() + " Hello World");
        return entity;
    }
}
