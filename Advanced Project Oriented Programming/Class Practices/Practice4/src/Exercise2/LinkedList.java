package Exercise2;
import java.util.Scanner;

public class LinkedList
{
    private Node head;
    private Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }
    public String toString()
    {
        if(head == null)
            return "Null";
        Node tmp = head;
        String string = "";
        while(tmp != tail)
        {
            string = string + tmp.data + " -> ";
            tmp = tmp.next;
        }
        string = string + tail.data;
        return string;
    }
    public boolean add(int data)
    {
        Node node = new Node(data);
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
        return true;
    }
    public boolean remove(int data)
    {
        if(head == null) {
            throw new EmptyListOperationException("Linked list is empty!");
        }
        if(head.data == data)
        {
            if(head == tail)
            {
                head = null;
                tail = null;
            }
            else
                head = head.next;
            return true;
        }
        Node tmp = head;
        while(tmp.next != null && tmp.next.data != data)
            tmp = tmp.next;
        if(tmp.next == null)
        {
            System.out.println("Data not in linked list");
            return false;
        }
        if(tmp.next == tail)
            tail = tmp;
        tmp.next = tmp.next.next;
        return true;
    }
    public boolean find(int data)
    {
        if(head == null) {
            throw new EmptyListOperationException("Linked list is empty!");
        }
        if(head.data == data)
        {
            System.out.println("TRUE, data is inside linked list");
            return true;
        }
        Node tmp = head;
        while(tmp.next != null && tmp.next.data != data)
            tmp = tmp.next;
        if(tmp.next == null)
        {
            System.out.println("FALSE, data isn't inside linked list");
            return false;
        }
        System.out.println("TRUE, data is inside linked list");
        return true;
    }

    private class Node
    {
        private int data;
        private Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        public int getData()
        {
            return this.data;
        }
        public Node getNext()
        {
            return this.next;
        }
    }
    static int checkInteger(Scanner sc)
    {
        while (!sc.hasNextInt()) { // Check if the next input is an integer
            System.out.print("Invalid input! Please enter a valid integer: ");
            sc.next(); // Consume the invalid input
        }
        return sc.nextInt();
    }
    public class EmptyListOperationException extends RuntimeException {
        public EmptyListOperationException(String message) {
            super(message);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0, data;
        LinkedList list = new LinkedList();
        while(choice != 5)
        {
            try
            {
                System.out.println("1.Add\n2.Remove\n3.Find\n4.Print Linked List\n5.Quit");
                choice = checkInteger(sc);
                switch (choice)
                {
                    case 1 -> {
                        System.out.print("Type data (int): ");
                        data = checkInteger(sc);
                        list.add(data);
                    }
                    case 2 -> {
                        System.out.print("Type data (int): ");
                        data = checkInteger(sc);
                        System.out.println(list.remove(data));
                    }
                    case 3 -> {
                        System.out.print("Type data (int): ");
                        data = checkInteger(sc);
                        list.find(data);
                    }
                    case 4 -> {
                        System.out.println(list);
                    }
                    case 5 -> System.out.println("Leaving...");
                    default -> System.out.println("Invalid choice");
                }
            }
            catch(EmptyListOperationException e) {
                System.out.println("Error! " + e.getMessage());
            }
            catch(Exception e) {
                System.out.println("Error! something went wrong.");
            }
        }
        System.out.print("\nPrinting final linked list: ");
        System.out.println(list);
        sc.close();
    }
}
