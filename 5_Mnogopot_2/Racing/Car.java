package Racing;

import java.util.concurrent.TimeUnit;

import static Racing.MainClass.*;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.err.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.err.println(this.name + " готов");
            START.countDown();
            PODGOTOVKA.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PODGOTOVKA.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

    }
}