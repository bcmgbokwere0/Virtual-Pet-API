package com.wcci.virtualPetAPI.entity;

public abstract class OrganicAnimal extends VirtualPet {
    private int thirst;
    private int hunger;

    public OrganicAnimal(String name, String description) {
        super(name, description);
        this.thirst = 100;
        this.hunger = 100;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void feed() {
        this.hunger = 100;
        this.thirst = this.thirst - 10;
        this.setBladder(this.getBladder() - 20);
    }

    public void water() {
        this.thirst = 100;
        this.setBladder(this.getBladder() - 30);
    }
}