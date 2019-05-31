package task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        boolean asc = true;

        try {
            if(!(args[0].equals("--type") &&  ( args[2].equals("--desc") || args[2].equals("--asc")))) {
                System.err.println("Wrong arguments.");
                System.exit(1);
            }
            if(!(args[1].equals("select") || args[1].equals("insert") || args[1].equals("heap") || args[1].equals("quick")||  args[1].equals("mquick")) ){
                System.err.println("I can sort only with select, insert, heap and quick option.");
                System.exit(1);
            }
            if(args[2].equals("--desc")){
                asc = false;
            }
        } catch (Exception ArrayIndexOutOfBoundsException) {
            System.err.println("Check arguments. You forget something.");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        switch(args[1]){
            case "select": {
                long startTime = System.nanoTime();
                SelectSort sort = new SelectSort(array, n, asc);
                long estimatedTime = System.nanoTime() - startTime;
                System.err.println("\nCompare: " + sort.counterComparison);
                System.err.println("Swap: " + sort.counterSwap + "\n");
                print(array);
                System.out.println("Time: " + estimatedTime);
                break;
            }
            case "insert": {
                long startTime = System.nanoTime();
                InsertionSort sort = new InsertionSort(array, n, asc);
                long estimatedTime = System.nanoTime() - startTime;
                System.err.println("\nCompare: " + sort.counterComparison);
                System.err.println("Swap: " + sort.counterSwap + "\n");
                print(array);
                System.out.println("Time: " + estimatedTime);
                break;
            }
            case "heap": {
                long startTime = System.nanoTime();
                HeapSort sort = new HeapSort(array, n, asc);
                long estimatedTime = System.nanoTime() - startTime;
                System.err.println("\nCompare: " + sort.counterComparison);
                System.err.println("Swap: " + sort.counterSwap + "\n");
                print(array);
                System.out.println("Time: " + estimatedTime);
                break;
            }
            case "quick": {
                long startTime = System.nanoTime();
                QuickSort sort = new QuickSort(array, n, asc);
                long estimatedTime = System.nanoTime() - startTime;
                System.err.println("\nCompare: " + sort.counterComparison);
                System.err.println("Swap: " + sort.counterSwap + "\n");
                print(array);
                System.out.println("Time: " + estimatedTime);
                break;
            }
            case "mquick": {
                long startTime = System.nanoTime();
                ModyfiedQuickSort sort = new ModyfiedQuickSort(array, n, asc);
                long estimatedTime = System.nanoTime() - startTime;
                System.err.println("\nCompare: " + sort.counterComparison);
                System.err.println("Swap: " + sort.counterSwap + "\n");
                print(array);
                System.out.println("Time: " + estimatedTime);
                break;
            }
        }
    }

    private static void print(int array[]) {
        for (int anArray : array) System.out.print(anArray + " ");
    }
}
