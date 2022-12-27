package kdv.spring.pets;

// @Service -- pretend this is 3rd party
// @Profile({"dog", "default"})
public class DogPetService implements PetService {

    @Override
    public String getPetType(){
        return "Dogs are the best!";
    }
}