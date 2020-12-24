package lesson4;

import java.io.*;

//2. Написать небольшой метод, в котором 3 потока построчно пишут данные в файл (по 10 записей с периодом в 20 мс).

public class DataInFile {

    public static PrintWriter printWriter = null;
    public static String s1 = "111";
    public static String s2 = "222";
    public static String s3 = "333";

    public static void main(String[] args) {


        class WriteInText implements Runnable {
            public String s;

            public WriteInText(String s) {
                this.s = s;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(20);
                        printWriter.print(s);
                        printWriter.flush();//очистка потока
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printWriter.println();
            }
        }

        try {
            printWriter = new PrintWriter("streams.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(new WriteInText(s1));
        Thread t2 = new Thread(new WriteInText(s2));
        Thread t3 = new Thread(new WriteInText(s3));

        try {
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printWriter.close();
    }
}
