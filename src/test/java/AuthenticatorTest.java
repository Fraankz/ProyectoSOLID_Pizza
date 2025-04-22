import org.example.Authenticator;
import org.example.DataBaseManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticatorTest {

    private static DataBaseManager db;
    private static Authenticator auth;

    @BeforeAll
    static void setup() {
        db = new DataBaseManager();
        db.connect();
        auth = new Authenticator(db.getConnection());
    }

    @Test
    public void testAutenticacionCorrecta() {
        int userId = auth.authenticate("admin", "1234");
        assertTrue(userId > 0); // Espera que devuelva un ID válido
    }

    @Test
    public void testAutenticacionFallida() {
        int userId = auth.authenticate("fakeuser", "wrongpass");
        assertEquals(-1, userId);
    }
}
