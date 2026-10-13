import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Waiter implements Runnable{
    private final OrderQueue orderQueue;
    private List<String> dishes = Arrays.asList("Пицца", "Бургер", "Суп", "Салат");
    private final Random random = new Random();

    public Waiter(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        while(true) {
            int randomIndex = random.nextInt(dishes.size());
            String dishName = dishes.get(randomIndex);

            Order order = new Order(dishName);
            orderQueue.addOrder(order);
            System.out.println("Официант принял заказ: " + dishName + " [ID: " + order.getId() + "]");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка работы с заказами" + e.getMessage());
            }
        }
    }
}
