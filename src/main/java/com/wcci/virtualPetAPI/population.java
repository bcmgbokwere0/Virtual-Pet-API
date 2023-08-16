package com.wcci.virtualPetAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.repository.OrganicCatRepository;
import com.wcci.virtualPetAPI.repository.OrganicDogRepository;
import com.wcci.virtualPetAPI.repository.RoboticCatRepository;
import com.wcci.virtualPetAPI.repository.RoboticDogRepository;

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

    @Override
    public void run(String... args) throws Exception {
        OrganicCat cat1 = new OrganicCat("Timmy", "An orange Cat");
        OcatRepository.save(cat1);

        OrganicDog dog1 = new OrganicDog("Sally", "A black lab");
        OdogRepository.save(dog1);

        RoboCat cat2 = new RoboCat("Jimmy", "A robo Cat");
        RcatRepository.save(cat2);

        RoboDog dog2 = new RoboDog("Salley", "A robo lab");
        RdogRepository.save(dog2);
    }
}
