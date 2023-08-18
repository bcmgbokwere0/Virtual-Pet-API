package com.wcci.virtualPetAPI.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Rdog")
public class RoboDog extends RoboticAnimal {
    int cage;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_shelter_id")
    private virtualPetShelter shelter;

    public RoboDog(String name, String description) {
        super(name, description);
    }

    public RoboDog(String name, String description, virtualPetShelter shelter) {
        super(name, description);
        this.cage = 100;
        this.shelter = shelter;
    }

    public RoboDog() {
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

    public void walkDog() {
        this.setExercise(100);
        this.setBladder(100);
    }
}