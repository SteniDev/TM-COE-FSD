package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;

public class LinkedListIterating {
	public static void main(String[] args) {
		LinkedList<Integer> number = new LinkedList<>( List.of(10, 20, 30, 40, 50, 60, 70));
        for(int i:number) {
        	System.out.println(i);
        }
	}
}
