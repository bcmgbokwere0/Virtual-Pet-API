package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.entity.VirtualPet;

@Repository
public interface RoboticCatRepository extends JpaRepository<RoboCat, String> {

}
