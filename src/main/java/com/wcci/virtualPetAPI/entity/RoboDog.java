package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class RoboDog extends RoboticAnimal {
    int cage;

    public RoboDog(String name, String description) {
        super(name, description);
    }

    public int getCage() {
        return this.cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public void cleanCage() {
        this.cage = 100;
    }

    public void calculateHappiness() {
        this.setHappiness(
                this.getBladder() + this.getExercise() + this.getOil() + this.getCage());
    }

    public void walkDog() {
        this.setExercise(100);
        this.setBladder(100);
    }

    public int tick() {
        this.setBladder(this.getBladder() - 10);
        this.setExercise(this.getExercise() - 5);
        this.setOil(this.getOil() - 10);
        this.calculateHappiness();
        if (this.getBladder() == 0) {
            this.cage = this.cage - 10;
            this.setBladder(100);
            return 10;
        } else {
            return 0;
        }
    }
}