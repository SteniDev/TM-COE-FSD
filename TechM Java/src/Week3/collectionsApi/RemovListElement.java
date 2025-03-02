package Week3.collectionsApi;

import java.util.ArrayList;
import java.util.List;

public class RemovListElement {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>( List.of("steni","Victor","Tony","KK"));
		names.remove(3);
		System.out.println(names);
	}
}