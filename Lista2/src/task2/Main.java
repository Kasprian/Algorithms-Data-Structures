package task2;

import task1.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean asc = true;
        Random random = new Random();
        int k = 0;
        String file ="";
        try {
            if(!( args[0].equals("--desc") || args[0].equals("--asc"))) {
                System.err.println("Wrong arguments.");
                System.exit(1);
            }
            if(args[0].equals("--desc")){
                asc = false;
            }
            if (args[1].equals("--stat")) {
                k = Integer.parseInt(args[2]);
            }
        } catch (Exception ArrayIndexOutOfBoundsException) {
            System.err.println("Check arguments. You forget something.");
            System.exit(1);
        }

        long startTime,estimatedTime;

        for (int i = 1; i <= k; i++) {
            for (int n = 100; n <= 10000; n = n + 100) {
                int[] A = new int[n];
                for (int j = 0; j < n; j++) {
                    A[j] = random.nextInt();
                }
                int B[] = A.clone();

                startTime = System.nanoTime();
                SelectSort sort = new SelectSort(B, n, asc);
                estimatedTime = System.nanoTime() - startTime;

                PrintWriter fileWriter = null;
             /*   try {
                    fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("select"+k+".txt", true)));

                    fileWriter.println((A.length + " " + sort.getCounterComparison() + " " + sort.getCounterSwap() + " " + estimatedTime));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }

                int C[] = A.clone();
                startTime = System.nanoTime();
                InsertionSort sort2 = new InsertionSort(C, n, asc);
                estimatedTime = System.nanoTime() - startTime;
                fileWriter = null;
                try {
                    fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("insertion"+k+".txt", true)));

                    fileWriter.println((A.length + " " + sort2.getCounterComparison() + " " + sort2.getCounterSwap() + " " + estimatedTime));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }


                int D[] = A.clone();
                startTime = System.nanoTime();
                HeapSort sort3 = new HeapSort(D, n, asc);
                estimatedTime = System.nanoTime() - startTime;
                fileWriter = null;
                try {
                    fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("heap"+k+".txt", true)));

                    fileWriter.println((A.length + " " + sort3.getCounterComparison() + " " + sort3.getCounterSwap() + " " + estimatedTime));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }*/

                int E[] = A.clone();
                startTime = System.nanoTime();
                QuickSort sort4 = new QuickSort(E, n, asc);
                estimatedTime = System.nanoTime() - startTime;

                fileWriter = null;
                try {
                    fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("quick"+k+".txt", true)));

                    fileWriter.println((A.length + " " + sort4.getCounterComparison() + " " + sort4.getCounterSwap() + " " + estimatedTime));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }
                int F[] = A.clone();
                startTime = System.nanoTime();
                ModyfiedQuickSort sort5 = new ModyfiedQuickSort(F, n, asc);
                estimatedTime = System.nanoTime() - startTime;

                fileWriter = null;
                try {
                    fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("mquick"+k+".txt", true)));

                    fileWriter.println((A.length + " " + sort5.getCounterComparison() + " " + sort5.getCounterSwap() + " " + estimatedTime));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }
            }
        }
    }

    private static void print(int array[]) {
        for (int anArray : array) System.out.print(anArray + " ");
        System.out.println();
    }
}


