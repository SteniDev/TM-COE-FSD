package Week3.Task2;

public class Employee {
    private String empName;
    private int empId;
    private double salary;
    private int workedYears;

    public Employee(String empName, int empId, double salary, int workedYears) {
        this.empName = empName;
        this.empId = empId;
        this.salary = salary;
        this.workedYears = workedYears;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkedYears() {
        return workedYears;
    }

    public void setWorkedYears(int workedYears) {
        this.workedYears = workedYears;
    }

    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Annual Salary: " + salary);
        System.out.println("years worked : " + workedYears);
    }
    public double getLoanEligibility() {
        if (workedYears > 5) {
            if (salary >= 1500000) {
                return 7000000;
            } else if (salary >= 1000000) {
                return 500000;
            } else if (salary >= 600000) {
                return 200000;
            }
        }
        return 0; // Not eligible
    }
}