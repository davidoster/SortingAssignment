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
public class BubbleSort implements Runnable {
    private Thread bsThread;
    private ArrayList<Tshirt> arr;
    private int typeOfSort; 
    private int order;
    private int divisor = 1;
    private String result;
    
    public BubbleSort(ArrayList<Tshirt> arr, int typeOfSort, int order) {
       this.arr = arr;
       this.typeOfSort = typeOfSort;
       this.order = order;
       bsThread = new Thread(this, "Bubble Sort thread");
       bsThread.start();
    }
    
    public void sort(ArrayList<Tshirt> arr, int typeOfSort, int order) 
    { 
        // typeofSort = 1, Size
        // typeofSort = 2, Color
        // typeofSort = 3, Fabric
        
        // order = 1, ASC
        // order = 2, DESC
        
        int n = arr.size(); 
        switch(typeOfSort) {
            case 1:
                for (int i = 0; i < n-1; i++) 
                    for (int j = 0; j < n-i-1; j++) 
                        if(order == 1) {
                            if(arr.get(j).getSize().ordinal() > arr.get(j+1).getSize().ordinal()) 
                            { 
                                // swap arr[j+1] and arr[i] 
                                Tshirt temp = arr.get(j);
                                arr.set(j, arr.get(j+1));
                                arr.set(j+1, temp);
                            }
                        } else {
                            if(arr.get(j).getSize().ordinal() < arr.get(j+1).getSize().ordinal()) 
                            { 
                                // swap arr[j+1] and arr[i] 
                                Tshirt temp = arr.get(j);
                                arr.set(j, arr.get(j+1));
                                arr.set(j+1, temp);
                            }
                        }
                break;
            case 2:
                for (int i = 0; i < n-1; i++) 
                    for (int j = 0; j < n-i-1; j++) 
                        if(order == 1) {
                            if(arr.get(j).getColor().ordinal() > arr.get(j+1).getColor().ordinal()) 
                            { 
                                // swap arr[j+1] and arr[i] 
                                Tshirt temp = arr.get(j);
                                arr.set(j, arr.get(j+1));
                                arr.set(j+1, temp);
                            }
                        } else {
                            if(arr.get(j).getColor().ordinal() < arr.get(j+1).getColor().ordinal()) 
                            { 
                                // swap arr[j+1] and arr[i] 
                                Tshirt temp = arr.get(j);
                                arr.set(j, arr.get(j+1));
                                arr.set(j+1, temp);
                            }
                        }
                break;
            case 3:
                for (int i = 0; i < n-1; i++) 
                    for (int j = 0; j < n-i-1; j++) 
                        if(order == 1) {
                            if(arr.get(j).getFabric().ordinal() > arr.get(j+1).getFabric().ordinal()) 
                            { 
                                // swap arr[j+1] and arr[i] 
                                Tshirt temp = arr.get(j);
                                arr.set(j, arr.get(j+1));
                                arr.set(j+1, temp);
                            }
                        } else {
                            if(arr.get(j).getFabric().ordinal() < arr.get(j+1).getFabric().ordinal()) 
                            { 
                                // swap arr[j+1] and arr[i] 
                                Tshirt temp = arr.get(j);
                                arr.set(j, arr.get(j+1));
                                arr.set(j+1, temp);
                            }
                        }
                break;
        }
//        return arr;
    } 

    public String getResult() {
        return(this.result);
    }
    
    @Override
    public void run() {
        long start_bs = System.currentTimeMillis();
        sort(arr, typeOfSort, order);
        long end_bs = System.currentTimeMillis();
        this.result = "Bubble Sort for " + arr.size() + " shirts took: " + ((end_bs - start_bs) / divisor);
        System.out.println(this.result);
    }
}
