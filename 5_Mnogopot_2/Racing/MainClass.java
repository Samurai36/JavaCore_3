package Racing;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch PODGOTOVKA = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch START = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch WIN = new CountDownLatch(3);
    public static final CountDownLatch FINISH = new CountDownLatch(CARS_COUNT*3);
    public static final Semaphore TONNEL = new Semaphore(CARS_COUNT/2);
    public static void main(String[] args) {
        System.err.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            START.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            FINISH.await(40, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.err.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}