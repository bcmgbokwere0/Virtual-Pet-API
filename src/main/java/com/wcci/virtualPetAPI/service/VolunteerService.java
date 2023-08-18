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
        this.volunteerRepository.save(volunteer);
    }

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public Volunteer getVolunteerById(String id) {
        Optional<Volunteer> volunteer = volunteerRepository.findById(id);
        if (volunteer.isPresent()) {
            return volunteer.get();
        }
        return null;
    }

    public Volunteer updateVolunteer(String id, Volunteer updatedV) {
        Volunteer existingVolunteer = getVolunteerById(id);

        if (existingVolunteer != null) {
            existingVolunteer.setEmail(updatedV.getEmail());
            existingVolunteer.setDescription((updatedV.getDescription()));
            return volunteerRepository.save(updatedV);
        }
        return null;
    }

    public boolean deleteVolunteerById(String id) {
        if (volunteerRepository.existsById(id)) {
            volunteerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
