package pets.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representation of Pet entity.
 * Used only when 'mongo' profile is active.
 */
@Document(collection = "pets")
public class PetDocument {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("species")
    private String species;

    @Field("age")
    private Integer age;

    @Field("owner_name")
    private String ownerName;

    public PetDocument() {
    }

    public PetDocument(String id, String name, String species, Integer age, String ownerName) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    /**
     * Converts this MongoDB document to the domain Pet entity.
     */
    public Pet toDomainModel() {
        Long domainId = null;
        if (id != null) {
            try {
                domainId = Long.parseLong(id);
            } catch (NumberFormatException e) {
                // MongoDB ObjectId - use hashCode as fallback
                domainId = (long) id.hashCode();
            }
        }
        return new Pet(domainId, name, species, age, ownerName);
    }

    /**
     * Creates a PetDocument from a domain Pet entity.
     */
    public static PetDocument fromDomainModel(Pet pet) {
        PetDocument doc = new PetDocument();
        doc.setId(pet.getId() != null ? pet.getId().toString() : null);
        doc.setName(pet.getName());
        doc.setSpecies(pet.getSpecies());
        doc.setAge(pet.getAge());
        doc.setOwnerName(pet.getOwnerName());
        return doc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
