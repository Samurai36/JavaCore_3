import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TestsArraysMethodsTest {

    @CsvSource({
            "1, 2, 2",
            "7, -4, 12",
            "12, 44, 24"
    })

    @ParameterizedTest
    public void number4NotHaveExeption(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () ->
                TestsArraysMethods.separateArrBeforeLast4(arr)
        );

        Assertions.assertEquals("have not number 4", runtimeException.getMessage());

    }

    @Test
    void number4TheLastElement (){
        int[] arr = new int[]{1, 2, 4};
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () ->
                TestsArraysMethods.separateArrBeforeLast4(arr)
        );

        Assertions.assertEquals("Number \"4\" the last element of the array. The new array will not be created", runtimeException.getMessage());
    }

    @Test
    void separateArrBeforeLast4testVariant2(){
        int[] arr = {1, 3, 4, 1, 2, 44, 4, 4, -4, 10, 14};
        int[] arr2 = {-4, 10, 14};
        Assertions.assertArrayEquals(TestsArraysMethods.separateArrBeforeLast4(arr), arr2);
    }

    @Test
    void separateArrBeforeLast4test(){
        int[] arr = {1, 3, 4, 1, 2};
        int[] arr2 = {1, 2};
        Assertions.assertTrue(Arrays.equals(TestsArraysMethods.separateArrBeforeLast4(arr), arr2));
    }
    @CsvSource({
            "1 1 1 1",
            "4 4",
            "4",
            "1 4 -1"
    })

    @ParameterizedTest
    void arrHaveOnly1and4False(String str){
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        Assertions.assertTrue(!TestsArraysMethods.arrHaveOnly1and4(arr));
    }

    @CsvSource({
            "1 1 1 4",
            "1 4",
            "1 4 4 4",
    })

    @ParameterizedTest
    void arrHaveOnly1and4True(String str){
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        Assertions.assertTrue(TestsArraysMethods.arrHaveOnly1and4(arr));
    }

}