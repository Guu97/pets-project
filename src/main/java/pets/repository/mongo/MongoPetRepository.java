package pets.repository.mongo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pets.model.Pet;
import pets.model.PetDocument;
import pets.repository.PetRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * MongoDB implementation of PetRepository.
 * Adapts Spring Data MongoDB to the port interface.
 * Active only when 'mongo' profile is enabled.
 */
@Repository
@Profile("mongo")
public class MongoPetRepository implements PetRepository {

    private final MongoSpringDataPetRepository mongoRepository;
    private final AtomicLong idGenerator = new AtomicLong(1);

    public MongoPetRepository(MongoSpringDataPetRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Pet save(Pet pet) {
        PetDocument doc = PetDocument.fromDomainModel(pet);
        
        // Generate ID if not present
        if (doc.getId() == null) {
            doc.setId(String.valueOf(idGenerator.getAndIncrement()));
        }
        
        PetDocument saved = mongoRepository.save(doc);
        return saved.toDomainModel();
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return mongoRepository.findById(id.toString())
                .map(PetDocument::toDomainModel);
    }

    @Override
    public List<Pet> findAll() {
        return mongoRepository.findAll().stream()
                .map(PetDocument::toDomainModel)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        mongoRepository.deleteById(id.toString());
    }

    @Override
    public boolean existsById(Long id) {
        return mongoRepository.existsById(id.toString());
    }
}
