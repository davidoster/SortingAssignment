/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingassignment.sortingservices;

import java.util.ArrayList;
import java.util.List;
import sortingassignment.models.Tshirt;

/**
 *
 * @author mac
 */
public class BucketSort {
    public ArrayList<Tshirt> sort(ArrayList<Tshirt> array, int typeOfSort, int order)  
    {    
        // typeofSort = 1, Size
        // typeofSort = 2, Color
        // typeofSort = 3, Fabric
        
        // order = 1, ASC
        // order = 2, DESC
        
        // XS = 0, S = 1, M = 2, L = 3, XL = 4, XXL = 5 , XXXL = 6
        int aSize = array.size();
        int buckets[] = new int[aSize+1];
        int current = -1;
        for (int i = 0; i < aSize; i++) {
            buckets[i] = 0;
        }
        
        for (int i = 0; i < aSize; i++) {
            // L, array.get(0).getSize().ordinal(), <----- 3
            // L  array.get(1).getSize().ordinal(), <----- 3
            // L  array.get(2).getSize().ordinal() <----- 3
            // M  array.get(3).getSize().ordinal() <----- 2
            // L  array.get(4).getSize().ordinal() <----- 3
            switch(typeOfSort) {
                case 1:
                    current = array.get(i).getSize().ordinal();
                    break;
                case 2:
                    current = array.get(i).getColor().ordinal();
                    break;
                case 3:
                    current = array.get(i).getFabric().ordinal();
                    break;
            }
            
            // i = 0, 3
            // i = 1, 3
            // i = 2, 3
            // i = 3, 2
            // i = 4, 3
            buckets[current]++;
        }
        ArrayList<Tshirt> sortedTShirts = new ArrayList<>();
        if(order == 1) {
            for(int j = 0; j < buckets.length; j++) {
                if(buckets[j] > 0) {
                    for(int i = 0; i < aSize; i++) {
                        switch(typeOfSort) {
                            case 1:
                                if(array.get(i).getSize().ordinal() == j)
                                    sortedTShirts.add(array.get(i));
                                break;
                            case 2:
                                if(array.get(i).getColor().ordinal() == j)
                                    sortedTShirts.add(array.get(i));
                                break;
                            case 3:
                                if(array.get(i).getFabric().ordinal() == j)
                                    sortedTShirts.add(array.get(i));
                                break;
                        }
                    }
                }
            }
        } else {
            for(int j = buckets.length - 1; j >= 0; j--) {
                if(buckets[j] > 0) {
                    for(int i = 0; i < aSize; i++) {
                        switch(typeOfSort) {
                            case 1:
                                if(array.get(i).getSize().ordinal() == j)
                                    sortedTShirts.add(array.get(i));
                                break;
                            case 2:
                                if(array.get(i).getColor().ordinal() == j)
                                    sortedTShirts.add(array.get(i));
                                break;
                            case 3:
                                if(array.get(i).getFabric().ordinal() == j)
                                    sortedTShirts.add(array.get(i));
                                break;
                        }
                    }
                }
            }
        }
        
        return sortedTShirts;
    }
}
