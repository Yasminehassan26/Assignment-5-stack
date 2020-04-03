package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.EmptyStackException;
import java.util.Scanner;
/**
 * 
 * class that implements the userinterface Istack 
 *
 */
public class mainStack {
	 static Stack test = new Stack();
	 static Scanner sc = new Scanner(System.in);
		static char selectM;
		static boolean exit = false;
	public static void menu () {
		System.out.println("====================================================================");
		System.out.println("Please choose an action:");
		System.out.println("-----------------------");
		System.out.println("1- Push");
		System.out.println("2- Pop");
		System.out.println("3- Peek");
		System.out.println("4- Get size");
		System.out.println("5- Check if empty");
		System.out.println("6- Exit the menu");
		System.out.println("====================================================================");
	}	
	

	public static void main(String[] args) {

while ( !exit ) {
	menu();
    selectM = sc.next().charAt(0);
    switch ( selectM ) {
	case '1' :
		System.out.println("please enter your input:");
		String Secretword;
		 sc.nextLine();
		 Secretword = sc.nextLine();	
			test.push( Secretword);
	    break;
	case '2' :
		 try {
			 System.out.println(test.pop());
	            
	         } catch (EmptyStackException e) {
	        	 System.out.println("the stack is empty");

	         }
		break;
	case '3' :
		 try {
			 System.out.println( test.peek());
	         } catch (EmptyStackException e) {
	        	 System.out.println("the stack is empty");
	         }
		break;
	case '4' :
		int k =test.size();
		System.out.printf("the size is equal to %d :/n", k);
		break;
	case '5' :
		System.out.println(test.isEmpty());
		break;
	case '6' :
		exit = true;
		break;
	
	default :
		System.out.println(" invalid input");	
	}


}}
}