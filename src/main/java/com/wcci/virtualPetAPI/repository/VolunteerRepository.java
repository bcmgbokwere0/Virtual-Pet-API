package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entity.Volunteer;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, String> {
    Volunteer getVolunteerById(String id);

    Volunteer updateVoluteer(String id, Volunteer updateVolunteer);
}