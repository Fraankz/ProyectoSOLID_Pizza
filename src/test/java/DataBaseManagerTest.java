import org.example.DataBaseManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataBaseManagerTest {

    private static DataBaseManager db;

    @BeforeAll
    static void setup() {
        db = new DataBaseManager();
        db.connect();
        assertNotNull(db.getConnection(), "La conexión debería estar inicializada");
    }

    @Test
    public void testCrearPedido() {
        assertDoesNotThrow(() -> {
            db.createOrder(1, "Test pizza margherita", 11.99);
        }, "La inserción del pedido no debería lanzar excepción");
    }

    @Test
    public void testEliminarPedido() {
        assertDoesNotThrow(() -> {
            db.deleteOrder(1); // Asegúrate de que el ID existe o ignora si no
        }, "La eliminación del pedido no debería lanzar excepción");
    }

    @Test
    public void testListarPedidosPorUsuario() {
        assertDoesNotThrow(() -> {
            db.listarPedidosPorUsuario(1);
        }, "La consulta de pedidos no debería lanzar excepción");
    }
}
