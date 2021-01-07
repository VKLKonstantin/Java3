package lesson6;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Mission3Test {
    @Test
    public void testArray1() {
        Mission3 mission3 = new Mission3();
        Assertions.assertEquals(true, mission3.checkArray(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testArray2() {
        Mission3 mission3 = new Mission3();
        Assertions.assertEquals(true, mission3.checkArray(new int[]{5, 2, 3, 8, 5, 6}));
    }

    @Test
    public void testArray3() {
        Mission3 mission3 = new Mission3();
        Assertions.assertEquals(false, mission3.checkArray(new int[]{1, 2, 3, 4, 5, 6}));
    }
}