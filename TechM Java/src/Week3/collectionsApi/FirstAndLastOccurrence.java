package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;

public class FirstAndLastOccurrence {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>( List.of("Red", "Blue", "Green", "green"," pink","Blue","Blue"));
		System.out.println("First time of Blue: " + list.indexOf("Blue"));
		System.out.println("Last time of Blue: " + list.lastIndexOf("Blue"));

	}
}
