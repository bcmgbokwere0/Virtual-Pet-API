package com.wcci.virtualPetAPI.VirtualPetController;

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
import com.wcci.virtualPetAPI.service.VolunteerService;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    VolunteerService volunteerService;

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
    @GetMapping("/{id}")
    public Volunteer findVolunteerById(@PathVariable String id) {
        return volunteerRepository.findById(id).get();
    }

    // Update existing volunteer
    @PutMapping("/modify/{id}")
    public Volunteer modifyVolunteer(@PathVariable String id, @RequestBody Volunteer updateV) {

        return this.volunteerService.updateVolunteer(id, updateV);
    }

    // Delete volunteer
    @DeleteMapping("/delete/{id}")
    public void removeVolunteer(@PathVariable String id) {
        this.volunteerRepository.deleteById(id);
    }
}
