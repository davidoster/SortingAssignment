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
     
        QuickSort qs = new QuickSort(mytshirts, 0, mytshirts.size()-1, 1, 1);

        BubbleSort bs = new BubbleSort(mytshirts2, 1, 1);
//
        BucketSort bus = new BucketSort(mytshirts3, 1, 1);
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
