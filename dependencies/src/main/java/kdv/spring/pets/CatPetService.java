package kdv.spring.pets;

// @Service  -- pretend this is 3rd party
// @Profile("cat")
public class CatPetService implements PetService {

    @Override
    public String getPetType(){
        return "Cats are the best!";
    }
}