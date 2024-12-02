package Day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    public void givenListDescending_WhenIsSafe_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(7,6,4,2,1)));
    }

    @Test
    public void givenListAscending_WhenIsSafe_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1,3,6,7,9)));
    }

    @Test
    public void givenList_WhenIsNotSafe_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(1,2,7,8,9)));
    }

    @Test
    public void givenList_WhenIsNotSafe2_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(9,7,6,2,1)));
    }

    @Test
    public void givenList_WhenIsSafe_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1,3,2,4,5)));
    }

    @Test
    public void givenList_WhenIsSafe2_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(8,6,4,4,1)));
    }

    @Test
    public void givenList_WhenIsSafe3_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(100,1,2,3,4,5)));
    }

    @Test
    public void givenList_WhenIsSafe4_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1,1,2,3,4,5)));
    }

    @Test
    public void givenList_WhenIsSafe5_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(5,5,4,3,2,1)));
    }

    @Test
    public void givenList_WhenIsSafe6_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(-5,5,4,3,2,1)));
    }

    @Test
    public void givenList_WhenIsSafe7_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(3,4,4,3,2,1)));
    }

    @Test
    public void givenList_WhenIsSafe8_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(4,4,4,3,2,1)));
    }

    @Test
    public void givenList_WhenIsSafe9_ThenReturnTrue(){
        final var list = List.of(5,6,3,2,1);
        Assertions.assertTrue(Task2.isSafe(list));
    }

    @Test
    public void givenList_WhenIsSafe10_ThenReturnTrue(){
        final var list = List.of(6,5,7,8,9);
        Assertions.assertTrue(Task2.isSafe(list));
    }

    @Test
    public void givenList_WhenIsSafe11_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(10, 9, 8, 7, 6)));
    }

    @Test
    public void givenList_WhenIsSafe12_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    public void givenList_WhenIsNotSafe3_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(1, 1, 1, 1, 1)));
    }

    @Test
    public void givenList_WhenIsNotSafe4_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(10, 10, 10, 10, 10)));
    }

    @Test
    public void givenList_WhenIsSafe13_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1, 4, 7, 10, 13)));
    }

    @Test
    public void givenList_WhenIsSafe14_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(2, 4, 6, 8, 10)));
    }

    @Test
    public void givenList_WhenIsNotSafe5_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(1, 5, 9, 13, 17)));
    }



    @Test
    public void givenList_WhenIsSafe15_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1, 2, 3, 5, 8)));
    }

    @Test
    public void givenList_WhenIsSafe16_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(2, 3, 5, 7, 11)));
    }

    @Test
    public void givenList_WhenIsNotSafe7_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(1, 3, 6, 10, 15)));
    }

    @Test
    public void givenList_WhenIsNotSafe8_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(2, 4, 8, 16, 32)));
    }

    @Test
    public void givenList_WhenIsSafe17_ThenReturnTrue(){
        Assertions.assertTrue(Task2.isSafe(List.of(1, 1, 2, 3, 5)));
    }



    @Test
    public void givenList_WhenIsNotSafe9_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(1, 3, 7, 15, 31)));
    }

    @Test
    public void givenList_WhenIsNotSafe10_ThenReturnFalse(){
        Assertions.assertFalse(Task2.isSafe(List.of(2, 5, 10, 20, 40)));
    }
}