package Week3.Task1;

import java.util.Arrays;

public class ArrayCopyRange_4 {
    public static void main(String[] args) {
        int [] arr={1,2,33,55,45,32,12,44,65,76,86,99,01};
        int[] range= Arrays.copyOfRange(arr,0,3);
        for(int x:range){
            System.out.println(x);
        }
    }
}
