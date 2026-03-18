package pets.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pets.model.Pet;
import pets.repository.PetRepository;

import java.util.List;
import java.util.Optional;

/**
 * JPA implementation of PetRepository.
 * Adapts Spring Data JPA to the port interface.
 * Active only when 'jpa' profile is enabled.
 */
@Repository
@Profile("jpa")
public class JpaPetRepository implements PetRepository {

    private final JpaSpringDataPetRepository jpaRepository;

    public JpaPetRepository(JpaSpringDataPetRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Pet save(Pet pet) {
        return jpaRepository.save(pet);
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Pet> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
