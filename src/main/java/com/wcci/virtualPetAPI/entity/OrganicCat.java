package com.wcci.virtualPetAPI.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Ocat")
public class OrganicCat extends OrganicAnimal {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ocatpet_shelter_id")
    private VirtualPetShelter shelter;

    public OrganicCat(String name, String description, VirtualPetShelter shelter) {
        super(name, description);
        this.shelter = shelter;
    }

    public OrganicCat() {
    }

    public String getShelter() {
        return this.shelter.getName();
    }

    public void calculateHappiness() {
        this.setHappiness(
                this.getBladder() + this.getExercise() + this.getHunger() + this.getThirst());
    }
}