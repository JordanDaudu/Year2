package Package1;

import java.util.Scanner;

public class ArraySorter
{

    static int[] readSorter()
    {
        Scanner sc = new Scanner(System.in);
        int[] arr;

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }

    static void printArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static int[] bubbleSort(int[] arr) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        System.out.println("Sorted array using bubble Sort!");
        return arr;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static int[] sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }

    static int[] mergeSort(int[] arr)
    {
        System.out.println("Sorted array using Merge Sort!");
        return sort(arr, 0, arr.length - 1);
    }



    public static void main(String[] args)
    {
        int[] arr = readSorter();
        printArray(arr);


        // Bubble sort
        int[] arr1 = bubbleSort(arr);
        printArray(arr1);
        System.out.print("");

        // Merge sort
        int[] arr2 = mergeSort(arr);
        printArray(arr2);
    }
}
