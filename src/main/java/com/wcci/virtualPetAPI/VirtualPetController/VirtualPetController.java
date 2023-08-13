package com.wcci.virtualPetAPI.VirtualPetController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.entity.VirtualPet;
import com.wcci.virtualPetAPI.service.VirtualPetService;

@RestController
public class VirtualPetController {

    @Autowired
    VirtualPetService virtualPetServ;

    @PostMapping("/new/organicCat")
    public void addVirtualPet(@RequestBody OrganicCat VirtualPet) {
        this.virtualPetServ.createVirtualPet(VirtualPet);
    }

    @PostMapping("/new/roboCat")
    public void addVirtualPet(@RequestBody RoboCat VirtualPet) {
        this.virtualPetServ.createVirtualPet(VirtualPet);
    }

    @PostMapping("/new/organicDog")
    public void addVirtualPet(@RequestBody OrganicDog VirtualPet) {
        this.virtualPetServ.createVirtualPet(VirtualPet);
    }

    @PostMapping("/new/roboDog")
    public void addVirtualPet(@RequestBody RoboDog VirtualPet) {
        this.virtualPetServ.createVirtualPet(VirtualPet);
    }

    @GetMapping("/VirtualPets")
    public List<VirtualPet> findAllVirtualPets() {
        return this.virtualPetServ.getAllVirtualPets();
    }

    @GetMapping("/VirtualPet/{id}")
    public VirtualPet findVirtualPetById(@PathVariable String id) {
        return this.virtualPetServ.getVirtualPetById(id);
    }

    @PutMapping("/VirtualPet/{id}")
    public VirtualPet modifyVirtualPet(@PathVariable String id, @RequestBody VirtualPet updatedVirtualPet) {
        return this.virtualPetServ.updateVirtualPet(id, updatedVirtualPet);
    }

    @DeleteMapping("/delete/Ocat/{id}")
    public void removeOrganicCat(@PathVariable String id) {
        this.virtualPetServ.deleteOrganicCatById(id);
    }

    @DeleteMapping("/delete/Rcat/{id}")
    public void removeRoboticCat(@PathVariable String id) {
        this.virtualPetServ.deleteRoboticCatById(id);
    }

    @DeleteMapping("/delete/Odog/{id}")
    public void removeOrganicDog(@PathVariable String id) {
        this.virtualPetServ.deleteOrganicDogById(id);
    }

    @DeleteMapping("/delete/Rdog/{id}")
    public void removeRoboticDog(@PathVariable String id) {
        this.virtualPetServ.deleteRoboticDogById(id);
    }
}
