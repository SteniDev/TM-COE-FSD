package Week3.Task1;

/**
 *  Demonstrate with an example with the difference between equals() vs deepEquals() method?

 */

import java.util.Arrays;
import java.util.Objects;

public class EqualsVsDeepEquals_3 {
    // Simple object comparison
    public static void main(String[] args) {


        String str1 = "Hello";
        String str2 = new String("Hello");

        System.out.println("Objects.equals(str1, str2): " + Objects.equals(str1, str2)); // true
        System.out.println("Objects.deepEquals(str1, str2): " + Objects.deepEquals(str1, str2)); // true

        // Array comparison
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};

        System.out.println("Objects.equals(arr1, arr2): " + Arrays.equals(arr1, arr2)); // false (shallow check)
        System.out.println("Objects.deepEquals(arr1, arr2): " + Arrays.deepEquals(arr1, arr2)); // true (deep check)

        // Nested array comparison
        Integer[][] nestedArr1 = {{1, 2}, {3, 4}};
        Integer[][] nestedArr2 = {{1, 2}, {3, 4}};

        System.out.println("Objects.equals(nestedArr1, nestedArr2): " + Arrays.equals(nestedArr1, nestedArr2)); // false
        System.out.println("Objects.deepEquals(nestedArr1, nestedArr2): " + Arrays.deepEquals(nestedArr1, nestedArr2));
    }
}