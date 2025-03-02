package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;

public class MultipleElementsInsertingLinked {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>( List.of("Red", "Green"));
		list.add(1, "Blue");
		list.add(2, "Yellow");

		System.out.println(list);
	}

}
