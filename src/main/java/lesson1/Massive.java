package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Massive <T>{


    public void change(T[] mas, int element1, int element2) {
        T buff = mas[element1];
        mas[element1] = mas[element2];
        mas[element2] = buff;
    }

    public List <T> massToArray (T[] mas){
       List<T> massToArray = new ArrayList<T>();

        massToArray = Arrays.asList(mas);
        return massToArray;
    }
}
