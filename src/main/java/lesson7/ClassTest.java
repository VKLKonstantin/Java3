package lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassTest {
    public int CountBefore = 0;
    public int CountAfter = 0;

    public static void start(Class testingClass) throws InvocationTargetException, IllegalAccessException {
        ClassTest classTest = new ClassTest();
        Method[] methods = testingClass.getDeclaredMethods(); //получаем все доступные методы
        ArrayList<Method> arrayMethod = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite1.class)) {//isAnnotationPresent возвращает true, если указанная аннотация существует для проверяемого элемента.
                classTest.CountBefore++;
            }
            if (m.isAnnotationPresent(AfterSuite1.class)) {
                classTest.CountAfter++;
            }
        }

        if ((classTest.CountAfter | classTest.CountBefore) > 1) {
            throw new RuntimeException();//если количество аннотаций BeforeSuite или AfterSuite больше одной, то кидаем исключение
        }

        for (Method m : methods) {

            if (m.isAnnotationPresent(BeforeSuite1.class)) {
                m.invoke(null);//вызов метода с аннотацией BeforeSuite
            }

            if (m.isAnnotationPresent(Test1.class)) { //вызов метода с аннотацией Test

                arrayMethod.add(m);
            }

        }


        arrayMethod.sort((o1, o2) -> {
            return o1.getAnnotation(Test1.class).priority() - o2.getAnnotation(Test1.class).priority();
        });

        for (int i = arrayMethod.size() - 1; i >= 0; i--) {
            System.out.print("Приоритет: " + arrayMethod.get(i).getAnnotation(Test1.class).priority() + " Тест: ");
            arrayMethod.get(i).invoke(testingClass);

        }
        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite1.class)) {
                m.invoke(null);//вызов метода с аннотацией AfterSuite
            }
        }

    }
}
