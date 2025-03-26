package SalaryCalculation;

public class Salary {
    public static void main(String[] args) {

        Employee[] employers = new Employee[4];
        employers[0] = new Employee(1000.0);
        employers[1] = new Manager(1000.0, 1.2);
        employers[2] = new SalesEmployee(1000.0, 1.5);
        employers[3] = new SalesManager(1000.0, 1.2, 1.5);

        for(int i = 0; i < employers.length; i++) {
            System.out.println("Name: " + employers[i].getName());
            System.out.println("Salary: " + employers[i].computeSalary() + "\n");
        }
    }
}
