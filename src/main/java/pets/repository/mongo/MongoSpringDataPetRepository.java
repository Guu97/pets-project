package pets.repository.mongo;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import pets.model.PetDocument;

/**
 * Spring Data MongoDB repository for PetDocument.
 * Active only when 'mongo' profile is enabled.
 */
@Profile("mongo")
public interface MongoSpringDataPetRepository extends MongoRepository<PetDocument, String> {
}
