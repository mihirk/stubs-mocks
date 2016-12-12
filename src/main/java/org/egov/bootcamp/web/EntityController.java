package org.egov.bootcamp.web;

import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.service.EntityService;
import org.egov.bootcamp.service.LogicService;

import java.util.ArrayList;
import java.util.Arrays;
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
            Entity entity = new Entity(-1, "Invalid Entity");
            if (entityId < 10) {
                entity = this.entityService.getLow(entityId);
            } else if (entityId >= 10 && entityId < 20) {
                entity = this.entityService.getMedium(entityId);
            } else if (entityId >= 20 && entityId < 30) {
                entity = this.entityService.getHigh(entityId);
            }
            entities.add(this.logicService.applyLogic(entity));
        }
        return entities;
    }

    public static void main(String[] args) {
        EntityController entityController = new EntityController();
        List<Entity> entities = entityController.get(Arrays.asList(1, 2, 3));
        System.out.println(entities);
    }
}
