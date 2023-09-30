import java.util.ArrayList;

public class MergeSort {

    /*Rekursiv algoritme
     * 
     * Kjøretid: O(nlog(n))
     * 
     * Base case: Lengden på arrayet er 1 eller 0. Disse regnes som sorterte
     * 
     * Algoritmen bruker rekursjon for å halvere subarrays helt til base case er møtt
     * 
     * Når arrayet er brutt ned til subarrays av lengde 1 eller 0, vil merge-metoden sette dem sammen
     * i sortert rekkefølge
     */
    
    public void mergeSort(ArrayList<Integer> arr){
        int length = arr.size();      
        if (length < 2) return; 
        
        int mid = length / 2; 
        ArrayList<Integer> leftArr = new ArrayList<Integer>(mid);
        ArrayList<Integer> rightArr = new ArrayList<Integer>(length-mid);

        for (int i = 0; i < mid; i++){ 
            leftArr.set(i, arr.get(i));
        }       
        for (int i = mid; i < length; i++){ 
            rightArr.set(i-mid, arr.get(i));
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(arr, leftArr, rightArr);
    }

    private void merge(ArrayList<Integer> inputArr, ArrayList<Integer>leftArr, ArrayList<Integer>rightArr){
        int left = leftArr.size();
        int right = rightArr.size();
        int i = 0, j = 0, k = 0;
        
        while (i < left && j < right){
            if (leftArr.get(i) < rightArr.get(j)){
                inputArr.set(k, leftArr.get(i));
                i++;
                k++;
            }
            else{
                inputArr.set(k, rightArr.get(j));
                j++;
                k++;
            }
        }
        while (i < left){
            inputArr.set(k, leftArr.get(i));
            i++;
            k++;
        }        
        while (j < right){
            inputArr.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }
}
