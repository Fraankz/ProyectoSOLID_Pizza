import org.example.DataBaseManager;
import org.example.OrderManager;
import org.example.PaymentProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderManagerTest {

    private OrderManager orderManager;

    @BeforeEach
    public void setup() {
        DataBaseManager db = new DataBaseManager();
        db.connect();
        PaymentProcessor payment = new PaymentProcessor();
        orderManager = new OrderManager(db, payment);
    }

    @Test
    public void testCrearYEliminarPedido() {
        orderManager.crearPedido(1, "Pizza test", 12.5);
        orderManager.eliminarPedido(1); // Solo si sabes que el ID existe
    }
}
