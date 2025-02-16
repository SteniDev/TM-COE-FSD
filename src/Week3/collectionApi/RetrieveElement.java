package Week3.collectionApi;

import java.util.ArrayList;
import java.util.List;

public class RetrieveElement {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>( List.of( "steni","Victor","Tony" ));
		System.out.println(names.get(0));
	}
}
