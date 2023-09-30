import java.util.ArrayList;
import java.util.LinkedList;


public class BinarySearch {


    public static class Pair<T> {
        public T a;
        public T b;
                
        public Pair(T a, T b){
            this.a=a;
            this.b=b;
        }

        public T getLeft(){
            return a;
        }
        
        public T getRight(){
            return b;
        }
        
        public String toString(){
            return a + " - " + b; 
        }
    }

    /*Målet med binærsøk er å stadig halvere søkefeltet helt til vi finner verdien vi leter etter.
    * 
    * Juster laveste index(lo) til midterste index+1 hvis verdi > arr[mid]
    * Juster høyeste index(hi) til midterste index-1 hvis verdi < arr[mid]
    */

    static Pair<Integer> search(ArrayList<Integer> arr, Integer index){

        int n = arr.size();
        int lo = 0, hi = n-1;
        
        Integer left = null;
        Integer right = null;

        while (lo <= hi){
            Integer mid = lo + (hi-lo)/2;
            if (index.compareTo(arr.get(mid)) < 0){
                hi = mid -1;
            }
            else if (index.compareTo(arr.get(mid)) > 0){
                lo = mid +1;
            }
            else {
                if (mid != 0){
                    left = arr.get(mid-1);
                    }
                if (mid != n-1){
                    right = arr.get(mid+1);
                    }
                return new Pair<Integer>(left, right);
            }
        }
        return new Pair<Integer>(left, right);
    }

    

    public Integer binarySearchIndex(ArrayList<Integer> arr, Integer number){
        int length = arr.size();
        int low = 0;
        int high = length-1;

        while (low <= high){
            int mid = low + (high-low)/2;

            if (number.compareTo(arr.get(mid)) < 0){
                high = mid-1;
            }
            else if (number.compareTo(arr.get(mid)) > 0){
                low = mid+1;
            }
            else {
                return mid;
            }
        }
        return null;
    }
}
