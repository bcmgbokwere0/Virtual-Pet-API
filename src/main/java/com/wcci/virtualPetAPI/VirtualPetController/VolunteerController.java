package com.wcci.virtualPetAPI.VirtualPetController;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerRepository volunteerRepository;

    // New volunteer
    @PostMapping("/new")
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    // Find volunteers
    @GetMapping("/findall")
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    // Find volunteer by name/ id?
    @GetMapping("/{name}")
    public Volunteer getVolunteerByName(@PathVariable String name) {
        return volunteerRepository.getVolunteerById(name);
    }

    // Update existing volunteer
    @PutMapping("/modify/{id}")
    public Volunteer modifyVolunteer(@PathVariable String id, @RequestBody Volunteer updateVolunteer) {
        return this.volunteerRepository.updateVolunteer(id, updateVolunteer);
    }

    // Delete volunteer
    @DeleteMapping("/delete/{id}")
    public void removeVolunteer(@PathVariable String id) {
        this.volunteerRepository.deleteById(id);
    }
}
