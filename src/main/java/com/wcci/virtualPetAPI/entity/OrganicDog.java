package com.wcci.virtualPetAPI.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Odog")
public class OrganicDog extends OrganicAnimal {
    boolean cage;
    boolean walked;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_shelter_id")
    private virtualPetShelter shelter;

    public OrganicDog(String name, String description) {
        super(name, description);
    }

    public OrganicDog() {
    }

    public OrganicDog(String name, String description, virtualPetShelter shelter) {
        super(name, description);
        this.shelter = shelter;
        this.cage = true;
        this.walked = true;
    }

    public boolean getCage() {
        return this.cage;
    }

    public void setCage(boolean cage) {
        this.cage = cage;
    }

    public void cleanCage() {
        this.cage = true;
    }

    public void calculateHappiness() {
        this.setHappiness(
                this.getBladder() + this.getExercise() + this.getHunger() + this.getThirst());
    }

    public void walkDog() {
        this.walked = true;
    }

    public int tick() {
        this.setBladder(this.getBladder() - 10);
        this.setExercise(this.getExercise() - 5);
        this.setHunger(this.getHunger() - 5);
        this.setThirst(this.getThirst() - 10);
        this.calculateHappiness();
        if (this.getBladder() == 0) {
            this.cage = false;
            this.setBladder(100);
            return 10;
        } else {
            return 0;
        }
    }
}