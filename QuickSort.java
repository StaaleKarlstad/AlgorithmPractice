public class QuickSort {

    
    /* Rekursiv algoritme - Divide and Conquer. 
     * 
     * Kjøretid: Average: O(nlog(n)), Worst case: O(n^2) 
     * 
     * Base case: Når nedre index >= øvre index
     * 
     * Sjekker først om base case er nådd
     * 
     * Bruker partition for å velge ut en pivot-index og flytter alle verdier < arr[pivot] 
     * på venstre side slik at pivot får riktig index i arrayet.
     * 
     * Pivot-indexen returneres og lagres i variabelen pivotIndex.
     * 
     * Separerer verdier arr[low] - arr[pivotIndex-1] og arr[pivotIndex+1] - arr[high] i hver sine rekursive kall
     * 
     * Rekursjonen deler subarrayene inn i mindre og mindre deler helt til base case er nådd.
     * Dette skjer når quickSort får inn et array der low >= high
     * 
     * 
       */

    public void sort(Integer[] array){
        int low = 0;
        int high = array.length-1;
        quickSort(array, low, high);
    }
    
    public void quickSort(Integer[] array, int low, int high){       
        if (low < high){          
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1); 
            quickSort(array, pivotIndex + 1, high); 
        }
    }

    private int partition(Integer[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++){ //Risikerer O(n^2) hvis det største eller minste tallet velges som pivot hver gang
            if (array[j] < pivot){
                i++;
                swap(array, i, j);
            }    
        }
        swap(array, i+1, high);
        return i+1;
    }

    private void swap(Integer[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}


