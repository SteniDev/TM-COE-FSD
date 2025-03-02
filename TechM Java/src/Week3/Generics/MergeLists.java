package Week3.Generics;

import java.util.ArrayList;
import java.util.List;

public class MergeLists {
	public static <T> List<T> mergeAlternately(List<T> list1, List<T> list2) {
		List<T> mergedList = new ArrayList<>();
		int size1 = list1.size(), size2 = list2.size();
		int i = 0, j = 0;

		while (i < size1 || j < size2) {
			if (i < size1)
				mergedList.add(list1.get(i++));
			if (j < size2)
				mergedList.add(list2.get(j++));
		}
		return mergedList;
	}

	public static void main(String[] args) {
		List<String> list1 = List.of("A", "B", "C");
		List<String> list2 = List.of("1", "2", "3", "4");

		System.out.println(mergeAlternately(list1, list2)); 
	}
}

