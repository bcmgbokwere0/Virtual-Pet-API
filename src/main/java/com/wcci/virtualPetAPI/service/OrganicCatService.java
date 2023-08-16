package com.wcci.virtualPetAPI.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.repository.OrganicCatRepository;

@Service
public class OrganicCatService {

    @Autowired
    private OrganicCatRepository OcatRepository;

    /*
     * Adds a new OrganicCat to the repository (db). The "C" (create) in CRUD
     */
    public void createOrganicCat(OrganicCat animal) {
        this.OcatRepository.save(animal);
    }

    /*
     * Gets all the OrganicCats in the repo (db). The "R" (read) in CRUD
     */
    public List<OrganicCat> getAllOrganicCats() {
        return OcatRepository.findAll();
    }

    /*
     * Gets a specific OrganicCat by its id. The "R" (read) in CRUD
     */
    public OrganicCat getOrganicCatById(String id) {

        Optional<OrganicCat> Ocat = OcatRepository.findById(id);
        if (Ocat.isPresent()) {
            return Ocat.get();
        }
        return null;
    }

    /*
     * Updates an existing OrganicCat, found by a specific id. The "U" (update) in
     * CRUD
     */
    public OrganicCat updateOrganicCat(String id, OrganicCat updatedVpet) {
        OrganicCat existingAnimal = getOrganicCatById(id);

        if (existingAnimal != null) {
            existingAnimal.setName(updatedVpet.getName());
            if (existingAnimal instanceof OrganicCat) {
                OcatRepository.save((OrganicCat) existingAnimal);
            }
        }

        return null; // Return null if the animal with the given ID is not found
    }

    /*
     * Delete a OrganicCat from the repo. The "D" (delete) in CRUD
     */
    public void deleteOrganicCatById(String id) {
        OcatRepository.deleteById(id);
    }
}
