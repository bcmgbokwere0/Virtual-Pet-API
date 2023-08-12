package com.wcci.virtualPetAPI.entity;

public abstract class RoboticAnimal extends VirtualPet {
    private int oil;

    public RoboticAnimal(String name, String description) {
        super(name, description);
        this.oil = 100;
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