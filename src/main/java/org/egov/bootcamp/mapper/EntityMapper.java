package org.egov.bootcamp.mapper;

import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.model.EntityDTO;

import java.util.Random;
import java.util.UUID;

public class EntityMapper {
    public static EntityDTO map(Entity entity) {
        EntityDTO entityDTO = new EntityDTO();
        entityDTO.setAge(entity.getId() * 120);
        entityDTO.setName(entity.getCapName() + entity.getName());
        entityDTO.setUuid(UUID.randomUUID());
        entity.setId(new Random().nextInt());
        return entityDTO;
    }
}
