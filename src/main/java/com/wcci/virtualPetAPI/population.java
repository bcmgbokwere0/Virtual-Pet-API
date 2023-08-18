package com.wcci.virtualPetAPI;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.entity.VirtualPetShelter;
import com.wcci.virtualPetAPI.repository.OrganicCatRepository;
import com.wcci.virtualPetAPI.repository.OrganicDogRepository;
import com.wcci.virtualPetAPI.repository.RoboticCatRepository;
import com.wcci.virtualPetAPI.repository.RoboticDogRepository;
import com.wcci.virtualPetAPI.repository.ShelterRepository;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@Component
public class population implements CommandLineRunner {
    @Autowired
    private OrganicCatRepository OcatRepository;
    @Autowired
    private OrganicDogRepository OdogRepository;
    @Autowired
    private RoboticCatRepository RcatRepository;
    @Autowired
    private RoboticDogRepository RdogRepository;
    @Autowired
    private ShelterRepository SheltRespository;
    @Autowired
    private VolunteerRepository voltRepository;

    @Override
    public void run(String... args) throws Exception {

        VirtualPetShelter tShelter = new VirtualPetShelter("Avalon", "King Arthur's Pets");
        SheltRespository.save(tShelter);

        OrganicCat cat1 = new OrganicCat("Timmy", "An orange Cat", tShelter);
        OrganicCat cat2 = new OrganicCat("Jimmy", "A black Cat", tShelter);

        RoboCat cat3 = new RoboCat("Kimmy", "A Gear Cat", tShelter);
        RoboCat cat4 = new RoboCat("Wimmy", "A Cyborg Cat", tShelter);

        OrganicDog dog1 = new OrganicDog("Timmy", "An orange Dog", tShelter);
        OrganicDog dog2 = new OrganicDog("Jimmy", "A black Dog", tShelter);

        RoboDog dog3 = new RoboDog("Kimmy", "A Gear Dog", tShelter);
        RoboDog dog4 = new RoboDog("Wimmy", "A Cyborg Dog", tShelter);

        Volunteer vol1 = new Volunteer("Kimmy", "Wimpy Volunteer", "Pain@yahoo.com");
        Volunteer vol2 = new Volunteer("Timmy", "Great Volunteer", "Pain@hotmail.com");

        vol1.addShelter(tShelter);
        vol2.addShelter(tShelter);
        tShelter.addVolunteers(vol1);
        tShelter.addVolunteers(vol2);

        voltRepository.saveAll(Arrays.asList(vol1, vol2));
        SheltRespository.save(tShelter);
        OcatRepository.saveAll(Arrays.asList(cat1, cat2));
        RcatRepository.saveAll(Arrays.asList(cat3, cat4));
        OdogRepository.saveAll(Arrays.asList(dog1, dog2));
        RdogRepository.saveAll(Arrays.asList(dog3, dog4));

    }
}
