package Week3.collectionsApi;

import java.util.ArrayList;
import java.util.List;

public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("steni", "Victor", "Tony"));
        names.set(1, "Vijay");
        System.out.println(names);
    }
}