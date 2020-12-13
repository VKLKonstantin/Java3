package lesson1;

public class BigMission {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Apple apple = new Apple();

        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        //добавление фруктов по ящикам
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        //orangeBox.addFruit(orange);
        //orangeBox.addFruit(orange);
        //orangeBox.addFruit(orange);

        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        // appleBox.addFruit(apple);

        appleBox2.addFruit(apple);
        appleBox2.addFruit(apple);
        appleBox2.addFruit(apple);

        //вывод массы ящиков
        System.out.println("Вес " + orangeBox.getWeightBox(orange.getWEIGHT()));
        System.out.println("Вес " + appleBox.getWeightBox(apple.getWEIGHT()));

        //пересыпание
        appleBox2.shiftFruits(appleBox);

        System.out.println("Количество в ящике один " + appleBox.storage.size());
        System.out.println("Количество в ящике два " + appleBox2.storage.size());


        System.out.println(orangeBox.compare(appleBox));
    }
}
