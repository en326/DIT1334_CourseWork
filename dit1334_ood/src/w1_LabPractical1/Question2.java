package w1_LabPractical1;
import java.util.Scanner;  // Import Scanner class for input

public class Question2 {
    public static void main(String[] args) {
        // Create Scanner object to take input from user
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.print("Enter a number: ");
        int number = input.nextInt(); // Store input in variable 'number'

        // Check if the number is even or odd
        if (number % 2 == 0) {
            // If divisible by 2, it's even
            System.out.println(number + " is Even.");
        } else {
            // Otherwise, it's odd
            System.out.println(number + " is Odd.");
        }
    }
}
