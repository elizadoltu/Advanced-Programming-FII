package invalid;

import java.io.IOException;

public class InvalidRepository extends Exception {

    public InvalidRepository(Exception ex) {
        super("Invalid repository.", ex);
    }
}
