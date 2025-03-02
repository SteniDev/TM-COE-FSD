package Week3.Generics;

import java.util.Arrays;

public class ArrayComparison {
public static <T> boolean arraysEqual(int [] array1,int []array2) {
	return Arrays.equals(array1,array2);
}
public static void main(String[] args) {
	int[] array1= {1,2,3,4,5};
	int[] array2= {1,2,3,4,5};
	System.out.println(arraysEqual(array1, array2));
}
}
