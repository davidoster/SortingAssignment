/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingassignment.sortingservices;

import java.util.ArrayList;
import sortingassignment.models.Tshirt;

/**
 *
 * @author mac
 */
public class QuickSort implements Runnable {
    private Thread qsThread;
    private ArrayList<Tshirt> arr;
    private int low;
    private int high;
    private int typeOfSort;
    private int order;
    private int divisor = 1;
    private String result;
    
    public QuickSort(ArrayList<Tshirt> arr, int low, int high, int typeOfSort, int order) {
       this.arr = arr;
       this.low = low;
       this.high = high;
       this.typeOfSort = typeOfSort;
       this.order = order;
       qsThread = new Thread(this, "Quick Sort thread");
       qsThread.start();
    }
    
    public String getResult() {
        return(this.result);
    }
        
    public void sort(ArrayList<Tshirt> arr, int low, int high, int typeOfSort, int order) 
    { 
        // typeofSort = 1, Size
        // typeofSort = 2, Color
        // typeofSort = 3, Fabric
        
        // order = 1, ASC
        // order = 2, DESC
        
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, typeOfSort, order); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1, typeOfSort, order); 
            sort(arr, pi+1, high, typeOfSort, order); 
        } 
    } 
    
    int partition(ArrayList<Tshirt> arr, int low, int high, int typeOfSort, int order) 
    { 
        int i = 0;
        Tshirt pivot = arr.get(high);  
        switch(typeOfSort) {
            case 1:
                int p = pivot.getSize().ordinal();
                i = (low-1); // index of smaller element 
                for (int j=low; j<high; j++) 
                { 
                    // If current element is smaller than the pivot 
                    if(order == 1) {
                        if (arr.get(j).getSize().ordinal() < p) 
                        { 
                            i++; 

                            // swap arr[i] and arr[j] 
                            Tshirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getSize().ordinal() > p) 
                        { 
                            i++; 

                            // swap arr[i] and arr[j] 
                            Tshirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                     
                }
                // swap arr[i+1] and arr[high] (or pivot) 
                Tshirt temp = arr.get(i+1);
                arr.set(i+1, arr.get(high));
                arr.set(high, temp);

                break;
            case 2:
                p = pivot.getColor().ordinal();
                i = (low-1); // index of smaller element 
                for (int j=low; j<high; j++) 
                { 
                    // If current element is smaller than the pivot 
                    if (arr.get(j).getColor().ordinal() < p) 
                    { 
                        i++; 

                        // swap arr[i] and arr[j] 
                        temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    } 
                }
                // swap arr[i+1] and arr[high] (or pivot) 
                temp = arr.get(i+1);
                arr.set(i+1, arr.get(high));
                arr.set(high, temp);
                break;
            case 3:
                   p = pivot.getFabric().ordinal();
                i = (low-1); // index of smaller element 
                for (int j=low; j<high; j++) 
                { 
                    // If current element is smaller than the pivot 
                    if (arr.get(j).getFabric().ordinal() < p) 
                    { 
                        i++; 

                        // swap arr[i] and arr[j] 
                        temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    } 
                }
                // swap arr[i+1] and arr[high] (or pivot) 
                temp = arr.get(i+1);
                arr.set(i+1, arr.get(high));
                arr.set(high, temp);
                break;
        }
        return i+1; 
    } 

    @Override
    public void run() {
        long start_qs = System.currentTimeMillis();
        sort(arr, low, high, typeOfSort, order);
        long end_qs = System.currentTimeMillis();
        this.result = "Quick Sort for " + arr.size() + " shirts took: " + ((end_qs - start_qs) / divisor);
        System.out.println(this.result);
    }
}
