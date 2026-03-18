package pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pets.model.Pet;

/**
 * Repository interface for Pet entity persistence operations.
 * 
 * Extends JpaRepository for Oracle/relational database access.
 * When migrating to MongoDB, change to extend MongoRepository<Pet, Long>.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
