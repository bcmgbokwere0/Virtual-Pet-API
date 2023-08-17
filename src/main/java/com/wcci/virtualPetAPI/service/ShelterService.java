package com.wcci.virtualPetAPI.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcci.virtualPetAPI.entity.virtualPetShelter;
import com.wcci.virtualPetAPI.repository.ShelterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    // Retrieve all shelters
    public List<virtualPetShelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    // Retrieve a specific shelter by ID
    public virtualPetShelter getShelterById(String id) {
        Optional<virtualPetShelter> optionalShelter = shelterRepository.findById(id);
        return optionalShelter.orElse(null);
    }

    // Add a new shelter
    public virtualPetShelter addShelter(virtualPetShelter shelter) {
        return shelterRepository.save(shelter);
    }

    // Update an existing shelter
    public virtualPetShelter updateShelter(virtualPetShelter shelter) {
        if (shelterRepository.existsById(shelter.getName())) {
            return shelterRepository.save(shelter);
        }
        return null;
    }

    // Delete a specific shelter by ID
    public boolean deleteShelter(String id) {
        if (shelterRepository.existsById(id)) {
            shelterRepository.deleteById(id);
            return true;
        }
        return false;
    }


}