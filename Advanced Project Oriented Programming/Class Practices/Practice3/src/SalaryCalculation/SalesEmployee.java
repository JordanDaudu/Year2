package SalaryCalculation;

public class SalesEmployee extends Employee implements ISale{

    private double commis;

    public SalesEmployee(double salary, double commis) {
        super(salary);
        this.commis = commis;
    }

    @Override
    public double computeSalary() {
        return getSalary() * (1 + (commis / 100));
    }

    @Override
    public double getCom() {
        return commis;
    }

    @Override
    public String getSaleName() {
        return "SalesEmployee";
    }
}
