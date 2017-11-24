package com.oab.backend.domain;

public class Hero {

    private Long id;
    private String name;
    private String skill;

    public Hero() {
    }

    public Hero(Long id, String name, String skill) {
        this.id = id;
        this.name = name;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
