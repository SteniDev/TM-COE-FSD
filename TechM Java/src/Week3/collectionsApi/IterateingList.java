package Week3.collectionsApi;

import java.util.ArrayList;

public class IterateingList {
public static void main(String[] args) {
	ArrayList<Integer> numbers=new ArrayList<Integer>();
	numbers.add(1);
	numbers.add(2);
	numbers.add(3);
	numbers.add(4);
	numbers.add(5);
	for(int n:numbers) {
		System.out.println(n);
	}
	
	
}
}
