package org.egov.bootcamp.web;

import org.egov.bootcamp.model.EntityDTO;

import java.util.List;

import org.egov.bootcamp.mapper.EntityMapper;
import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.model.EntityDTO;
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

    public List<EntityDTO> get(List<Integer> entityIds) {
        List<EntityDTO> entities = new ArrayList<EntityDTO>();
        for (Integer entityId : entityIds) {
            EntityDTO entityDTO = EntityMapper.map(new Entity(-1, "Invalid Entity"));
            if (entityId < 10) {
                entityDTO = this.entityService.getLow(entityId);
            } else if (entityId >= 10 && entityId < 20) {
                entityDTO = this.entityService.getMedium(entityId);
            } else if (entityId >= 20 && entityId < 30) {
                entityDTO = this.entityService.getHigh(entityId);
            }
            entities.add(this.logicService.applyLogic(entityDTO));
        }
        return entities;
    }

    public static void main(String[] args) {
        EntityController entityController = new EntityController();
        List<EntityDTO> entities = entityController.get(Arrays.asList(1, 2, 3));
        System.out.println(entities);
    }
}
