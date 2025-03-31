package Exercise1;
import java.util.Scanner;

public class Rational
{
    private final int numerator;
    private final int denominator;

    public Rational()
    {
        this(1, 1);
    }
    public Rational(int a, int b)
    {
        if(b == 0)
            throw new IllegalArgumentException("Denominator cannot be 0");
        int commonDivider = gcd(a, b);
        numerator = a / commonDivider;
        denominator = b / commonDivider;
    }
    public Rational plus(Rational other)
    {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        int commonDivider = gcd(newNumerator, newDenominator);
        return new Rational(newNumerator / commonDivider, newDenominator / commonDivider);
    }
    public Rational minus(Rational other)
    {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        int commonDivider = gcd(newNumerator, newDenominator);
        return new Rational(newNumerator / commonDivider, newDenominator / commonDivider);
    }
    public Rational multiply(Rational other)
    {
        Rational newRational = new Rational();
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        int commonDivider = gcd(newNumerator, newDenominator);
        return new Rational(newNumerator / commonDivider, newDenominator / commonDivider);
    }
    public Rational divide(Rational other)
    {
        if (other.numerator == 0)
            throw new ArithmeticException("Cannot divide by zero.");
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        int commonDivider = gcd(newNumerator, newDenominator);
        return new Rational(newNumerator / commonDivider, newDenominator / commonDivider);
    }
    public int getNumerator()
    {
        return numerator;
    }
    public int getDenominator()
    {
        return denominator;
    }
    public String toString()
    {
        return numerator + "/" + denominator;
    }
    public boolean equals(Rational other)
    {
        int commonDivider = gcd(this.numerator, this.denominator);
        int otherCommonDivider = other.numerator * other.denominator;
        if(!(this.numerator / commonDivider == other.numerator / commonDivider))
            return false;
        if(!(this.denominator / otherCommonDivider == other.denominator / otherCommonDivider))
            return false;
        return true;

    }


    // gcd() method, returns the GCD of a and b
    static int gcd(int a, int b)
    {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Ensure GCD is always positive
    }
    public static void main(String[] args)
    {
        int numerator, denominator;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.println("\nEnter 2 rational numbers:");
                System.out.print("Enter first number numerator:");
                numerator = sc.nextInt();
                System.out.print("Enter first number denominator: ");
                denominator = sc.nextInt();
                Rational r1 = new Rational(numerator, denominator);
                System.out.print("Enter second number numerator:");
                numerator = sc.nextInt();
                System.out.print("Enter second number denominator: ");
                denominator = sc.nextInt();
                Rational r2 = new Rational(numerator, denominator);
                System.out.println("plus operation: " + r1.plus(r2));
                System.out.println("minus operation: " + r1.minus(r2));
                System.out.println("multiply operation: " + r1.multiply(r2));
                System.out.println("divide operation: " + r1.divide(r2));
                System.out.println("equals operation: " + r1.equals(r2));
                break;
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Input error!: " + e.getMessage());
            }
            catch(ArithmeticException e)
            {
                System.out.println("Arithmetic error!: " + e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Error! something went wrong");
            }
        }
        sc.close();
        /*
        System.out.println("Enter 2 rational numbers:");
        System.out.print("Enter first number numerator:");
        numerator = sc.nextInt();
        System.out.print("Enter first number denominator: ");
        denominator = sc.nextInt();
        Rational r1 = new Rational(numerator, denominator);
        System.out.print("Enter second number numerator:");
        numerator = sc.nextInt();
        System.out.print("Enter second number denominator: ");
        denominator = sc.nextInt();
        Rational r2 = new Rational(numerator, denominator);
        System.out.println("plus operation: " + r1.plus(r2));
        System.out.println("minus operation: " + r1.minus(r2));
        System.out.println("multiply operation: " + r1.multiply(r2));
        System.out.println("divide operation: " + r1.divide(r2));
        System.out.println("equals operation: " + r1.equals(r2));

        sc.close();
        */
    }
}
