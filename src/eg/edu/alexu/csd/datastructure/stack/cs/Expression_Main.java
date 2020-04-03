package eg.edu.alexu.csd.datastructure.stack.cs;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * implements the user interface IExpressionEvaluator that test that class
 *
 */
public class Expression_Main { 
static Scanner sc = new Scanner(System.in);
static char selectM;
static boolean exit = false;
static ExpressionEvaluator test=new ExpressionEvaluator();

/**
 * 
 * @param expression is the postfix expression that will be evaluated so we check if there are any symbols need to be
 * replaced by values
 * @return the final expression that with be evaluated 
 */
public static String stringEvaluation(String expression) {
	int i=0;
	boolean done =false;
	Scanner sc = new Scanner(System.in);
	while(i<expression.length()) {
		char check=expression.charAt(i);
		if( Character.isAlphabetic(check)) {
			while (!done)
			{
			    try
			    {
			System.out.printf("Enter the value of %c: \n" , check);
			
			String x=sc.next();
			Float.parseFloat(x);
			float y= Float.parseFloat(x);

			if(y>=0) {
				expression=expression.replace(Character.toString(check),x);
			}
			else if(y<0) {
				String t="";
				 t+='0';
				 t+=' ';
				 y=(-1*y);
				 t+=Float.toString(y);
				 t+=' ';
				 t+='-';
		
			expression=expression.replace(Character.toString(check),t);
			}
			done=true;
			}
			    catch (RuntimeException e )
			    {
			        System.out.println("That’s not a valid input. Try again: ");
			    } }
			done=false;
			
		}
		i++;
	}
	return expression;
}

public static void menu () {
	System.out.println("====================================================================");
	System.out.println("Please choose an action:");
	System.out.println("-----------------------");
	System.out.println("1- transform from the infix form the the postfix");
	System.out.println("2- evaluate the postfix expression");
	System.out.println("3- Exit the menu");
	System.out.println("====================================================================");
}	
	/**
	 * it is a main that i prepared and handled the possible cases and that is ready to be used by the user 
	 * @param args
	 */
public static void main(String[] args) {
	 int count=0;
	 String postfix = null;
	while ( !exit ) {
		menu();
	    selectM = sc.next().charAt(0);
	    switch ( selectM ) {
		case '1' :
			 try {
		        System.out.printf("Enter your infix expression:\n");
		        sc.nextLine();
				String  expression = sc.nextLine();
				 postfix =test.infixToPostfix(expression);
		        System.out.printf("the postfix expression:  %s\n" ,postfix);
		        count=1;
		     }  catch( RuntimeException e){
	         System.out.println(e.getMessage());

	         }
		    break;
		case '2' :
			 try {
				 if(count==0) {
			      	   System.out.println("you didnt enter any expression to evaluate");
 
				 }
				 else {
					 postfix=stringEvaluation(postfix);
					 System.out.println(postfix);
						int result =test.evaluate(postfix);
				      System.out.printf("the result is :  %d\n",result);

				 }
		            
			         }  catch( RuntimeException e){
		      	   System.out.println(e.getMessage());

		         }
			break;
	
		case '3' :
			exit = true;
			break;
		
		default :
			System.out.println(" invalid input");	
		}
		
	
	}}}
	

