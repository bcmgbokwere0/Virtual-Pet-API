package com.wcci.virtualPetAPI.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Table(name = "\"animals\"")
public abstract class VirtualPet {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "happiness")
    private int happiness;
    @Column(name = "bladder")
    private int bladder;
    @Column(name = "exercise")
    private int exercise;

    // constructors

    public VirtualPet() {
    }

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
        this.exercise = 100;
        this.bladder = 100;

    }

    // getters/setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getBladder() {
        return this.bladder;
    }

    public void setBladder(int bladder) {
        this.bladder = bladder;
    }

    public int getExercise() {
        return this.exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }

    public void bathroom() {
        this.bladder = 100;
    }

    public abstract void calculateHappiness();

    public abstract int tick();
}
