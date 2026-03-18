package pets.repository;

import pets.model.Pet;

import java.util.List;
import java.util.Optional;

/**
 * Repository port interface for Pet entity persistence operations.
 * 
 * This abstraction allows switching between different database implementations
 * (JPA/Oracle, MongoDB) via Spring profiles without changing the service layer.
 */
public interface PetRepository {

    Pet save(Pet pet);

    Optional<Pet> findById(Long id);

    List<Pet> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
