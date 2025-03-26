package SalaryCalculation;

public class Manager extends Employee {

    private double kmult;

    public Manager(double salary, double kmult) {
        super(salary);
        this.kmult = kmult;
    }

    @Override
    public double computeSalary()
    {
        return getSalary() * kmult;
    }

    @Override
    public String getName() {
        return "Manager";
    }

    public double getKmult() {
        return kmult;
    }
}
