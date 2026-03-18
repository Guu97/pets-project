package pets.service;

import pets.dto.PetRequest;
import pets.dto.PetResponse;

import java.util.List;

/**
 * Service interface for Pet business operations.
 */
public interface PetService {

    PetResponse createPet(PetRequest request);

    PetResponse getPetById(Long id);

    List<PetResponse> getAllPets();

    PetResponse updatePet(Long id, PetRequest request);

    void deletePet(Long id);
}
