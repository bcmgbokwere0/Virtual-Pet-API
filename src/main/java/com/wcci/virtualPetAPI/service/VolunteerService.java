package com.wcci.virtualPetAPI.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.entity.virtualPetShelter;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public void createVolunteer(Volunteer volunteer) {
        this.volunteerRepository.save(volunteer);
    }
  
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }
    // Find volunteer by ID
    public Volunteer getVolunteerById(String id) {
        Optional<Volunteer> optionalVolunteer = volunteerRepository.findById(id);
        return optionalVolunteer.orElseThrow();
    }

    // Update existing volunteer
    public Volunteer updateVolunteer(Volunteer volunteer) {
        if (volunteerRepository.existsById(volunteer.getName())) {
            return volunteerRepository.save(volunteer);
        }
        return null;
    }

    // Delete a volunteer
    public boolean deleteVolunteerById(String id) {
        if (volunteerRepository.existsById(id))
            ;
        {
            volunteerRepository.deleteById(id);
            return true;
        }
    }
}
