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

import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.service.OrganicDogService;

@RestController
public class OrganicDogController {

    @Autowired
    OrganicDogService OrganicDogServ;

    @PostMapping("/new/OrganicDog")
    public void addOrganicDog(@RequestBody OrganicDog OrganicDog) {
        this.OrganicDogServ.createOrganicDog(OrganicDog);
    }

    @GetMapping("/OrganicDogs")
    public List<OrganicDog> findAllOrganicDogs() {
        return this.OrganicDogServ.getAllOrganicDogs();
    }

    @GetMapping("/OrganicDogs/{id}")
    public OrganicDog findOrganicDogById(@PathVariable String id) {
        return this.OrganicDogServ.getOrganicDogById(id);
    }

    @PutMapping("/OrganicDog/{id}")
    public OrganicDog modifyOrganicDog(@PathVariable String id, @RequestBody OrganicDog updatedOrganicDog) {
        return this.OrganicDogServ.updateOrganicDog(id, updatedOrganicDog);
    }

    @DeleteMapping("/delete/OrganicDog/{id}")
    public void removeOrganicDog(@PathVariable String id) {
        this.OrganicDogServ.deleteOrganicDogById(id);
    }
}
