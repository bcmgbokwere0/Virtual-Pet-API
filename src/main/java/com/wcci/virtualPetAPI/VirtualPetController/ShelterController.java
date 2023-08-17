package com.wcci.virtualPetAPI.VirtualPetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wcci.virtualPetAPI.entity.virtualPetShelter;
import com.wcci.virtualPetAPI.service.ShelterService;

import java.util.List;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    // Fetch all shelters
    @GetMapping("/findall")
    public ResponseEntity<List<virtualPetShelter>> getAllShelters() {
        List<virtualPetShelter> shelters = shelterService.getAllShelters();
        return new ResponseEntity<>(shelters, HttpStatus.OK);
    }

    // Fetch by ID
    @GetMapping("/{id}")
    public ResponseEntity<virtualPetShelter> getShelterById(@PathVariable String id) {
        virtualPetShelter shelter = shelterService.getShelterById(id);
        if (shelter != null) {
            return new ResponseEntity<>(shelter, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new shelter
    @PostMapping("/new")
    public ResponseEntity<virtualPetShelter> createShelter(@RequestBody virtualPetShelter shelter) {
        virtualPetShelter newShelter = shelterService.addShelter(shelter);
        return new ResponseEntity<>(newShelter, HttpStatus.CREATED);
    }

    // Update an existing shelter
    @PutMapping("/modify/{id}")
    public ResponseEntity<virtualPetShelter> updateShelter(@PathVariable Long id, @RequestBody virtualPetShelter shelter) {
        virtualPetShelter updatedShelter = shelterService.updateShelter(shelter);
        if (updatedShelter != null) {
            return new ResponseEntity<>(updatedShelter, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a shelter
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShelter(@PathVariable String id) {
        if (shelterService.deleteShelter(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}