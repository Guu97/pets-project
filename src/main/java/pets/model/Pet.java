package pets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Pet domain entity.
 * 
 * Configured for Oracle database with sequence-based ID generation.
 * When migrating to MongoDB, replace JPA annotations with:
 * - @Document(collection = "pets")
 * - @Id on id field (change type to String if needed)
 */
@Entity
@Table(name = "PETS")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @SequenceGenerator(name = "pet_seq", sequenceName = "PET_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SPECIES", nullable = false)
    private String species;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "OWNER_NAME")
    private String ownerName;

    public Pet() {
    }

    public Pet(Long id, String name, String species, Integer age, String ownerName) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
