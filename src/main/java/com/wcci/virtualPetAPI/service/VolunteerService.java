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
        this.volunteerRepository.save(null);
    }

    // Fetch all volunteers

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    // Fetch volunteer by name
    public Volunteer getVolunteerByID(String name) {
        Optional<Volunteer> volunteer = volunteerRepository.findById(name);
        return volunteer.orElse(null);
    }

    // Add a new volunteer
    public Volunteer addVolunteer(Volunteer volunteer) {
        // Here, you can add any business logic before saving the volunteer.
        return volunteerRepository.save(volunteer);
    }

    // Delete a volunteer by ID
    public void deleteVolunteer(String id) {
        volunteerRepository.deleteById(id);
    }

    // Update a volunteer
    public Volunteer updateVolunteer(Volunteer volunteer) {
        if (volunteerRepository.existsById(volunteer.getName())) {
            return volunteerRepository.save(volunteer);
        }
        return null;
    }
}
