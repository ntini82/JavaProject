package com.sk.petclinic.bootstrap;

import com.sk.petclinic.model.Owner;
import com.sk.petclinic.model.Pet;
import com.sk.petclinic.model.PetType;
import com.sk.petclinic.model.Vet;
import com.sk.petclinic.services.OwnerService;
import com.sk.petclinic.services.PetTypeService;
import com.sk.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets");


    }
}
