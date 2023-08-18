package com.wcci.virtualPetAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wcci.virtualPetAPI.entity.VirtualPetShelter;
import com.wcci.virtualPetAPI.repository.ShelterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    public VirtualPetShelter createShelter(VirtualPetShelter shelter) {
        return shelterRepository.save(shelter);
    }

    public List<VirtualPetShelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    public VirtualPetShelter getShelterById(String id) {
        Optional<VirtualPetShelter> shelter = shelterRepository.findById(id);
        if (shelter.isPresent()) {
            return shelter.get();
        }
        return null;
    }

    public VirtualPetShelter updateShelter(String id, VirtualPetShelter shelter) {
        VirtualPetShelter existingShelter = getShelterById(id);

        if (existingShelter != null) {
            existingShelter.setDescription(shelter.getDescription());
            existingShelter.setLitterbox(shelter.getLitterbox());
            existingShelter.setOcat(shelter.getOcat());
            existingShelter.setOdog(shelter.getOdog());
            existingShelter.setRcat(shelter.getRcat());
            existingShelter.setRdog(shelter.getRdog());
            existingShelter.setVolunteers(shelter.getVolunteers());
            return shelterRepository.save(shelter);
        }
        return null;
    }

    public boolean deleteShelter(String id) {
        if (shelterRepository.existsById(id)) {
            shelterRepository.deleteById(id);
            return true;
        }
        return false;
    }

}