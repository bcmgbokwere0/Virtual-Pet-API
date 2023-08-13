package com.wcci.virtualPetAPI.entity;

import javax.persistence.Column;

public abstract class RoboticAnimal extends VirtualPet {
    @Column(name = "oil")
    private int oil;

    public RoboticAnimal(String name, String description) {
        super(name, description);
        this.oil = 100;
    }

    public RoboticAnimal() {
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public int getOil() {
        return this.oil;
    }

    public void oil() {
        this.oil = 100;
    }
}