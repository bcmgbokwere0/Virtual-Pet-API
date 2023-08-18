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
    boolean cage;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Rdogpet_shelter_id")
    private VirtualPetShelter shelter;

    public RoboDog(String name, String description) {
        super(name, description);
    }

    public RoboDog(String name, String description, VirtualPetShelter shelter) {
        super(name, description);
        this.cage = true;
        this.shelter = shelter;
    }

    public RoboDog() {
    }

    public boolean getCage() {
        return this.cage;
    }

    public void setCage(boolean cage) {
        this.cage = cage;
    }

    public String getShelter() {
        return this.shelter.getName();
    }

    public void cleanCage() {
        this.cage = true;
    }

    public void walkDog() {
        this.setExercise(100);
        this.setBladder(100);
    }
}