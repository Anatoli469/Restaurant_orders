import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderQueue {
    private final BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void addOrder (Order order) {
        try {
            queue.put(order);
        } catch (InterruptedException e) {
            System.out.println("Ошибка добавления заказа: " + e.getMessage());;
        }
    }

    public Order takeOrder() {
        Order order = null;
        try {
            order = queue.take();
        } catch (InterruptedException e) {
            System.out.println("Ошибка обработки заказа: " + e.getMessage());;
        }
        return order;
    }
}
