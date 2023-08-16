package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wcci.virtualPetAPI.entity.OrganicDog;

@Repository
public interface OrganicDogRepository extends JpaRepository<OrganicDog, String> {

}
