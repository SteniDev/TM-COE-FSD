package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;

public class InsertingLastLinked {
	public static void main(String[] args) {

		LinkedList<String> movieList = new LinkedList<>(
				 List.of("Dune", "OK Kanmani", "Love Today ", "LAD "));
		movieList.addLast("kk");
		System.out.println(movieList);

	}
}
