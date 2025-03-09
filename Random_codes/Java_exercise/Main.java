import javax.sound.sampled.*;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // main function
        Scanner scanner = new Scanner(System.in);
        //basicUnderstanding();
        //shoppingCartProgram();
        //math();
        //printf();
        //stringMethods();
        //substringMethods();
        //weightConversionProgram();
        //temperatureConversionProgram();
        //enhancedSwitch();
        //calculationProgram();
        //numberGuessingGame();
        //arrays();
        //inputArrays();
        //int result = varArgs(1,2,3,4);
        //System.out.println(result);
        //array2d();
        //slotMachine();
        //objectOrientedProgramming();
        //objectOrientedProgramming2();
        //staticObjectOrientedProgramming();
        //inheritanceProgramming();
        //abstractExample();
        //interfaceExample();
        //polymorphism();
        //getterAndSetter();
        //arrayList();
        //exceptions();
        //writeFiles();
        //readFiles();
        //musicPlayer();
        //anonymousClasses();
        //timerTask();
        //countdownTimer();
        //generics();
        //hashMaps();
        //enums();
        //threading();
        //multiThreading();
        //alarmClock();
    }
    static void basicUnderstanding() {
        // This is my first java program
        /*
        ❎ variable = a reusable container for a value,
                      a variable behaves as if it was the value it contains

        🟥 Primitive = simple value stored directly in memory(stack)
        🟦 Reference = memory address (stack) that points to the (heap)

        🟥 Primitive vs 🟦 Reference
        ------------    -------------
        int          double
        double       array
        char         object
        boolean
         */
        System.out.println("Hello World");
        System.out.println("");
        int age = 18;
        int year = 2025;
        double price = 19.99;
        char gender = 'M';
        boolean isStudent = true;
        System.out.println("The year is " + year);
        System.out.println("The price is $" + price);
        System.out.println(isStudent);
        String name = "Jordan Daudu";
        System.out.println("The name is " + name);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello " + name + " welcome to the world!");
        System.out.println("Enter you age: ");
        age = scanner.nextInt();
        System.out.println("You are " + age + " years old.");


        int x = 3;
        --x;
        System.out.println(x);
        scanner.close();
    }
    static void shoppingCartProgram() {
        Scanner scanner = new Scanner(System.in);

        String item;
        double price;
        int quantity;
        char currency = '$';
        double total;

        System.out.print("What item would you like to purchase? : ");
        item = scanner.nextLine();
        System.out.print("What is the price for each to purchase? : ");
        price = scanner.nextDouble();
        System.out.print("How many would you like to purchase? : ");
        quantity = scanner.nextInt();

        total = price * quantity;
        System.out.println("\nYou have bought " + quantity + " of " + item + "(s).");
        System.out.println("Your total is " + currency + total);

        scanner.close();
    }
    static void math(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Math.PI);
        System.out.println(Math.E);
        double result;
        result = Math.pow(2.0, 3.0);
        result = Math.sqrt(result);
        result = Math.abs(-5.13);
        result = Math.ceil(5.10);
        result = Math.floor(5.90);
        result = Math.max(10, 20);
        result = Math.min(20, 30);
        result = Math.round(result);
        System.out.println(result);
    }
    static void printf() {
        Scanner scanner = new Scanner(System.in);
        String name = "Spongebob";
        char firstLetter = 'S';
        int age = 30;
        double height = 60.5;
        boolean isEmployed = true;

        System.out.println("---Regular formatting---");
        System.out.printf("Hello %s\n", name);
        System.out.printf("Your name starts wth a %c\n", firstLetter);
        System.out.printf("Your are %d years old\n", age);
        System.out.printf("Your height is %f\n", height);
        System.out.printf("Your height is %.2f\n", height);
        System.out.printf("Employed: %b\n", isEmployed);

        System.out.printf("%s is %d years old.\n", name, age);
        System.out.println("==================");

        // [flags] 🏳️

        // + = output a plus
        // , = comma grouping separator
        // ( = negative numbers are enclosed in ()
        // space  = display a minus if negative, space if positive

        double price1 = 9.99;
        double price2 = 5000.12;
        double price3 = -100;
        double price4 = 200;

        System.out.println("---Flags formatting---");
        System.out.printf("%+.2f\n", price1);
        System.out.printf("%,.2f\n", price2);
        System.out.printf("%(.2f\n", price3);
        System.out.printf("% .2f\n", price4);
        System.out.println("==================");

        // [width]

        // 0 = zero padding
        // number = right justified padding
        // negative number = left justified padding

        int id1 = 1;
        int id2 = 23;
        int id3 = 456;
        int id4 = 789;

        System.out.println("---Width formatting---");
        System.out.printf("%04d\n", id1);
        System.out.printf("%04d\n", id2);
        System.out.printf("%4d\n", id3);
        System.out.printf("%-4d\n", id4);
    }
    static void stringMethods() {
        // Some of the string methods build into java
        String name = "  Jordan Daudu  ";

        int length = name.length();
        char letter = name.charAt(0);
        int index = name.indexOf(" ");
        int lastIndex = name.lastIndexOf("u");
        boolean contains = name.contains("J");

        name = name.toUpperCase();
        name = name.toLowerCase();
        name = name.trim();
        name = name.replace("d", "c");

        System.out.println(length);
        System.out.println(letter);
        System.out.println(index);
        System.out.println(lastIndex);
        System.out.println(name);
        System.out.println(name.isEmpty());
        System.out.println(contains);
    }
    static void substringMethods() {
        // .substring() = A method used to extract a portion of a string
        //                  string.substring(start, end)

        Scanner scanner = new Scanner(System.in);
        String email;

        System.out.print("Enter your email: ");
        email = scanner.nextLine();

        if(email.contains("@"))
        {
            String username = email.substring(0, email.indexOf("@"));
            String domain = email.substring(email.indexOf("@") + 1);

            System.out.println(username);
            System.out.println(domain);
        }
        else
        {
            System.out.println("Invalid email");
        }
        scanner.close();
    }
    static void ifForWhile() {

        int x = 2;
        if(x < 3)
        {
            // something happens
        }
        else if(x >= 3)
        {
            // something else happens
        }
        else
        {
            // if all conditions are false do this
        }
        for(int i = 0; i < 10; i++)
        {
            // example of looping 10 times
        }
        while(x < 2)
        {
            // while condition is true loop
        }
        do
        {
            // do at least once and then loop if while condition true
        }
        while(x < 2);
    }
    static void weightConversionProgram() {
        // declare variables
        Scanner scanner = new Scanner(System.in);

        double weight;
        double newWeight;
        int choice;

        System.out.println("Weight conversion program: ");
        System.out.println("1: convert lbs to kgs");
        System.out.println("2: convert kgs to lbs");

        System.out.print("Choose an option: ");
        choice = scanner.nextInt();

        if (choice == 1)
        {
            System.out.print("Enter weight in lbs: ");
            weight = scanner.nextDouble();
            newWeight = weight * 0.453592;
            System.out.printf("The new weight in kgs is: %.2f", newWeight);
        }
        else if (choice == 2) {
            System.out.print("Enter weight in kgs: ");
            weight = scanner.nextDouble();
            newWeight = weight * 2.20462;
            System.out.printf("The new weight in lbs is: %.2f", newWeight);
        }
        else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
    static void ternaryOperator() {

        // ternary operator ? = return 1 of 2 values if a condition is true

        // variable = (condition) ? ifTrue : ifFalse;

        int score = 70;

        String passOrFail = (score >= 60) ? "Pass" : "Fail";

        System.out.println(passOrFail);
    }
    static void temperatureConversionProgram() {

        Scanner scanner = new Scanner(System.in);

        double temp;
        double newTemp;
        String unit;

        System.out.print("Enter the temperature: ");
        temp = scanner.nextDouble();

        System.out.print("convert to celsius or fahrenheit? (C or F): ");
        unit = scanner.next().toUpperCase();

        // (condition) ? ifTrue : ifFalse

        newTemp = (unit.equals("C")) ? (temp - 32) * 5 / 9 : (temp * 5 / 9) + 32;

        System.out.printf("%.1f°%s\n", newTemp, unit);

        scanner.close();
    }
    static void enhancedSwitch() {

        // enhanced switch = A replacement to many else if statements (Java14 feature)

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the day of the week: ");
        String day = scanner.nextLine();

        switch(day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ->
                    System.out.println("It is a weekday 😩");
            case "Saturday", "Sunday" ->
                    System.out.println("It is a weekend 😃");
            default -> System.out.println(",Invalid day");
        }
        scanner.close();
    }
    static void calculationProgram() {
        Scanner scanner = new Scanner(System.in);

        double num1;
        double num2;
        char operator;
        double result = 0.0;
        boolean validOperation = true;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /, ^): ");
        operator = scanner.next().charAt(0);

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        switch(operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if(num2 == 0) {
                    validOperation = false;
                    System.out.println("Cannot divide by zero");
                }
                else
                    result = num1 / num2;
            }
            case '^' -> result = Math.pow(num1, num2);
            default -> {
                validOperation = false;
                System.out.println("Invalid operator");
            }
        }
        if(validOperation)
            System.out.println(result);

        scanner.close();
    }
    static void numberGuessingGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int guess;
        int attempts = 0;
        int randomNumber = random.nextInt(1, 11);


        System.out.println("Number Guessing Game");
        System.out.println("Guess a number between 1 and 10: ");

        do {
            System.out.print("Enter a guess: ");
            guess = scanner.nextInt();
            attempts++;

            if(guess < randomNumber)
                System.out.println("TOO LOW! Try again");
            else if(guess > randomNumber)
                System.out.println("TOO HIGH! Try again");

        }
        while(guess != randomNumber);

        System.out.println("You guess right! You have done it in " + attempts + " attempts.");

        scanner.close();
    }
    static void arrays() {

        String[] fruits = {"apple", "orange", "banana", "pineapple"};

        int numOfFruits = fruits.length;

        for(int i = 0; i < numOfFruits; i++)
        {
            System.out.println(fruits[i]);
        }

        Arrays.sort(fruits);
        for(String fruit : fruits)
            System.out.println(fruit);

        Arrays.fill(fruits, "coconut");
        for(String fruit : fruits)
            System.out.println(fruit);
    }
    static void inputArrays() {
        Scanner scanner = new Scanner(System.in);

        String[] foods;
        int size;

        System.out.print("Enter the number of foods: ");
        size = scanner.nextInt();
        scanner.nextLine();
        foods = new String[size];

        for(int i = 0; i < foods.length; i++)
        {
            System.out.print("Enter a food: ");
            foods[i] = scanner.nextLine();
        }

        for(String food : foods)
        {
            System.out.println(food);
        }
        scanner.close();
    }
    static int varArgs(int... args) {
        // varargs = allow a method to accept a varying # of arguments
        //           makes methods more flexible, no need for overloaded methods
        //           java will pack the arguments into an array
        //           ... (ellipsis)
        // varArgs(1,2,3,4);

        int sum = 0;
        for(int number : args)
            sum += number;
        return sum;
    }
    static void array2d() {
        // 2D array = An array where each element is an array
        //            Useful for storing a matrix of data

        String[] fruits = {"apple", "orange", "banana"};
        String[] vegetables = {"potato", "onion", "carrot"};
        String[] meats = {"chicken", "pork", "beef", "fish"};

        String[][] groceries = {fruits, vegetables, meats};
        // String[][] groceries = {{"apple", "orange", "banana"}, {"potato", "onion", "carrot"}, {"chicken", "pork", "beef", "fish"}}

        for(String[] foods : groceries)
        {
            for(String food : foods)
                System.out.print(food + " ");
            System.out.println();
        }

        char[][] telephone = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};

        for(char[] row : telephone)
        {
            for (char number : row)
                System.out.print(number + " ");
            System.out.println();
        }
    }
    static void slotMachine() {
        // slot machine program
        Scanner scanner = new Scanner(System.in);

        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("*****************************");
        System.out.println("   Welcome to Java Slots   ");
        System.out.println("   Symbols: 🍒🍉🍋🔔⭐️");
        System.out.println("*****************************");

        while(balance > 0) {
            System.out.println("Current balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if(bet > balance) {
                System.out.println("INSUFFICIENT BALANCE");
                continue;
            }
            else if(bet <= 0) {
                System.out.println("bet must be greater than 0");
            }
            else {
                balance -= bet;
                System.out.println("Your balance: $" + balance);
            }
            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);

            if(payout > 0) {
                System.out.println("You won $" + payout);
                balance += payout;
            }
            else
                System.out.println("Sorry you lost this round");

            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.nextLine().toUpperCase();
            if(playAgain.equals("N"))
                break;

        }
        System.out.println("GAME OVER! Your final balance: $" + balance);
        scanner.close();
    }
    static String[] spinRow() {

        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐️"};
        String[] row = new String[3];
        Random random = new Random();

        for(int i = 0; i < 3; i++)
            row[i] = symbols[random.nextInt(0, 5)];

        return row;
    }
    static void printRow(String[] row) {
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }
    static int getPayout(String[] row, int bet) {

        if(row[0].equals(row[1]) && row[1].equals(row[2]))
            return switch(row[0])
            {
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "⭐️" -> bet * 20;
                default -> 0;
            };
        else if(row[0].equals(row[1]) || row[1].equals(row[2]))
            return switch(row[1])
            {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐️" -> bet * 10;
                default -> 0;
            };
        return 0;
    }
    static void objectOrientedProgramming() {

        // Object = An entity that holds data (attributes)
        //          and can perform actions (methods)
        //          It is a reference data type

        Car car = new Car();

        car.start();
        System.out.println(car.isRunning);

        car.stop();
        System.out.println(car.isRunning);

        car.drive();
        car.brake();
    }
    static void objectOrientedProgramming2() {

        Student student1 = new Student("Jordan", 23, 4.5, true);
        Student student2 = new Student("Naor", 20, 2.2, false);

        System.out.println(student1.name);
        System.out.println(student2.name);

        student1.study();
        student2.study();
    }
    static void staticObjectOrientedProgramming() {

        // static = Makes a variable or method belong to the class
        //          rather than to any specific object.
        //          Commonly used for utility methods or shared resources.

        Friend friend1 = new Friend("Jordan");
        Friend friend2 = new Friend("Naor");
        Friend friend3 = new Friend("Joe");

        Friend.showFriends();
    }
    static void inheritanceProgramming() {

        // Inheritance = One class inherits the attributes and methods
        //               from another class.
        //               Child <- Parent <- Grandparent

        // super = Refers to the parent class (subclass <- superclass)
        //         Used in constructors and method overriding
        //         Calls the parent constructor to initialize attributes

        Dog dog = new Dog(true, 1);

        System.out.println(dog.isAlive);
        dog.speak();
    }
    static void abstractExample() {

        // abstract = Used to define abstract classes and methods.
        //            Abstraction is the process of hiding implementation details
        //            and showing only the essential features.
        //            Abstract classes CAN'T be instantiated directly
        //            Can contain 'abstract' methods (which must be implemented)
        //            Can contain 'concrete' methods (which are inherited)

        // Shape shape = new Shape(); ERROR

        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(4, 5);
        Rectangle rectangle = new Rectangle(4, 5);

        circle.display();
        triangle.display();
        rectangle.display();

        System.out.println(circle.area());
        System.out.println(triangle.area());
        System.out.println(rectangle.area());
    }
    static void interfaceExample() {

        // Interface = A blueprint for a class that specifies a set of abstract methods
        //             that implementing classes MUST define.
        //             Supports multiple inheritance-like behavior.

        Rabbit rabbit = new Rabbit();
        Hawk hawk = new Hawk();
        Fish fish = new Fish();

        rabbit.flee();
        hawk.hunt();
        fish.flee();
        fish.hunt();
    }
    static void polymorphism() {

        // Polymorphism = "POLY" = "MANY"
        //                "MORPH" = "SHAPE"
        //                Object can identify as other objects.
        //                Objects can be treated as objects of a common superclass.
        //                Note: For this example vehicle can be a interface as well

        Bike bike = new Bike();
        Boat boat = new Boat();

        Vehicle[] vehicles = {bike, boat};
        for(Vehicle vehicle : vehicles) {
            vehicle.go();
        }

        // Runtime polymorphism = When the method that gets executed is decided
        //                        at runtime based on the actual type of the object.
        Scanner scanner = new Scanner(System.in);

        Vehicle vehicle;

        System.out.print("Would you like a bike or a boat? (1 = Bike, 2 = Boat): ");
        int choice = scanner.nextInt();

        if(choice == 1) {
            vehicle = new Bike();
            vehicle.go();
        }
        else if(choice == 2) {
            vehicle = new Boat();
            vehicle.go();
        }
    }
    static void getterAndSetter() {

        // They help protect object data and add rules for accessing or modifying them.
        // GETTERS = Methods that make a field READABLE.
        // SETTERS = Methods that make a field WRITEABLE.

        Car car = new Car("Tesla", "Charger", 2020, 50000.99);

        car.setModel("X");

        System.out.println(car.getMake() + " " + car.getModel() + " " + car.getYear() + " Price: $" + car.getPrice());
    }
    static void arrayList() {

        // ArrayList = A resizable array that stores objects (autoboxing)
        //             Arrays are fixed in size, but array ArrayLists can change

        ArrayList<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Grape");

        list.remove(0);
        list.set(0, "Pineapple");

        for(String s : list)
            System.out.println(s);

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> foods = new ArrayList<>();
        System.out.print("Type how many foods you want to add?: ");
        int numOfFoods = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i <= numOfFoods; i++) {
            System.out.print("Enter food " + i + ": ");
            String food = scanner.nextLine();
            foods.add(food);
        }
        System.out.println(foods);

        scanner.close();
    }
    static void exceptions() {

        // Exceptions = An event that interrupts the normal flow of a program
        //              (Dividing by zero, file not found, mismatch input type)
        //              Surround any dangerous code with a try{} block
        //              try{}, catch{}, finally{}

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Please enter a number: ");
            int number = scanner.nextInt();
            System.out.println(number);
        }
        catch(InputMismatchException e) {
            System.out.println("Didnt enter a number!");
        }
        catch(ArithmeticException e) {
            System.out.println("You can't divide by zero!");
        }
        catch(Exception e) {
            System.out.println("Something went wrong!");
        }
        finally{
            scanner.close();
            System.out.println("This always executes");
        }
    }
    static void writeFiles() {

        // How to write a file using Java(4 popular options)

        // FileWriter = Good for small or medium-sized text files
        // BufferedWriter = Better performance for large amount of text
        // PrintWriter = Best for structured data, like reports or logs
        // FileOutputStream = Best for binary files (e.g, images, audio files)

        // import java.io.FileWriter;

        try(FileWriter writer = new FileWriter("test.txt")) {
            writer.write("I like pizza!");
            System.out.println("File written!");
        }
        catch(IOException e) {
            System.out.println("Could not write to test file!");
        }
    }
    static void readFiles() {

        // How to read a file using Java (3 popular options)

        // BufferedReader + FileReader: Best for reading text files line-by-line
        // FileInputStream: Best for binary files (e.g., images, audio files)
        // RandomAccessFile: Best for read/write specific portions of a large file


        // import java.io.BufferedReader;
        // import java.io.FileReader;

        String filepath = "test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch(IOException e) {
            System.out.println("Something went wrong!");
        }
    }
    static void musicPlayer() {

        // How to PLAY AUDIO with Java (.wav, .au, .aiff)

        // import java.io.file

        String filepath = "src/Don't worry [2XDv].wav";
        File file = new File(filepath);

        // import javax.sound.sampled.AudioInputStream;
        // import javax.sound.sampled.AudioSystem;
        // import javax.sound.sampled.UnsupportedAudioFileException;
        // import javax.sound.sampled.Clip;

        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while(!response.equals("Q")) {

                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter your choice: ");
                response = scanner.next().toUpperCase();

                switch(response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch(UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported!");
        }
        catch(LineUnavailableException e) {
            System.out.println("Unable to access the audio file!");
        }
        catch(IOException e) {
            System.out.println("Something went wrong!");
        }
        finally {
            System.out.println("Done!");
        }
    }
    static void anonymousClasses() {

        // Anonymous class = A class that doesn't have a name. Cannot be reused.
        //                   Add custom behavior without having to create a new class.
        //                   Often used for one time uses (TimerTask, Runnable, callbacks)

        Dog dog1 = new Dog();
        Dog dog2 = new Dog() {
            @Override
            void speak(){
                System.out.println("Scooby Doo says *Ruh Roh*");
            }
        };
        dog1.speak();
        dog2.speak();
    }
    static void timerTask() {

        // Timer = Class that schedules tasks at specific times or periodically
        //         Useful for: sending notifications, scheduled updates, repetitive actions.

        // TimerTask = Represents the task that will be executed by the Timer
        //             You will extend the TimerTask class to define your task
        //             Create a subclass of TimerTask and @Override run()

        // java.util.Timer
        // java.util.TimerTask

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            int count = 3;
            @Override
            public void run() {
                System.out.println("Timer is running");
                count--;
                if(count <= 0) {
                    System.out.println("Timer is over");
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 3000, 1000);
    }
    static void countdownTimer() {

        // Java COUNTDOWN TIMER PROGRAM

        // java.util.Timer
        // java.util.TimerTask

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter # of seconds to countdown from: ");
        int seconds = scanner.nextInt();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            int count = seconds;

            @Override
            public void run() {
                System.out.println(count);
                count--;
                if(count < 0) {
                    System.out.println("HAPPY NEW YEAR!");
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // (task, delay, period)
        scanner.close();
    }
    static void generics() {

        // Generics = A concept where you can write a class, interface, or method
        //            that is compatible with different data types.
        //            <T> type parameter (placeholder that gets replaced with a real type)
        //            <String> type arguments (specifies the type)

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        Box<String> box = new Box<>();

        box.setItem("banana");
        System.out.println(box.getItem());

        Product<String, Double> product = new Product<>("apple", 0.50);
        System.out.println(product.getItem() + " " + product.getPrice());
    }
    static void hashMaps() {

        // HashMap = A data strcture that stores key-value pairs
        //           Keys are unique, but Values can be duplicated
        //           Does not maintain any order, but is memory efficient
        //           HashMap<Key, Value>

        // java.utils.HashMap;

        HashMap<String, Double> map = new HashMap();

        map.put("apple", 0.50);
        map.put("banana", 0.25);
        map.put("orange", 0.75);

        System.out.println(map); // prints all keys-values in "{Key=Value, ...}" format

        map.remove("apple"); // removes from mapping
        System.out.println(map.get("orange")); // getting 0.75 (value)
        System.out.println(map.containsKey("banana")); // returning booleans if true or false
        System.out.println(map.containsValue(0.213)); // returning booleans if true or false
        System.out.println(map.size()); // returns the size of the map

        if(map.containsKey("banana"))
            System.out.println(map.get("banana")); // will give price (value)
        else
            System.out.println(map.get("Key not found!"));

        for(String key : map.keySet())
            System.out.println(key + " : $" + map.get(key));
    }
    static void enums() {

        // Enums = (Enumerations) A special kind of class that
        //         represent a fixed set of constants.
        //         They improve code readability and are easy to maintain.
        //         More efficient with switches when comparing Strings.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day of the week: ");
        String response = scanner.next().toUpperCase();

        try {
            // Day day = day.SUNDAY // direct approach
            Day day = Day.valueOf(response);

            System.out.println(day);
            System.out.println(day.getDayNumber());

            switch(day){
                case SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> System.out.println("It is a weekday");
                case FRIDAY, SATURDAY -> System.out.println("It is a weekend");
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("Please enter a valid day");
        }
        scanner.close();
    }
    static void threading() {

        // Threading = Allows a program to run multiple tasks simultaneously
        //             Helps improve performance with time-consuming operations
        //             (File I/O, network communications, or any background tasks)

        // How to create a Thread
        // Option 1. Extend the Thread class (simpler)
        // Option 2. Implement the runnable interface (better)

        Scanner scanner = new Scanner(System.in);

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setDaemon(true); // Ends when the main thread is over
        thread.start();

        System.out.println("You have 5 seconds to enter your name");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);

        scanner.close();
    }
    static void multiThreading() {

        // Multithreading = Enables a program to run multiple threads concurrently
        //                  (Thread = A set of instructions that run independently)
        //                  Useful for background tasks or time-consuming operations.

        //MyRunnableMultiThreading myRunnable  = new MyRunnableMultiThreading();
        // Code line above is if we want it to not be an anonymous object, we will create an anonymous object
        Thread thread1 = new Thread(new MyRunnableMultiThreading("PING"));
        Thread thread2 = new Thread(new MyRunnableMultiThreading("PONG"));

        System.out.println("GAME START!");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }
        System.out.println("GAME END!");
    }
    static void alarmClock() {

        // JAVA ALARM CLOCK

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath = "src/Don't worry [2XDv].wav";

        while(alarmTime == null) {
            try {
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);
            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use HH:MM:SS");
            }
        }
        AlarmClock alarmClock = new AlarmClock(alarmTime, filepath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}