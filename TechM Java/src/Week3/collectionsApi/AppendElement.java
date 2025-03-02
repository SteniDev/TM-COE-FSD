package Week3.collectionsApi;

import java.util.LinkedList;

public class AppendElement {
	    public static void main(String[] args) {
	        LinkedList<String> MoviesList = new LinkedList<>();
	        MoviesList.add("Avengers");
	        MoviesList.add("Marco");
	        MoviesList.addLast("Solo");

	        System.out.println(MoviesList);
	    }
	}

