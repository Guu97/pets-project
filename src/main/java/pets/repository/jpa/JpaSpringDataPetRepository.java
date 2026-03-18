package pets.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import pets.model.Pet;

/**
 * Spring Data JPA repository for Pet entity.
 * Active only when 'jpa' profile is enabled.
 */
@Profile("jpa")
public interface JpaSpringDataPetRepository extends JpaRepository<Pet, Long> {
}
