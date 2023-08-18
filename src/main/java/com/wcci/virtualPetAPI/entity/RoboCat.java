package com.wcci.virtualPetAPI.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Rcat")
public class RoboCat extends RoboticAnimal {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Rcatpet_shelter_id")
    private VirtualPetShelter shelter;

    public RoboCat(String name, String description) {
        super(name, description);
    }

    public RoboCat(String name, String description, VirtualPetShelter shelter) {
        super(name, description);
        this.shelter = shelter;
    }

    public RoboCat() {
    }

    public String getShelter() {
        return this.shelter.getName();
    }

    public void calculateHappiness() {
        this.setHappiness(
                this.getBladder() + this.getExercise());
    }

}