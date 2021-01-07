package lesson4;

import java.util.ArrayList;


/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 * *
 * */
public class Multithreading {

    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Multithreading w = new Multithreading();
        Thread t1 = new Thread(() -> {
            w.printA();
        });
        Thread t2 = new Thread(() -> {
            w.printB();
        });
        Thread t3 = new Thread(() -> {
            w.printC();
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void printA() {

        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (currentLetter != 'A') {
                    wait();
                }
                System.out.print("A");
                currentLetter = 'B';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printB() {

        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (currentLetter != 'B') {
                    wait();
                }
                System.out.print("B");
                currentLetter = 'C';

                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
    public synchronized void printC() {

        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (currentLetter != 'C') {
                    wait();
                }

                System.out.print("C");
                currentLetter = 'A';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}


