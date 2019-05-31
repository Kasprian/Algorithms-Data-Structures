package task1;

public class InsertionSort {
    int counterComparison = 0;
    int counterSwap = 0;

    public InsertionSort(int[] array, int length, boolean asc) {
        insertionSort(array, length, asc);
    }

    private void insertionSort(int[] array, int length, boolean asc) {
        if (asc) {
            for (int index = 1; index < length; index++) {
                int value = array[index];
                int i = index - 1;
                counterComparison++;
                boolean first=true;
                while (i >= 0 && array[i]>value) {
                    if(!first) {
                        counterComparison++;
                    }
                    array[i + 1] = array[i];
                    counterSwap++;
                    i--;
                    first=false;
                }
                counterSwap++;
                array[i+1] = value;
            }
        } else {
            for (int index = 1; index < length; index++) {
                int value = array[index];
                int i = index - 1;
                counterComparison++;
                boolean first=true;
                while (i >= 0 && array[i]<value) {
                    if(!first) {
                        counterComparison++;
                    }
                    array[i + 1] = array[i];
                    counterSwap++;
                    i--;
                    first=false;
                }
                array[i+1] = value;
                counterSwap++;
            }
        }
    }

    public int getCounterComparison() {
        return counterComparison;
    }

    public int getCounterSwap() {
        return counterSwap;
    }
}
