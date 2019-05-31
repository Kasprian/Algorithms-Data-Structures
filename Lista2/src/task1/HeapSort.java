package task1;

public class HeapSort {
    int counterSwap=0;
    int counterComparison=0;

    public HeapSort(int[] array, int length, boolean asc){
        heapsort(array,length,asc);
    }

    void heapsort(int[] array,int n,boolean asc){

        if(asc) {
            for (int i = n / 2 - 1; i >= 0; i--) {
                max_heapify(array, n, i);
            }
            for (int i = n - 1; i >= 0; i--) {
                counterSwap++;
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                max_heapify(array, i, 0);
            }
        }else{
            for (int i = n / 2 - 1; i >= 0; i--) {
                min_heapify(array, n, i);
            }
            for (int i = n - 1; i >= 0; i--) {
                counterSwap++;
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                min_heapify(array, i, 0);
            }
        }
    }

    private void max_heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        counterComparison++;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        counterComparison++;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        counterComparison++;
        if (largest != i) {
            counterSwap++;
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            max_heapify(arr, n, largest);
        }
    }
    void min_heapify(int arr[], int n, int i)
    {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        counterComparison++;
        if (l < n && arr[l] < arr[smallest])
            smallest = l;
        counterComparison++;
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
        counterComparison++;
        if (smallest != i) {
            counterSwap++;
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            min_heapify(arr, n, smallest);
        }
    }
    public int getCounterComparison() {
        return counterComparison;
    }

    public int getCounterSwap() {
        return counterSwap;
    }
}
