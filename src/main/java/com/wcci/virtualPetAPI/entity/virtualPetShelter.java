package com.wcci.virtualPetAPI.entity;

import java.util.ArrayList;

public class virtualPetShelter {
    private String name;
    private String description;
    private ArrayList<VirtualPet> animals;
    private int litterbox;

    public virtualPetShelter(String name, String description) {
        this.name = name;
        this.animals = new ArrayList<VirtualPet>();
        this.description = description;
    }

    public ArrayList<VirtualPet> getAnimals() {
        return this.animals;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getLitterbox() {
        return this.litterbox;
    }

    public void setLitterbox(int litterbox) {
        this.litterbox = litterbox;
    }

    public void add(VirtualPet adoptee) {
        this.animals.add(adoptee);
    }

    public void remove(VirtualPet adoptee) {
        this.animals.remove(adoptee);
    }

    public void clear() {
        this.animals = new ArrayList<VirtualPet>();
    }

    public void oilRobots() {
        for (VirtualPet current : this.getAnimals()) {
            if (current instanceof RoboticAnimal) {
                ((RoboticAnimal) current).oil();
            }
        }
    }

    // public void cleanCages() {
    // for (VirtualPet current : this.getAnimals()) {
    // if (current instanceof Dog) {
    // ((Dog) current).cleanCage();
    // }
    // }
    // }

    public void cleanLitterbox() {
        litterbox = 100;
    }

    // public void walkDogs() {
    // for (VirtualPet current : this.getAnimals()) {
    // if (current instanceof Dog) {
    // ((Dog) current).walkDog();
    // }
    // }
    // }

    public void feedPets() {
        for (VirtualPet current : this.getAnimals()) {
            if (current instanceof OrganicAnimal) {
                ((OrganicAnimal) current).feed();
            }
        }
    }

    public void waterPets() {
        for (VirtualPet current : this.getAnimals()) {
            if (current instanceof OrganicAnimal) {
                ((OrganicAnimal) current).water();
            }
        }
    }

    public VirtualPet getPet(String name) {
        for (VirtualPet currPet : this.getAnimals()) {
            if (currPet.getName().equals(name)) {
                return currPet;
            }
        }
        return null;
    }
}