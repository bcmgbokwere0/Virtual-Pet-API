package com.wcci.virtualPetAPI.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.repository.RoboticDogRepository;

@Service
public class RoboDogService {

    @Autowired
    private RoboticDogRepository RDogRepository;

    /*
     * Adds a new RoboDog to the repository (db). The "C" (create) in CRUD
     */
    public void createRoboDog(RoboDog animal) {
        this.RDogRepository.save(animal);
    }

    /*
     * Gets all the RoboDogs in the repo (db). The "R" (read) in CRUD
     */
    public List<RoboDog> getAllRoboDogs() {
        return RDogRepository.findAll();
    }

    /*
     * Gets a specific RoboDog by its id. The "R" (read) in CRUD
     */
    public RoboDog getRoboDogById(String id) {

        Optional<RoboDog> Ocat = RDogRepository.findById(id);
        if (Ocat.isPresent()) {
            return Ocat.get();
        }
        return null;
    }

    /*
     * Updates an existing RoboDog, found by a specific id. The "U" (update) in
     * CRUD
     */
    public RoboDog updateRoboDog(String id, RoboDog updatedVpet) {
        RoboDog existingAnimal = getRoboDogById(id);

        if (existingAnimal != null) {
            existingAnimal.setBladder(updatedVpet.getBladder());
            existingAnimal.setDescription(updatedVpet.getDescription());
            existingAnimal.setExercise(updatedVpet.getExercise());
            existingAnimal.setHappiness(updatedVpet.getHappiness());
            existingAnimal.setOil(updatedVpet.getOil());
            existingAnimal.setCage(updatedVpet.getCage());
            RDogRepository.save(existingAnimal);
        }

        return null; // Return null if the animal with the given ID is not found
    }

    /*
     * Delete a RoboDog from the repo. The "D" (delete) in CRUD
     */
    public boolean deleteRoboDogById(String id) {
        if (RDogRepository.existsById(id)) {
            RDogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
