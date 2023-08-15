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

import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.service.RoboDogService;

@RestController
public class RoboDogController {

    @Autowired
    RoboDogService RoboDogServ;

    @PostMapping("/new/RoboDog")
    public void addRoboDog(@RequestBody RoboDog RoboDog) {
        this.RoboDogServ.createRoboDog(RoboDog);
    }

    @GetMapping("/RoboDogs")
    public List<RoboDog> findAllRoboDogs() {
        return this.RoboDogServ.getAllRoboDogs();
    }

    @GetMapping("/RoboDogs/{id}")
    public RoboDog findRoboDogById(@PathVariable String id) {
        return this.RoboDogServ.getRoboDogById(id);
    }

    @PutMapping("/RoboDog/{id}")
    public RoboDog modifyRoboDog(@PathVariable String id, @RequestBody RoboDog updatedRoboDog) {
        return this.RoboDogServ.updateRoboDog(id, updatedRoboDog);
    }

    @DeleteMapping("/delete/RoboDog/{id}")
    public void removeRoboDog(@PathVariable String id) {
        this.RoboDogServ.deleteRoboDogById(id);
    }
}
