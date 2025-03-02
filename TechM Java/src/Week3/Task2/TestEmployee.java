package Week3.Task2;

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee("ancy", 33, 1200000, 6);
        emp1.getEmployeeDetails();
        System.out.println(emp1.getLoanEligibility());;
    }
}
