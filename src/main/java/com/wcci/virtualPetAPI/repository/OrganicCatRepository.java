package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wcci.virtualPetAPI.entity.OrganicCat;

@Repository
public interface OrganicCatRepository extends JpaRepository<OrganicCat, String> {

}
