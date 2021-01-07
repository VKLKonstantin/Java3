package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mission2Test {
    @Test
    public void testArray1() {
        Mission2 mission2 = new Mission2();
        Assertions.assertArrayEquals(new int[]{5, 5, 5, 6}, mission2.method(new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 4, 5, 5, 5, 5}));
    }
    @Test
    public void testArray2() {
        Mission2 mission2 = new Mission2();
        Assertions.assertArrayEquals(new int[]{6, 7}, mission2.method(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testArray3() {
        Mission2 mission2 = new Mission2();
        Assertions.assertArrayEquals(new int[]{5, 5, 5, 5}, mission2.method(new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 4, 5, 5, 5, 5}));
    }


}