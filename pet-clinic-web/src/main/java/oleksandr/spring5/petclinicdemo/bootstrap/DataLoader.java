package oleksandr.spring5.petclinicdemo.bootstrap;

import oleksandr.spring5.petclinicdemo.model.*;
import oleksandr.spring5.petclinicdemo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


//why method can be not static?m so it`s like psvm but with magic?
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
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality sabedDentistry = specialityService.save(dentistry);

        System.out.println("Specialoities are created....");

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
        owner2.setAddress("Wasghington 1");
        owner2.setCity("DC");
        owner2.setTelephone("063-234-45-88");

        Pet fionasDog = new Pet();
        fionasDog.setPetType(savedDogType);
        fionasDog.setOwner(owner2);
        fionasDog.setBirthDate(LocalDate.now());
        fionasDog.setName("Mars");
        owner2.getPets().add(fionasDog);

        ownerService.save(owner2);
        Visit dogVisit = new Visit();
        dogVisit.setPet(fionasDog);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("sneaky doggy");


        visitService.save(dogVisit);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);
        vet1.getSpecialties().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        vet2.getSpecialties().add(savedSurgery);

        System.out.println("Loaded Vets....");

        vet2.getSpecialties().forEach(System.out::println);
    }
}
