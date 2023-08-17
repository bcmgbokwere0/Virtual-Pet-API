package com.wcci.virtualPetAPI.service;

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

    public void createVolunteer(Volunteer volunteer) {
        this.volunteerRepository.save(null);
    }

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

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
}
