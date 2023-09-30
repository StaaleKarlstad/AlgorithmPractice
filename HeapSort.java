
public class HeapSort {
    
    public static void sort(Integer[] arr){
        int size = arr.length;
        for (int i = size/2; i >= 1; i--){  //Parent index
            heapify(arr, i, size);
        }
        for (int j = size; j > 1; j--){
            swap(arr, 1, j);
            
            heapify(arr, 1, j-1);
        }
    }

    public static void heapify(Integer[] arr, int k, int n){
        while (2*k <= n){            
            int j = 2*k;            
            if (j < n && arr[j-1] < arr[j]){
                j++;
            }
            if (!(arr[k-1] < arr[j-1])){
                break;
            }
            swap(arr, k, j);            
            k = j;
        }
    }

    private static void swap(Integer[] arr, int k, int n){
        int temp = arr[n-1];
        arr[n-1] = arr[k-1];
        arr[k-1] = temp;
    }
}
