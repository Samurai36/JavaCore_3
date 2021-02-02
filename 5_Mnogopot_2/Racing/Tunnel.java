package Racing;

import static Racing.MainClass.*;

public class Tunnel extends Stage {

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                TONNEL.acquire();
                System.err.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.err.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.err.println(c.getName() + " закончил этап: " + description);
                TONNEL.release();
                WIN.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}