package oleksandr.spring5.petclinicdemo.bootstrap;

import oleksandr.spring5.petclinicdemo.model.Owner;
import oleksandr.spring5.petclinicdemo.model.Pet;
import oleksandr.spring5.petclinicdemo.model.PetType;
import oleksandr.spring5.petclinicdemo.model.Vet;
import oleksandr.spring5.petclinicdemo.services.OwnerService;
import oleksandr.spring5.petclinicdemo.services.PetTypeService;
import oleksandr.spring5.petclinicdemo.services.VetService;
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
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes....");



        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Khreshatyuk 1");
        owner1.setCity("Kyiv");
        owner1.setTelephone("067-232-62-03");


        Pet michaelsCat = new Pet();
        michaelsCat.setPetType(savedCatType);
        michaelsCat.setOwner(owner1);
        michaelsCat.setBirthDate(LocalDate.now());
        michaelsCat.setName("Huston");
        owner1.getPets().add(michaelsCat);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAddress("Wasghington 1");
        owner1.setCity("DC");
        owner1.setTelephone("063-234-45-88");


        Pet fionasDog = new Pet();
        fionasDog.setPetType(savedDogType);
        fionasDog.setOwner(owner2);
        fionasDog.setBirthDate(LocalDate.now());
        fionasDog.setName("Mars");
        owner2.getPets().add(fionasDog);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");



    }
}
