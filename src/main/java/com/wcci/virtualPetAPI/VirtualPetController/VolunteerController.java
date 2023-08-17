package com.wcci.virtualPetAPI.VirtualPetController;

<<<<<<<HEAD

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

}>>>>>>>dfdc041d08ccb633e4a8e52f836979ef00a22c43
