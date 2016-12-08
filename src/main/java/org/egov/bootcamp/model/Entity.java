package org.egov.bootcamp.model;


public class Entity {
    private Integer id;
    private String name;
    private String capName;

    public Entity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capName='" + capName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getCapName() {
        return capName;
    }

    public void setCapName(String capName) {
        this.capName = capName;
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
}
