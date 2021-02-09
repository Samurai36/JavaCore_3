package Racing;


import static Racing.MainClass.WIN;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {

            System.err.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.err.println(c.getName() + " закончил этап: " + description);
            WIN.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}