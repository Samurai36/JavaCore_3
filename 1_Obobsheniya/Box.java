import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit & Fruits> {

    private int capacity;
    private List<T> korobka;

    public Box(int capacity, T... fruit) {
        this.capacity = capacity;
        this.korobka = new ArrayList<>(Arrays.asList(fruit));
    }

    public int getCapacity() {
        return capacity;
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit: korobka){
            weight += fruit.weight;
        }
        return weight;
    }

    public boolean compareWeight(Box<?> box2){
        return Math.abs(this.getWeight() - box2.getWeight()) < 0.001;
    }

    public void addFruit(T fruit){
        if (capacity > 1) {
            korobka.add(fruit);
            capacity--;
        }
    }

    public void boxInBox(Box<T> box2){
        if (box2 == this) return;
        if (this.getCapacity() < box2.getCapacity()) {
            System.out.println("все фрукты могут не уместиться в другую коробку");
        }
        box2.korobka.addAll(this.korobka);
    }

}
