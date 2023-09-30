import java.util.ArrayList;
import java.util.Arrays;





public class MainClass{
    public static void main(String[] args) {
        Integer [] arr = {7, 2, 1, 6, 8, 5, 3, 4, 12, 2, 45, 1, 0, 46, 32, 3, 4, 90};
        
        BinarySearch binSearch = new BinarySearch();     
        QuickSort quickSort = new QuickSort();
        long currentTimeMillis = System.currentTimeMillis();
        quickSort.sort(arr);
        long currentTimeMillis2 = System.currentTimeMillis();

        ArrayList<Integer> arrMod = new ArrayList<>();

        for (int i = 0; i < arr.length-1; i++){
            arrMod.add(arr[i]);
        }



        System.out.println(currentTimeMillis);
        System.out.println(currentTimeMillis2);
    }
}