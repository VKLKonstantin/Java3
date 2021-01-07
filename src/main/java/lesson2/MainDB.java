package lesson2;


import java.sql.*;

public class MainDB {
    private static Connection connection;//для соединения с БД
    private static Statement stmt;//для выполнения простых SQL-запросов без параметров
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException {

        try {
            connection(); //1.Подключиться к БД
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2. Создать таблицу товаров (good_id, good_name, good_price)
        stmt.execute("CREATE TABLE IF NOT EXISTS goods (" +// Метод execute используется, когда операторы SQL
                                                                 // возвращают более одного набора данных
                "good_id integer PRIMARY KEY," +
                "good_name VARCHAR (60) NOT NULL," +
                "good_price int NOT NULL" +
                ");");

        //3. При запуске приложения очистить таблицу и заполнить 10000 товаров
        stmt.execute("DELETE FROM goods");//очищаем таблицу
        connection.setAutoCommit(false);//получаем доступ к управлению транзакциями
        for (int i = 0; i < 10000; i++) {
            stmt.addBatch("INSERT INTO goods (good_name, good_price) VALUES ('Name" + (i + 1) + "', " + (i + 10) + ")");
            //addBatch используется для того, чтобы добавить отдельный SQL-запрос в “пакет”
        }
        stmt.executeBatch();//используется для выполнения всех запросов, которые находятся в данном пакете
        connection.setAutoCommit(true);


        //4. Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо вывести сообщение
        // «Такого товара нет», если товар не обнаружен в базе.
        findPriceForProduct("Name50");//поиск товара по цене
        findPriceForProduct("Name10001");//если товар не найден

        //5. Добавить возможность изменения цены товара. Указываем имя товара и новую цену.
        replacePriceForProduct("Name55", "99");

        //6. Вывести товары в заданном ценовом диапазоне.
        findGoodInPrice(50, 60);

        disconnect();
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mainDB.db");// БД создается автоматически
        stmt = connection.createStatement();//создание объекта Statement
    }

    private static void disconnect() throws SQLException {
        connection.close();//завершение соединения с БД
    }

    private static void findPriceForProduct(String product) throws SQLException {//поиск товара по цене
        ResultSet rs = stmt.executeQuery("SELECT good_price FROM goods WHERE good_name = '" + product + "';");

        if (rs.next()) {
            System.out.println("Цена: " + rs.getInt(1));
        } else {
            System.out.println("Товар не найден");
        }
    }

    private static void replacePriceForProduct(String nameProduct, String priceProduct) throws SQLException {
        findPriceForProduct(nameProduct);//находим товар по цене
        stmt.executeUpdate("UPDATE goods SET good_price = '" + priceProduct + "' WHERE good_name = '" + nameProduct + "';");
        findPriceForProduct(nameProduct);
    }

    private static void findGoodInPrice(int priceFrom, int priceTo) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT good_name,good_price FROM goods WHERE good_price >= '" + priceFrom + "' and good_price <= '" + priceTo + "';");

        System.out.println("good_name | good_price");
        while (rs.next()) {
            System.out.println(rs.getString("good_name") + " | " + rs.getInt(2));
        }
    }

}
