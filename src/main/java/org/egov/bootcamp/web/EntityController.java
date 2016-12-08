package org.egov.bootcamp.web;

import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.service.EntityService;
import org.egov.bootcamp.service.LogicService;

import java.util.ArrayList;
import java.util.List;

public class EntityController {
    private EntityService entityService;

    private LogicService logicService;

    public EntityController() {
        this.entityService = new EntityService();
        this.logicService = new LogicService();
    }

    public List<Entity> get(List<Integer> entityIds) {
        List<Entity> entities = new ArrayList<Entity>();
        for (Integer entityId : entityIds) {
            Entity entity = this.entityService.get(entityId);
            entities.add(this.logicService.applyLogic(entity));
        }
        return entities;
    }

    public static void main(String[] args) {
        EntityController entityController = new EntityController();

    }
}
