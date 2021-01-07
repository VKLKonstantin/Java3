package lesson6;


import java.util.Arrays;

/**
 * 1. Добавить на серверную сторону чата логирование, с выводом информации о действиях на сервере(запущен, произошла ошибка,
 * клиент подключился, клиент прислал сообщение/команду).
 * 2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
 * выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * 3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
 * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * 4. *Добавить на серверную сторону сетевого чата логирование событий.
 */
public class Mission2 {

    public static void main(String[] args) {
      //  int a []={5, 5, 5, 5};
       int a[] = {1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 4, 5, 5, 5, 5};
        System.out.println(Arrays.toString(method(a)));
    }

    public static int[] method(int a[]) {
        int such = 4;
        int count = 0;
        int[] buff = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == such) {
                count++;
            }


        }
        if (count == 0) {
            throw new RuntimeException();
        }
        for (int i = 0; i < a.length && count > 0; i++) {
            if (a[i] == such) {
                count--;
                if (count == 0) {
                    buff = new int[a.length - 1 - i];
                    for (int j = 0, k = i + 1; k < a.length; j++, k++) {
                        buff[j] = a[k];
                    }

                }
            }
        }

        return buff;
    }

}