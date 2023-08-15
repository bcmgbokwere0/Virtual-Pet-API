package com.wcci.virtualPetAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.repository.OrganicDogRepository;

@Service
public class OrganicDogService {

    @Autowired
    private OrganicDogRepository OdogRepository;

    /*
     * Adds a new OrganicDog to the repository (db). The "C" (create) in CRUD
     */
    public void createOrganicDog(OrganicDog animal) {
        this.OdogRepository.save(animal);
    }

    /*
     * Gets all the OrganicDogs in the repo (db). The "R" (read) in CRUD
     */
    public List<OrganicDog> getAllOrganicDogs() {
        return OdogRepository.findAll();
    }

    /*
     * Gets a specific OrganicDog by its id. The "R" (read) in CRUD
     */
    public OrganicDog getOrganicDogById(String id) {

        Optional<OrganicDog> Ocat = OdogRepository.findById(id);
        if (Ocat.isPresent()) {
            return Ocat.get();
        }
        return null;
    }

    /*
     * Updates an existing OrganicDog, found by a specific id. The "U" (update) in
     * CRUD
     */
    public OrganicDog updateOrganicDog(String id, OrganicDog updatedVpet) {
        OrganicDog existingAnimal = getOrganicDogById(id);

        if (existingAnimal != null) {
            existingAnimal.setName(updatedVpet.getName());
            if (existingAnimal instanceof OrganicDog) {
                OdogRepository.save((OrganicDog) existingAnimal);
            }
        }

        return null; // Return null if the animal with the given ID is not found
    }

    /*
     * Delete a OrganicDog from the repo. The "D" (delete) in CRUD
     */
    public void deleteOrganicDogById(String id) {
        OdogRepository.deleteById(id);
    }
}
