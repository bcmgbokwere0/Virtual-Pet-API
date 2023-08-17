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

import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.service.RoboDogService;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    Volunteer volunteerService;

    @PostMapping("/new")
    public void addVolunteer(@RequestBody Volunteer Volunteer) {
        this.volunteerService.createVolunteer(Volunteer);
    }

    @GetMapping("/findall")
    public List<Volunteer> findAllVolunteers() {
        return this.volunteerService.getAllVolunteers();
    }

    @GetMapping("/{id}")
    public Volunteer findVolunteerById(@PathVariable String id) {
        return this.volunteerService.getVolunteerById(id);
    }

    @PutMapping("/modify/{id}")
    public Volunteer modifyVolunteer(@PathVariable String id, @RequestBody Volunteer updateVolunteer) {
        return this.volunteerService.updateVolunteer(id, updateVolunteer);
    }

    @DeleteMapping("/delete/{id}")
    public void removeVolunteer(@PathVariable String id) {
        this.volunteerService.deleteVolunteer(id);
    }
}
