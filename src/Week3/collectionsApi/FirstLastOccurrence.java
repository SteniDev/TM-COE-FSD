package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;

public class FirstLastOccurrence {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>( List.of("Red", "Blue", "Green", "Blue","Blue"));
		System.out.println("First Occurrence of Blue: " + list.indexOf("Blue"));
		System.out.println("Last Occurrence of Blue: " + list.lastIndexOf("Blue"));

	}
}
