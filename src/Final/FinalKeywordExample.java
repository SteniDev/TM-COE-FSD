package Final;

public class FinalKeywordExample {

    public static void main(String[] args) {
        // Using the final class
        FinalVariable finalVariable = new FinalVariable();
        System.out.println("Value of G: " + finalVariable.getG());
        finalVariable.showMessage();

        // Using the final method
        DerivedClass derived = new DerivedClass();
        derived.display();
        derived.showDetails();
    }
}


