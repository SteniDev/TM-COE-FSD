package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SpecificPositionIterateing {
	public static void main(String[] args) {
		LinkedList<Integer> number = new LinkedList<>(List.of(10, 20, 30, 40, 50, 60, 70));
		ListIterator<Integer> iterator=number.listIterator(2);
        while(iterator.hasNext()) {
        	System.out.println(iterator.next());
        }
	}
}
