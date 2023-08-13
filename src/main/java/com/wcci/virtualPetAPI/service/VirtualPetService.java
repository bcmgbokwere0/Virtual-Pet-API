package com.wcci.virtualPetAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.entity.VirtualPet;
import com.wcci.virtualPetAPI.repository.OrganicCatRepository;
import com.wcci.virtualPetAPI.repository.OrganicDogRepository;
import com.wcci.virtualPetAPI.repository.RoboticCatRepository;
import com.wcci.virtualPetAPI.repository.RoboticDogRepository;

@Service
public class VirtualPetService {

    @Autowired
    private OrganicCatRepository OcatRepository;
    private OrganicDogRepository OdogRepository;
    private RoboticCatRepository RcatRepository;
    private RoboticDogRepository RdogRepository;

    public VirtualPetService(
            OrganicCatRepository OcatRepository,
            OrganicDogRepository OdogRepository,
            RoboticCatRepository RcatRepository,
            RoboticDogRepository RdogRepository) {
        this.OcatRepository = OcatRepository;
        this.OdogRepository = OdogRepository;
        this.RcatRepository = RcatRepository;
        this.RdogRepository = RdogRepository;
    }

    /*
     * Adds a new VirtualPet to the repository (db). The "C" (create) in CRUD
     */
    public void createVirtualPet(OrganicCat animal) {
        this.OcatRepository.save(animal);
    }

    public void createVirtualPet(RoboCat animal) {
        this.RcatRepository.save(animal);
    }

    public void createVirtualPet(OrganicDog animal) {
        this.OdogRepository.save(animal);
    }

    public void createVirtualPet(RoboDog animal) {
        this.RdogRepository.save(animal);
    }

    /*
     * Gets all the VirtualPets in the repo (db). The "R" (read) in CRUD
     */
    public List<VirtualPet> getAllVirtualPets() {
        List<VirtualPet> allAnimals = new ArrayList<>();
        List<OrganicDog> Odogs = OdogRepository.findAll();
        List<RoboDog> Rdogs = RdogRepository.findAll();
        List<OrganicCat> Ocats = OcatRepository.findAll();
        List<RoboCat> Rcats = RcatRepository.findAll();
        // Convert Dog list to VirtualPet list
        for (OrganicDog dog : Odogs) {
            allAnimals.add(dog);
        }
        for (RoboDog dog : Rdogs) {
            allAnimals.add(dog);
        }
        for (OrganicCat cat : Ocats) {
            allAnimals.add(cat);
        }
        for (RoboCat cat : Rcats) {
            allAnimals.add(cat);
        }
        return allAnimals;
    }

    /*
     * Gets a specific VirtualPet by its id. The "R" (read) in CRUD
     */
    public VirtualPet getVirtualPetById(String id) {
        Optional<OrganicDog> Odog = OdogRepository.findById(id);
        if (Odog.isPresent()) {
            return Odog.get();
        }
        Optional<RoboDog> Rdog = RdogRepository.findById(id);
        if (Rdog.isPresent()) {
            return Odog.get();
        }

        Optional<OrganicCat> Ocat = OcatRepository.findById(id);
        if (Ocat.isPresent()) {
            return Ocat.get();
        }
        Optional<RoboCat> Rcat = RcatRepository.findById(id);
        return Rcat.orElse(null);
    }

    /*
     * Updates an existing VirtualPet, found by a specific id. The "U" (update) in
     * CRUD
     */
    public VirtualPet updateVirtualPet(String id, VirtualPet updatedVpet) {
        VirtualPet existingAnimal = getVirtualPetById(id);

        if (existingAnimal != null) {
            existingAnimal.setName(updatedVpet.getName());

            if (existingAnimal instanceof OrganicDog) {
                return OdogRepository.save((OrganicDog) existingAnimal);
            } else if (existingAnimal instanceof RoboDog) {
                return RdogRepository.save((RoboDog) existingAnimal);
            } else if (existingAnimal instanceof OrganicCat) {
                return OcatRepository.save((OrganicCat) existingAnimal);
            } else {
                return RcatRepository.save((RoboCat) existingAnimal);
            }
        }

        return null; // Return null if the animal with the given ID is not found
    }

    /*
     * Delete a VirtualPet from the repo. The "D" (delete) in CRUD
     */
    public void deleteVirtualPet(String id) {
        this.OcatRepository.deleteById(id);
        this.RcatRepository.deleteById(id);
        this.OdogRepository.deleteById(id);
        this.RdogRepository.deleteById(id);
    }
}
