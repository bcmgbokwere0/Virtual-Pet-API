package com.wcci.virtualPetAPI.service;

<<<<<<<HEAD

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    <<<<<<<HEAD

    public void createVolunteer(Volunteer volunteer) {
        this.volunteerRepository.save(null);
    }

    =======
    // Fetch all volunteers
    >>>>>>>dfdc041d08ccb633e4a8e52f836979ef00a22c43

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    <<<<<<<HEAD

    public Volunteer getVolunteerById(String id) {
        return null;
    }

    public Volunteer updateVolunteer(String id, Volunteer Volunteer) {
        Volunteer existingVolunteer = getVolunteerById(id);

        if (existingVolunteer != null) {
            existingVolunteer.setName(updateVolunteer.getName());
            if (existingVolunteer instanceof Volunteer) {
                VolunteerRepository.save((Volunteer) existingVolunteer);
            }
        }
        return null;
    }

    public void deleteVolunteerById(String id) {
        VolunteerRepository.deleteById(id);
    }

}=======

    // Fetch volunteer by name
    public Volunteer getVolunteerByName(String name) {
        return volunteerRepository.findByName(name);
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
        if(volunteerRepository.existsById(volunteer.getName())) {
            return volunteerRepository.save(volunteer);
        }
        return null; 
    }

}>>>>>>>dfdc041d08ccb633e4a8e52f836979ef00a22c43
