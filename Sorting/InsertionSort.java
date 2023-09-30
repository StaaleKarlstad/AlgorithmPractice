public class InsertionSort {
    
    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++){
            for (int j = i; j > 0 && (arr[j] < arr [j-1]); j--){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
