package Class_activities1;
import java.util.Scanner;

public class Tutorial1_rosmahClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		final double TAX = 0.1;
		
		//variables declaration
		double hour, rate, grossPay, taxAmt, netPay;
		
		//input - hoursworked , private
		System.out.println("Enter hours worked: ");
		hour = input.nextDouble();
		
		System.out.println("Enter hourly rate of paid:Rm ");
		rate = input.nextDouble();
		
		// calculate grossPay , tax , netPay
		grossPay = hour * rate;
		taxAmt = grossPay * TAX;
		netPay = grossPay - taxAmt;
		
		//display the output
		System.out.println("\n The hours entered is: " + hour);
		System.out.println("\n The hourly of paid:Rm " + rate);
		System.out.println("\n Grosspay :Rm " + grossPay);
		System.out.println("\n Tax Amout 10% :Rm " + taxAmt);
		System.out.println("\n Netpay:Rm " + netPay);
	}	
}
