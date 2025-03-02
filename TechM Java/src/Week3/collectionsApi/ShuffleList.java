package Week3.collectionsApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleList {
	public static void main(String[] args) {
		ArrayList<String> movies = new ArrayList<>( List.of( "Dune", "OK Kanmani", "Love Today ", "LAD "));
		Collections.shuffle(movies);

		System.out.println(movies);
	}
}
