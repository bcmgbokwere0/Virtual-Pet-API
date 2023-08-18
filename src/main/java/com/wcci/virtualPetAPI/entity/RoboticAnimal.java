package com.wcci.virtualPetAPI.entity;

import javax.persistence.Column;

public abstract class RoboticAnimal extends VirtualPet {
    @Column(name = "oil")
    private boolean oil;

    public RoboticAnimal(String name, String description) {
        super(name, description);
        this.oil = false;
    }

    public RoboticAnimal() {
    }

    public void setOil(boolean oil) {
        this.oil = oil;
    }

    public boolean getOil() {
        return this.oil;
    }

    public void oil() {
        this.oil = true;
    }
}