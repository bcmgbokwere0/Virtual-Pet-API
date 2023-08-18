package com.wcci.virtualPetAPI.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;

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

    @ManyToMany(mappedBy = "volunteers", fetch = FetchType.LAZY)
    private List<VirtualPetShelter> petShelter;

    // Constructors

    public Volunteer() {
    }

    public Volunteer(String name, String description, String email) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.petShelter = new ArrayList<VirtualPetShelter>();
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

    public List<String> getPetShelters() {
        List<String> output = new ArrayList<String>();
        for (VirtualPetShelter shelter : this.petShelter) {
            output.add(shelter.getName());
        }
        return output;
    }

    public void setPetShelter(List<VirtualPetShelter> petShelter) {
        this.petShelter = petShelter;
    }

    public void addShelter(VirtualPetShelter shelter) {
        this.petShelter.add(shelter);
    }

}