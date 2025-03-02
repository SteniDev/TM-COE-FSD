package Week3.Task1;

//Task 1 : Write a Java program to copy the alternative elements in the array.

import java.util.Arrays;

public class CopyAlternateElement_1 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 55, 76, 45, 77};

        int l = arr.length / 2;

        int[] copyArray = new int[l + 1];
        Arrays.fill(copyArray, -1);
        int index = 0;
        for (int i = 0; i < arr.length; i = i + 2) {

            copyArray[index++] = arr[i];

        }
        for (int i = 0; i < copyArray.length; i++) {
            if (copyArray[i] != -1)
                System.out.println(copyArray[i]);
        }
    }

}
