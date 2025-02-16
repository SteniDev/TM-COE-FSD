package Week3.collectionApi;

import java.util.ArrayList;
import java.util.List;

public class SearchElement {
	public static void main(String[] args) {
		ArrayList<Integer> numbers=new ArrayList<> (List.of(1,2,3,4,5,6,7,8,9,10));
		System.out.println(numbers.contains(4));
}
}