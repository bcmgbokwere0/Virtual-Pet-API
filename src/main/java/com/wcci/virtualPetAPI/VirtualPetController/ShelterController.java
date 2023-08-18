package com.wcci.virtualPetAPI.VirtualPetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wcci.virtualPetAPI.entity.VirtualPetShelter;
import com.wcci.virtualPetAPI.service.ShelterService;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping("/findall")
    public List<VirtualPetShelter> findAllShelters() {
        return shelterService.getAllShelters();
    }

    @GetMapping("/{id}")
    public VirtualPetShelter getShelterById(@PathVariable String id) {
        return shelterService.getShelterById(id);
    }

    @PostMapping("/new")
    public VirtualPetShelter createShelter(@RequestBody VirtualPetShelter shelter) {
        return shelterService.createShelter(shelter);
    }

    @PutMapping("/modify/{id}")
    public VirtualPetShelter updateShelter(@PathVariable String id, @RequestBody VirtualPetShelter shelter) {
        return shelterService.updateShelter(id, shelter);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShelter(@PathVariable String id) {
        shelterService.deleteShelter(id);
    }
}