package SalaryCalculation;

public class Employee {
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public double computeSalary() {
        return salary;
    }

    public String getName() {
        return "Employee";
    }

    public double getSalary() {
        return salary;
    }
}
