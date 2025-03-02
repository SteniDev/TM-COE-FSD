package Week3.ExceptionHandlings;

public class EvenNumberCheck {
    public static void CheckNumber(int n) throws OddNumberException {
        if (n % 2 != 0) {
            throw new OddNumberException("Error: The number is odd");
        } else {
            System.out.println("The number is even.");
        }
    }

    public static void main(String[] args) {
        try {
            CheckNumber(7);
        } catch (OddNumberException e) {
            System.out.println(e.getMessage());
        }

    }
}
