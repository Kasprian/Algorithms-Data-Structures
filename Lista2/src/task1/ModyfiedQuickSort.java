package task1;

public class ModyfiedQuickSort {
    int counterSwap=0;
    int counterComparison=0;
    public ModyfiedQuickSort(int[] array, int length, boolean asc){
            modyfiedQuickSort(array, 0, length-1, asc);
    }
    private void modyfiedQuickSort(int array[], int begin, int end, boolean asc) {
        counterComparison++;
        if (begin < end) {
            if(end-begin<16){
                insertionSort(array,begin,end,asc);
            }else {
                if (asc) {
                    int p = partitionASC(array, begin, end);
                    modyfiedQuickSort(array, begin, p - 1, asc);
                    modyfiedQuickSort(array, p + 1, end, asc);
                } else {
                    int p = partitionDESC(array, begin, end);
                    modyfiedQuickSort(array, begin, p - 1, asc);
                    modyfiedQuickSort(array, p + 1, end, asc);
                }
            }
        }
    }
    private void insertionSort(int[] array, int begin,int end, boolean asc) {
        if (asc) {
            for (int index = begin+1; index < end+1; index++) {
                int value = array[index];
                int i = index - 1;
                counterComparison++;
                while (i >= 0 && array[i]>value) {
                    counterComparison++;
                    array[i + 1] = array[i];
                    counterSwap++;
                    i--;
                }
                counterSwap++;
                array[i+1] = value;
            }
        } else {
            for (int index = begin+1; index < end+1; index++) {
                int value = array[index];
                int i = index - 1;
                counterComparison++;
                while (i >= 0 && array[i]<value) {
                    counterComparison++;
                    array[i + 1] = array[i];
                    counterSwap++;
                    i--;
                }
                array[i+1] = value;
                counterSwap++;
            }
        }
    }

    private int partitionASC(int array[], int begin, int end)
    {
        int pivot =  getPivotASC(array,begin,end);
        int i = (begin-1);//granica
        for (int j=begin; j<end; j++) {
            counterComparison++;
            if (array[j] <= pivot) {
                i++;
                counterSwap++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //wstawienie pivota na swoje miejsce
        counterSwap++;
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;

        return i+1;
    }
    private int partitionDESC(int array[], int begin, int end) {
        int pivot = getPivotDESC(array,begin,end);
        int i = (begin-1);//granica
        for (int j=begin; j<end; j++) {
            counterComparison++;
            if (array[j] >= pivot) {
                i++;
                counterSwap++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //wstawienie pivota na swoje miejsce
        counterSwap++;
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;

        return i+1;
    }
    private int getPivotASC(int array[], int begin, int end){
        int middle = ( begin + end ) / 2;
        counterComparison++;
        if( array[ middle ] < array[ begin ] ) {
            int temp = array[begin];
            array[begin] = array[middle];
            array[middle] = temp;
            counterSwap++;
        }
        counterComparison++;
        if( array[ end] <array[ begin ] ) {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            counterSwap++;
        }
        counterComparison++;
        if( array[ end]< array[ middle ] ) {
            int temp = array[middle];
            array[middle] = array[end];
            array[end] = temp;
            counterSwap++;
        }
        return array[middle];
    }
    private int getPivotDESC(int array[], int begin, int end){
        int middle = ( begin + end ) / 2;
        counterComparison++;
        if( array[ middle ] > array[ begin ] ) {
            int temp = array[begin];
            array[begin] = array[middle];
            array[middle] = temp;
            counterSwap++;
        }
        counterComparison++;
        if( array[ end] >array[ begin ] ) {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            counterSwap++;
        }
        counterComparison++;
        if( array[ end]> array[ middle ] ) {
            int temp = array[middle];
            array[middle] = array[end];
            array[end] = temp;
            counterSwap++;
        }
        return array[middle];
    }

    public int getCounterComparison() {
        return counterComparison;
    }

    public int getCounterSwap() {
        return counterSwap;
    }
}
