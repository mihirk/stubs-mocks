package org.egov.bootcamp.web;

import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.service.EntityService;
import org.egov.bootcamp.service.LogicService;

public class EntityController {
    private EntityService entityService = new EntityService();

    private LogicService logicService;

    public EntityController(LogicService logicService) {
        this.logicService = logicService;
    }

    public Entity get(Integer entityId) {
        Entity entity = this.entityService.get(entityId);
        return this.logicService.applyLogic(entity);
    }

    public static void main(String[] args) {
        EntityController entityController = new EntityController(new LogicService());
        System.out.println(entityController.get(2));
    }
}
