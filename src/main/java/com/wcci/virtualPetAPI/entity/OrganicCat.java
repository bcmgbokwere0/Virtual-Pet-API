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
    @JoinColumn(name = "pet_shelter_id")
    private virtualPetShelter shelter;

    public OrganicCat(String name, String description, virtualPetShelter shelter) {
        super(name, description);
        this.shelter = shelter;
    }

    public OrganicCat() {
    }

    public void calculateHappiness() {
        this.setHappiness(
                this.getBladder() + this.getExercise() + this.getHunger() + this.getThirst());
    }

    public int tick() {
        this.setBladder(this.getBladder() - 10);
        this.setExercise(this.getExercise() - 5);
        this.setHunger(this.getHunger() - 5);
        this.setThirst(this.getThirst() - 10);
        this.calculateHappiness();
        if (this.getBladder() < 0) {
            this.setBladder(100);
            return 10;
        } else {
            return 0;
        }
    }
}