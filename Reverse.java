

public class Reverse {
    public static <T> void reverse(Integer[] arr){
        
        
        int n = arr.length - 1;
        int mid = n/2;

        for (int i = 0; i <= mid; i ++){
            int temp = arr[i];
            arr[i] = arr[n-i];
            arr[n-i] = temp;
        }
    }
}
