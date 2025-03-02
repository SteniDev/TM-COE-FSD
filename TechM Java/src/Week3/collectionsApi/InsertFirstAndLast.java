package Week3.collectionsApi;

import java.util.LinkedList;
import java.util.List;

public class InsertFirstAndLast {
	public static void main(String[] args) {
		LinkedList<String> movieList = new LinkedList<>(
				 List.of("Dune", "OK Kanmani", "Love Today ", "LAD "));
		movieList.addFirst("24");
		movieList.addLast("Marco");
		System.out.println(movieList);
	}
}
