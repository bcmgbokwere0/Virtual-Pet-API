package com.wcci.virtualPetAPI;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboCat;
import com.wcci.virtualPetAPI.entity.RoboDog;
import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.entity.virtualPetShelter;
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

        ArrayList<RoboDog> Rdoglist = new ArrayList<RoboDog>();
        ArrayList<RoboCat> Rcatlist = new ArrayList<RoboCat>();
        ArrayList<OrganicCat> Ocatlist = new ArrayList<OrganicCat>();
        ArrayList<OrganicDog> Odoglist = new ArrayList<OrganicDog>();
        ArrayList<Volunteer> vlist = new ArrayList<Volunteer>();
        virtualPetShelter tShelter = new virtualPetShelter("Avalon", "King Arthurs Pets", 0, Ocatlist, Odoglist,
                Rdoglist, Rcatlist, vlist);
        ArrayList<virtualPetShelter> vlist1 = new ArrayList<virtualPetShelter>();
        ArrayList<virtualPetShelter> vlist2 = new ArrayList<virtualPetShelter>();
        vlist1.add(tShelter);

        OrganicCat cat1 = new OrganicCat("Timmy", "An orange Cat", tShelter);
        OrganicCat cat2 = new OrganicCat("Jimmy", "A black Cat", tShelter);
        OcatRepository.save(cat1);
        OcatRepository.save(cat2);
        Ocatlist.add(cat1);
        Ocatlist.add(cat2);

        RoboCat cat3 = new RoboCat("Kimmy", "A Gear Cat", tShelter);
        RoboCat cat4 = new RoboCat("Wimmy", "A Cyborg Cat", tShelter);
        RcatRepository.save(cat3);
        RcatRepository.save(cat4);
        Rcatlist.add(cat3);
        Rcatlist.add(cat4);

        OrganicDog Dog1 = new OrganicDog("Timmy", "An orange Dog", tShelter);
        OrganicDog Dog2 = new OrganicDog("Jimmy", "A black Dog", tShelter);
        OdogRepository.save(Dog1);
        OdogRepository.save(Dog2);
        Odoglist.add(Dog1);
        Odoglist.add(Dog2);

        RoboDog Dog3 = new RoboDog("Kimmy", "A Gear Dog", tShelter);
        RoboDog Dog4 = new RoboDog("Wimmy", "A Cyborg Dog", tShelter);
        RdogRepository.save(Dog3);
        RdogRepository.save(Dog4);
        Rdoglist.add(Dog3);
        Rdoglist.add(Dog4);

        Volunteer vol1 = new Volunteer("Kimmy", "Wimpy Volunteer", "Pain@yahoo.com", vlist1);
        Volunteer vol2 = new Volunteer("Timmy", "Great Volunteer", "Pain@hotmail.com", vlist2);
        voltRepository.save(vol1);
        voltRepository.save(vol2);
    }
}
