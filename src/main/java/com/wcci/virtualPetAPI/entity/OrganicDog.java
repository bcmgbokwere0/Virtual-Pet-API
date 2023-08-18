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
    @JoinColumn(name = "Odogpet_shelter_id")
    private VirtualPetShelter shelter;

    public OrganicDog(String name, String description) {
        super(name, description);
    }

    public OrganicDog() {
    }

    public OrganicDog(String name, String description, VirtualPetShelter shelter) {
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

    public String getShelter() {
        return this.shelter.getName();
    }
}