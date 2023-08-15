package com.wcci.virtualPetAPI.entity;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"shelter\"")
public class virtualPetShelter {

    @Id
    @Column(name = "shelter_id")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "litterbox")
    private int litterbox;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_shelter_id", referencedColumnName = "shelter_id")
    private ArrayList<VirtualPet> animals;

    @ManyToMany
    @JoinTable(name = "shelter_volunteer", joinColumns = @JoinColumn(name = "volunteershelter_id"), inverseJoinColumns = @JoinColumn(name = "volunteer_id"))
    private ArrayList<Volunteer> volunteers;

    public virtualPetShelter(String name, String description) {
        this.name = name;
        this.animals = new ArrayList<VirtualPet>();
        this.description = description;
    }

    public ArrayList<VirtualPet> getAnimals() {
        return this.animals;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getLitterbox() {
        return this.litterbox;
    }

    public void setLitterbox(int litterbox) {
        this.litterbox = litterbox;
    }

    public void add(VirtualPet adoptee) {
        this.animals.add(adoptee);
    }

    public void remove(VirtualPet adoptee) {
        this.animals.remove(adoptee);
    }

    public void clear() {
        this.animals = new ArrayList<VirtualPet>();
    }

    public VirtualPet getPet(String name) {
        for (VirtualPet currPet : this.getAnimals()) {
            if (currPet.getName().equals(name)) {
                return currPet;
            }
        }
        return null;
    }
}