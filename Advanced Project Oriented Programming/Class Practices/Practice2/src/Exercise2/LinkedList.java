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
    public void add(int data)
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
    }
    public void remove(int data)
    {
        if(head == null)
        {
            System.out.println("Linked list is empty!");
            return;
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
            return;
        }
        Node tmp = head;
        while(tmp.next != null && tmp.next.data != data)
            tmp = tmp.next;
        if(tmp.next == null)
        {
            System.out.println("Data not in linked list");
            return;
        }
        tmp.next = tmp.next.next;
    }
    public boolean find(int data)
    {
        if(head.data == data)
            return true;
        Node tmp = head;
        while(tmp.next != null && tmp.next.data != data)
            tmp = tmp.next;
        if(tmp.next == null)
            return false;
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

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0, data;
        LinkedList list = new LinkedList();
        while(choice != 4)
        {
            System.out.println("1.Add\n2.Remove\n3.Find\n4.Quit");
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
                    list.remove(data);
                }
                case 3 -> {
                    System.out.print("Type data (int): ");
                    data = checkInteger(sc);
                    if(list.find(data))
                        System.out.println("TRUE, data is inside linked list");
                    else
                        System.out.println("FALSE, data isn't inside linked list");
                }
                case 4 -> {
                    break;
                }
                default -> System.out.println("Invalid choice");
            }
        }
        System.out.println("Printing final linked list: ");
        System.out.println(list);
        sc.close();
    }
}
