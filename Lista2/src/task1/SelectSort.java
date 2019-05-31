package task1;

public class SelectSort {
        int counterSwap=0;
        int counterComparison=0;

        public SelectSort(int[] array, int length, boolean asc){
            selectSort(asc,length,array);
        }

        void selectSort(boolean asc, int length, int[] array){
                if(asc) {
                        for (int i = 0; i < length-1; i++){
                                int min_idx = i;
                                for (int j = i+1; j < length; j++) {
                                        counterComparison++;
                                        if (array[j] < array[min_idx])
                                                min_idx = j;
                                }
                                counterSwap++;
                                int temp = array[min_idx];
                                array[min_idx] = array[i];
                                array[i] = temp;
                        }
                }else{
                        for (int i = 0; i < length-1; i++){
                                int max_idx = i;
                                for (int j = i+1; j < length; j++) {
                                        counterComparison++;
                                        if (array[j] > array[max_idx])
                                                max_idx = j;
                                }
                                counterSwap++;
                                int temp = array[max_idx];
                                array[max_idx] = array[i];
                                array[i] = temp;
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
