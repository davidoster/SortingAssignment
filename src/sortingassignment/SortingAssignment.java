/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingassignment;

import java.util.ArrayList;
import java.util.List;
import sortingassignment.models.Tshirt;
import sortingassignment.sortingservices.BubbleSort;
import sortingassignment.sortingservices.BucketSort;
import sortingassignment.sortingservices.QuickSort;

/**
 *
 * @author mac
 */
public class SortingAssignment {
    List<Tshirt> tshirts;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int noOfShirts = 100000;
        int divisor = 1;
        ArrayList<Tshirt> orig_mytshirts = generateTShirts(noOfShirts);
        ArrayList<Tshirt> mytshirts = new ArrayList<>(orig_mytshirts);
        ArrayList<Tshirt> mytshirts2 = new ArrayList<>(orig_mytshirts);
        ArrayList<Tshirt> mytshirts3 = new ArrayList<>(orig_mytshirts);
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        BucketSort bus = new BucketSort();
        
//        showTShirts(mytshirts);

        // Quick Sort
        long start_qs = System.currentTimeMillis();
        qs.sort(mytshirts, 0, mytshirts.size()-1, 1, 1);
        long end_qs = System.currentTimeMillis();
        System.out.println("Quick Sort for " + noOfShirts + " shirts took: " + ((end_qs - start_qs) / divisor));
        
        // Bubble Sort
        long start_bs = System.currentTimeMillis();
        bs.sort(mytshirts2, 1, 1);
        long end_bs = System.currentTimeMillis();
        System.out.println("Bubble Sort for " + noOfShirts + " shirts took: " + ((end_bs - start_bs) / divisor));

        // Bucket Sort
        long start_bus = System.currentTimeMillis();
        mytshirts = bus.sort(mytshirts3, 1, 1);
        long end_bus = System.currentTimeMillis();
        System.out.println("Bucket Sort for " + noOfShirts + " shirts took: " + ((end_bus - start_bus) / divisor));
//        showTShirts(mytshirts);
        
    }
    
    public static ArrayList<Tshirt> generateTShirts(int quantity) {
        ArrayList<Tshirt> tshirts = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            tshirts.add(new Tshirt());
        }
        return tshirts;
    }
    
    public static void showTShirts(ArrayList<Tshirt> mytshirts) {
        System.out.println("****Printing items of the List****");
        for (Tshirt shirt : mytshirts) {
            System.out.println(
                    "Name: " + shirt.getName() + 
                    " Size: " + shirt.getSize() +
                    " Color: " + shirt.getColor() +
                    " Fabric: " + shirt.getFabric());
        }
    }
}
