package pets.service;

import pets.dto.PetRequest;
import pets.dto.PetResponse;
import pets.exception.PetNotFoundException;
import pets.mapper.PetMapper;
import pets.model.Pet;
import pets.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of PetService.
 */
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    @Override
    public PetResponse createPet(PetRequest request) {
        Pet pet = petMapper.toEntity(request);
        Pet savedPet = petRepository.save(pet);
        return petMapper.toResponse(savedPet);
    }

    @Override
    public PetResponse getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        return petMapper.toResponse(pet);
    }

    @Override
    public List<PetResponse> getAllPets() {
        return petRepository.findAll().stream()
                .map(petMapper::toResponse)
                .toList();
    }

    @Override
    public PetResponse updatePet(Long id, PetRequest request) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        petMapper.updateEntity(pet, request);
        Pet updatedPet = petRepository.save(pet);
        return petMapper.toResponse(updatedPet);
    }

    @Override
    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new PetNotFoundException(id);
        }
        petRepository.deleteById(id);
    }
}
