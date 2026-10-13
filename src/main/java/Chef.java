public class Chef implements Runnable{
    private final OrderQueue orderQueue;
    private final String chefName;

    public Chef(OrderQueue orderQueue, String chefName) {
        this.orderQueue = orderQueue;
        this.chefName = chefName;
    }

    @Override
    public void run() {
        while(true) {
            Order order = orderQueue.takeOrder();
            if(order == null) {
                break;
            }
            order.setStatus(OrderStatus.COOKING);
            System.out.println("Повар " + chefName + " начал готовить заказ №" + order.getId());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка приготовления заказа" + e.getMessage());;
            }
            order.setStatus(OrderStatus.READY);
            System.out.println("\uD83C\uDF89 Повар " + chefName + " приготовил заказ №"+ order.getId());
        }
    }
}
