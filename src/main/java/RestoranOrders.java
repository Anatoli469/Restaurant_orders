public class RestoranOrders {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();

        Waiter waiterTask = new Waiter(orderQueue);
        Chef chefTask1 = new Chef(orderQueue, "Константин");
        Chef chefTask2 = new Chef(orderQueue, "Ренат");

        Thread waiterThread = new Thread(waiterTask);
        Thread chefThread1 = new Thread(chefTask1);
        Thread chefThread2 = new Thread(chefTask2);

        System.out.println("======ресторан открылся======");

        waiterThread.start();
        chefThread1.start();
        chefThread2.start();
    }
}
