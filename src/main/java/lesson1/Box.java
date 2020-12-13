package lesson1;

import java.util.ArrayList;

public class Box<T> {

    private float weight = 0;
    public ArrayList<T> storage = new ArrayList<T>();


    public float getWeightBox(float weightFruit) { //взвешивание

        weight = (float) storage.size() * weightFruit;

        return weight;
    }

    public boolean compare(Box<?> box) { //сравнение

        if (this.weight == box.weight) {
            return true;
        } else {
            return false;
        }
    }

    public void addFruit(T t) { //добавление
        storage.add(t);
    }

    public void shiftFruits(Box<T> box) {//пересыпание

        for (T t : this.storage) {
            box.addFruit(t);
        }
        this.storage.clear();
    }
}
