//Keagan Morrison 2022
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.management.monitor.GaugeMonitor;

public class NumberGuessGame {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> nums1 = new ArrayList<Integer>();
    int tries = 1;
    int tries2 = 1;
    int tries3 = 1;
    Random randNum = new Random();
    
    System.out.println("Set your boundries(Minimum)");
    if(sc.hasNextInt()==false) {
        while(sc.hasNextInt()==false){
            System.out.println("This is not an interger, please input one!");
            sc.next();
        }
    }
    int minInput = sc.nextInt();
   
    System.out.println("Set your boundries(Maximum)");
    if(sc.hasNextInt()==false) {
        while(sc.hasNextInt()==false){
            System.out.println("This is not an interger, please input one!");
            sc.next();
        }
    }
    int maxInput = sc.nextInt();
   
    System.out.println("Guess the number! You must guess within a range of " + minInput + " to " + maxInput + "!" );
    int product = randNum.nextInt(minInput,maxInput); 
    int product2 = randNum.nextInt(minInput,maxInput);
    int product3 = randNum.nextInt(minInput,maxInput);
// main function    
    Check(sc, product, product2, tries, tries2, tries3, product3,nums1, minInput, maxInput);
    }
    
    public static void Check(Scanner sc, int product, int product2, int tries, int tries2, int tries3, int product3,ArrayList<Integer> nums1, int minInput, int maxInput) {
       
        
    if(sc.hasNextInt()==false) {
        while(sc.hasNextInt()==false){
            System.out.println("This is not an interger, please input one!");
            sc.next();
        }
    }
    
        int input = sc.nextInt();
        
        if(nums1.contains(input)) {
            System.out.println("You've already guessed this number, try another one!");
            Check(sc, product, product2, tries, tries2, tries3, product3, nums1, minInput, maxInput );
         }
        
        if(input < minInput){
            System.out.println("This is less that the minimum!");
            Check(sc, product, product2, tries, tries2, tries3, product3, nums1, minInput, maxInput);
        }
        if(input > maxInput){
            System.out.println("This is over the maximum!");
            Check(sc, product, product2, tries, tries2, tries3, product3, nums1, minInput, maxInput);
        }
        if(input < product) {
                System.out.println("Go Higher!" + "(" + tries + ")");
                tries = tries + 1;
                nums1.add(input);
                Check(sc, product, product2, tries, tries2, tries3, product3, nums1, minInput, maxInput);
             }
        if(input > product) {
            System.out.println("Go Lower!"+ "(" + tries + ")");
            tries = tries + 1;
            nums1.add(input);
            Check(sc, product, product2, tries, tries2, tries3, product3,nums1, minInput, maxInput);
         }
         
        
         if(input == product) {
            System.out.println("You got the correct number!");
            System.out.println("You took " + tries + " guesses to get the number");
            System.exit(product);
        }
    }
}
