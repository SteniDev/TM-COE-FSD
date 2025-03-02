package Week3.Generics;

import java.util.Arrays;
import java.util.List;

public class SearchElement {
public static<T> int searchElement(List<T> list,T target) {
     return   list.indexOf(target);
}
public static void main(String[] args) {
	List<Integer> numbers=Arrays.asList(1,2,3,4,5,4,7,8,9,10);
	List<String> names=Arrays.asList("rahul","prawin","david","jeffery","Arshadh");
	System.out.println("The index of the target is "+searchElement(numbers, 10));
	System.out.println("The index of the target is "+searchElement(names,"david"));
}
}
