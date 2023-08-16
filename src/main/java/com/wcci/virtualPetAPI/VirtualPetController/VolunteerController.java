package com.wcci.virtualPetAPI.VirtualPetController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {
    
    @Autowired
    private VolunteerRepository volunteerRepository;

    @GetMapping("/getall")
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @GetMapping("/{name}")
    public Volunteer getVolunteerByName(@PathVariable String name) {
        return volunteerRepository.findByName(name);
    }

    @PostMapping("/new")
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

}