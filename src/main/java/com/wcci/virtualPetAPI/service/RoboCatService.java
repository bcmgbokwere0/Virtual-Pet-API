package com.wcci.virtualPetAPI.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.repository.RoboticCatRepository;

@Service
public class RoboCatService {

    @Autowired
    private RoboticCatRepository RCatRepository;

    /*
     * Adds a new RoboCat to the repository (db). The "C" (create) in CRUD
     */
    public void createRoboCat(RoboCat animal) {
        this.RCatRepository.save(animal);
    }

    /*
     * Gets all the RoboCats in the repo (db). The "R" (read) in CRUD
     */
    public List<RoboCat> getAllRoboCats() {
        return RCatRepository.findAll();
    }

    /*
     * Gets a specific RoboCat by its id. The "R" (read) in CRUD
     */
    public RoboCat getRoboCatById(String id) {

        Optional<RoboCat> Ocat = RCatRepository.findById(id);
        if (Ocat.isPresent()) {
            return Ocat.get();
        }
        return null;
    }

    /*
     * Updates an existing RoboCat, found by a specific id. The "U" (update) in
     * CRUD
     */
    public RoboCat updateRoboCat(String id, RoboCat updatedVpet) {
        RoboCat existingAnimal = getRoboCatById(id);

        if (existingAnimal != null) {
            existingAnimal.setName(updatedVpet.getName());
            if (existingAnimal instanceof RoboCat) {
                RCatRepository.save((RoboCat) existingAnimal);
            }
        }

        return null; // Return null if the animal with the given ID is not found
    }

    /*
     * Delete a RoboCat from the repo. The "D" (delete) in CRUD
     */
    public void deleteRoboCatById(String id) {
        RCatRepository.deleteById(id);
    }
}
