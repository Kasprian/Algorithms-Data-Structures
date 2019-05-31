package task1;

public class QuickSort {
    int counterSwap=0;
    int counterComparison=0;

    public QuickSort(int[] array, int length, boolean asc){
        quickSort(array,0, length - 1,asc);
    }
    private void quickSort(int array[], int begin, int end, boolean asc) {
        counterComparison++;
        if (begin < end) {
            if(asc) {
                int p = partitionASC(array, begin, end);
                quickSort(array, begin, p - 1, asc);
                quickSort(array, p + 1, end, asc);
            }else{
                int p = partitionDESC(array, begin, end);
                quickSort(array, begin, p - 1, asc);
                quickSort(array, p + 1, end, asc);
            }
        }
    }
    private int partitionASC(int array[], int begin, int end)
    {
        int pivot = array[end];
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
        int pivot = array[end];
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

    public int getCounterComparison() {
        return counterComparison;
    }

    public int getCounterSwap() {
        return counterSwap;
    }
}


