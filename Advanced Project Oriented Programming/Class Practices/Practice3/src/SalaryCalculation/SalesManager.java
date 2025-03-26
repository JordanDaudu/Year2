package SalaryCalculation;

public class SalesManager extends Manager implements ISale{

    private double commis;

    public SalesManager(double salary, double kmult, double commis) {
        super(salary, kmult);
        this.commis = commis;
    }

    @Override
    public double computeSalary() {
        return getSalary() * getKmult() * (1 + (commis / 100));
    }

    @Override
    public double getCom() {
        return commis;
    }

    @Override
    public String getSaleName() {
        return "SalesManager";
    }
}
