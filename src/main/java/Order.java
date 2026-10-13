import java.util.Objects;

public class Order {
    private static int count = 0;
    private int id;
    private String dishName;
    private OrderStatus status;

    public Order(String dishName) {
        this.id = count++;
        this.dishName = dishName;
        status = OrderStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return (id == order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Заказ №" + id + "; Блюдо: " + dishName + "; Cтатус заказа: " + status;
    }
}
