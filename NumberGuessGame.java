
//Keagan Morrison 2022
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> nums1 = new ArrayList<Integer>();
    
    int tries = 1;
    Random randNum = new Random();
    int minInput = 0;
    int maxInput=0;
    int nummyNum = 0;
    Game gamez = new Game(nummyNum, maxInput);

    System.out.println("Select your difficulty");
    System.out.println("1: Easy (0-10)");
    System.out.println("2: Medium(0-50)");
    System.out.println("3: Hard(0-100)");   
    
    Choosey(tries, sc, maxInput, minInput, randNum, tries, nums1, gamez, nummyNum);

// main function
   
    }
    public static void Check(Scanner sc, int product,  int tries ,ArrayList<Integer> nums1, int minInput, int maxInput, int choice, Game gamez, int nummyNum, Random randNum) {
     
    if(sc.hasNextInt()==false) {
        while(sc.hasNextInt()==false){
            System.out.println("This is not an interger, please input one!");
            sc.next();
        }
    }
    nums1 = new ArrayList<Integer>();
    
        int input = sc.nextInt();
        
        if(nums1.contains(input)) {
            System.out.println("You've already guessed this number, try another one!");
            Check(sc, product, tries, nums1, minInput, maxInput, choice, gamez, nummyNum, randNum );
         }
        
        if(input < minInput){
            System.out.println("This is less that the minimum!");
            Check(sc, product, tries,  nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
        }
        if(input > maxInput){
            System.out.println("This is over the maximum!");
            Check(sc, product,  tries,  nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
        }
        if(input < product) {
                System.out.println("Go Higher!" + "(" + tries + ")");
                tries = tries + 1;
                nums1.add(input);
                Check(sc, product,  tries,  nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
             }
        if(input > product) {
            System.out.println("Go Lower!"+ "(" + tries + ")");
            tries = tries + 1;
            nums1.add(input);
            Check(sc, product, tries, nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
         }
    
         if(input == product) {
            System.out.println("You got the correct number!");
            System.out.println("On level " +  gamez.Level  + " it took you " + tries + " guesses to get the number");
            System.out.println("Would you like to play again 1(yes) or 2(no)");
            
            int monkeysauce = sc.nextInt();
            if(monkeysauce == 1) {
                System.out.println("Select your difficulty");
                System.out.println("1: Easy (0-10)");
                System.out.println("2: Medium(0-50)");
                System.out.println("3: Hard(0-100)"); 
                    Choosey(choice, sc, maxInput, minInput, randNum, tries, nums1, gamez, nummyNum);
            }
            if(monkeysauce == 2) {
                    System.exit(product);
            }
        }
    }

public static void Choosey(int choice, Scanner sc, int maxInput, int minInput, Random randNum, int tries, ArrayList<Integer> nums1, Game gamez, int nummyNum){

   
    if(sc.hasNextInt()==false) {
        while(sc.hasNextInt()==false){
            System.out.println("This is not an interger, please input one!");
            sc.next();
                }
            }
     choice = sc.nextInt();
maxInput = 0;  
if(choice == 1) {
    maxInput += 10;
    nummyNum += choice;
    gamez = new Game(choice, tries);
    System.out.println("Guess the number! You must guess within a range of " + minInput + " to " + maxInput + "!" );
    int product = randNum.nextInt(minInput,maxInput); 
    Check(sc, product,  tries, nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
}
if(choice == 2) {
     maxInput += 50; 
     nummyNum += choice;
     gamez = new Game(choice, tries);
    System.out.println("Guess the number! You must guess within a range of " + minInput + " to " + maxInput + "!" );
    int product = randNum.nextInt(minInput,maxInput); 
    Check(sc, product,  tries, nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
}
if(choice == 3) {
     maxInput += 100;
     nummyNum += choice;
     gamez = new Game(choice, tries);
    System.out.println("Guess the number! You must guess within a range of " + minInput + " to " + maxInput + "!" );
    int product = randNum.nextInt(minInput,maxInput); 
    Check(sc, product,  tries, nums1, minInput, maxInput, choice, gamez,nummyNum, randNum);
        }
if(choice>3){
    System.out.println("This is not an choice, please input one!");
    Choosey(choice, sc, maxInput, minInput, randNum, tries, nums1, gamez, nummyNum);;
}
if(choice<1){
    System.out.println("This is not a valid choice, please input one!");
    Choosey(choice, sc, maxInput, minInput, randNum, tries, nums1, gamez, nummyNum);;
}
    }   
}
