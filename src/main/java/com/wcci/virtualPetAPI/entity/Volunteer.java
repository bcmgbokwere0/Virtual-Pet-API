package com.wcci.virtualPetAPI.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "\"volunteer\"")
public class Volunteer {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "email")
    private String email;

    @ManyToMany
    private List<virtualPetShelter> petShelter;

    // Constructors

    public Volunteer() {
    }

    public Volunteer(String name, String description, String email, List<virtualPetShelter> petShelter) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.petShelter = petShelter;
    }

    // Getters and Setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<virtualPetShelter> getPetShelters() {
        return petShelter;
    }

    public void setPetShelter(List<virtualPetShelter> petShelter) {
        this.petShelter = petShelter;
    }

}