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

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.service.OrganicCatService;

@RestController
@RequestMapping("/ocat")
public class OrganicCatController {

    @Autowired
    OrganicCatService OrganicCatServ;

    @PostMapping("/new")
    public void addOrganicCat(@RequestBody OrganicCat OrganicCat) {
        this.OrganicCatServ.createOrganicCat(OrganicCat);
    }

    @GetMapping("/findall")
    public List<OrganicCat> findAllOrganicCats() {
        return this.OrganicCatServ.getAllOrganicCats();
    }

    @GetMapping("/{id}")
    public OrganicCat findOrganicCatById(@PathVariable String id) {
        return this.OrganicCatServ.getOrganicCatById(id);
    }

    @PutMapping("/modify/{id}")
    public OrganicCat modifyOrganicCat(@PathVariable String id, @RequestBody OrganicCat updatedOrganicCat) {
        return this.OrganicCatServ.updateOrganicCat(id, updatedOrganicCat);
    }

    @DeleteMapping("/delete/{id}")
    public void removeOrganicCat(@PathVariable String id) {
        this.OrganicCatServ.deleteOrganicCatById(id);
    }
}
