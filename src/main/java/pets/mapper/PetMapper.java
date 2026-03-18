package pets.mapper;

import pets.dto.PetRequest;
import pets.dto.PetResponse;
import pets.model.Pet;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Pet entity and DTOs.
 */
@Component
public class PetMapper {

    public Pet toEntity(PetRequest request) {
        Pet pet = new Pet();
        pet.setName(request.getName());
        pet.setSpecies(request.getSpecies());
        pet.setAge(request.getAge());
        pet.setOwnerName(request.getOwnerName());
        return pet;
    }

    public PetResponse toResponse(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getAge(),
                pet.getOwnerName()
        );
    }

    public void updateEntity(Pet pet, PetRequest request) {
        pet.setName(request.getName());
        pet.setSpecies(request.getSpecies());
        pet.setAge(request.getAge());
        pet.setOwnerName(request.getOwnerName());
    }
}
