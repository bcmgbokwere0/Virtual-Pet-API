package com.wcci.virtualPetAPI.VirtualPetController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.service.RoboCatService;

@RestController
public class RoboCatController {

    @Autowired
    RoboCatService RoboCatServ;

    @PostMapping("/new/RoboCat")
    public void addRoboCat(@RequestBody RoboCat RoboCat) {
        this.RoboCatServ.createRoboCat(RoboCat);
    }

    @GetMapping("/RoboCats")
    public List<RoboCat> findAllRoboCats() {
        return this.RoboCatServ.getAllRoboCats();
    }

    @GetMapping("/RoboCats/{id}")
    public RoboCat findRoboCatById(@PathVariable String id) {
        return this.RoboCatServ.getRoboCatById(id);
    }

    @PutMapping("/RoboCat/{id}")
    public RoboCat modifyRoboCat(@PathVariable String id, @RequestBody RoboCat updatedRoboCat) {
        return this.RoboCatServ.updateRoboCat(id, updatedRoboCat);
    }

    @DeleteMapping("/delete/RoboCat/{id}")
    public void removeRoboCat(@PathVariable String id) {
        this.RoboCatServ.deleteRoboCatById(id);
    }
}
