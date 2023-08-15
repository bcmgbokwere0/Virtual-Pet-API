package com.wcci.virtualPetAPI.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Odog")
public class OrganicDog extends OrganicAnimal {
    int cage;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_shelter_id")
    private virtualPetShelter shelter;

    public OrganicDog(String name, String description) {
        super(name, description);
    }

    public OrganicDog() {
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
                this.getBladder() + this.getExercise() + this.getHunger() + this.getThirst() + this.getCage());
    }

    public void walkDog() {
        this.setExercise(100);
        this.setBladder(100);
    }

    public int tick() {
        this.setBladder(this.getBladder() - 10);
        this.setExercise(this.getExercise() - 5);
        this.setHunger(this.getHunger() - 5);
        this.setThirst(this.getThirst() - 10);
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