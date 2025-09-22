package w1_LabPractical1; //Packages name
import java.util.Scanner; //Import the scanner class

public class Question1 {
    public static void main(String[] args) { //The main method
        Scanner input = new Scanner(System.in); //Creates a scanner

        System.out.print("Enter first number: "); //Print the message
        int num1 = input.nextInt(); // reads an integer

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        int sum = num1 + num2; // Adds two numbers
        System.out.println("The sum is: " + sum); // Print the result
    }
}

