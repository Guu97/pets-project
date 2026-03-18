package pets.exception;

/**
 * Exception thrown when a Pet is not found.
 */
public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(Long id) {
        super("Pet not found with id: " + id);
    }
}
