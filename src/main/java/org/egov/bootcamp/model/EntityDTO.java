package org.egov.bootcamp.model;

import java.util.UUID;

public class EntityDTO {
    private UUID uuid;
    private Integer id;
    private String name;
    private Integer age;

    public EntityDTO() {
    }

    public EntityDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EntityDTO{" +
                "uuid=" + uuid.toString() +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
