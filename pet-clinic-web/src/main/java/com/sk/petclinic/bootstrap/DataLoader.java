package com.sk.petclinic.bootstrap;

import com.sk.petclinic.model.*;
import com.sk.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);
        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 jp nagar");
        owner1.setCity("Bangalore");
        owner1.setTelephone("9988776655");

        Pet miPet = new Pet();
        miPet.setPetType(saveDogPetType);
        miPet.setOwner(owner1);
        miPet.setBirthDate(LocalDate.now());
        miPet.setName("dogg");
        owner1.getPets().add(miPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenn");
        owner2.setAddress("123 jp nagar");
        owner2.setCity("Bangalore");
        owner2.setTelephone("9988776655");
        Pet fiPet = new Pet();
        fiPet.setPetType(saveCatPetType);
        fiPet.setOwner(owner2);
        fiPet.setBirthDate(LocalDate.now());
        fiPet.setName("catt");
        owner2.getPets().add(fiPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fiPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("sneezy kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
