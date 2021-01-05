package lesson7;


public class TestMethods {

    @BeforeSuite1
    public static void firstBefore() {
        System.out.println("firstBefore");
    }

    @Test1(priority = 8)
    public static void firstTest() {
        System.out.println("test 1");
    }

    @Test1(priority = 2)
    public static void firstTest2() {
        System.out.println("test 2");
    }

    @Test1(priority = 7)
    public static void firstTest3() {
        System.out.println("test 3");
    }

    @AfterSuite1
    public static void firstAfter() {
        System.out.println("firstAfter");
    }

}
