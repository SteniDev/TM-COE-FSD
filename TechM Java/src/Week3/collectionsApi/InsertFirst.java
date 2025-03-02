package Week3.collectionsApi;

import java.util.ArrayList;
import java.util.List;

public class InsertFirst {
public static void main(String[] args) {
	ArrayList<String> names=new ArrayList<>( List.of("steni","Victor","Tony"));
	names.add(0,"Jermish");
	System.out.println(names);
}
}
