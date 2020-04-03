package eg.edu.alexu.csd.datastructure.stack.cs;
/**
 * 
 * the implementation of expression evaluator that contains 2 methods the first one converts the expression from infix form to
 * postfix form using extra differents functions that edit the expression till we reach the right form
 * and the second method evaluate the expression and return the value of it
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
/**
 * 
 * @param x where we check if the char is an operator or not
 * @return true if it is an operator and false if it is a digit or a a letter
 */
    public boolean checkOperator(char x){
        if(x=='+' || x=='-' || x=='/' ||x=='*' ||x=='('  || x==')'){
            return true;
        }
        return false;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 
     * @param x it checks if the operator is arithmetic one or not
     * @return true if condition verified
     */
    public boolean valid(char x){
        if(x=='+' || x=='-' || x=='/' ||x=='*' )
        {
            return true;
        }
        return false;
    }
   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /**
    * 
    * @param a is the operator that we check
    * @param b is the operator stored in the stack
    * @return 1 if the one stored is higher in precedence or 2 if the one that we check is lower
    * in precedence or 3 if the two of them have the same degree of precedence and 0 for any thing else
    * 
    */
    public int comparePrecedence(char a, char b){
        if ((a=='+' || a=='-') &&(b=='/' ||b=='*')){
            return 1;
        }
        else if((b=='+' || b=='-') &&(a=='/' ||a=='*')){
            return 2;
        }

        else if (((a=='+' || a=='-') &&(b=='+' || b=='-')) ||((b=='/' ||b=='*') &&(a=='/' ||a=='*'))){
            return 3;
        }
        return 0;

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /**
    * 
    * @param expression the string that we want to remove the spaces between all the digits
    * @return the expression without spaces
    */
    public String space(String expression){
        int size=expression.length();
        String words="" ;
        for (int i=0; i<size; i++){
            char digit = expression.charAt(i);
            if(digit!=' '){
                words+=digit;
            }
        }
        words+=' ';
        words+=' ';

        return words;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 
   * @param expression it take the expression and check if there any condition that can make it invalid as extra
   * operators or successive operators without meaning 
   * @return a modifies expression to be worked on in the postfix method
   */
    public String check(String expression){
        String NewExpression=space(expression);
        int size=NewExpression.length();
        String words="" ;
        int k=0; 
        while(NewExpression.charAt(k)!=' ') {
         char test = NewExpression.charAt(k);
        if(valid(test)==true && NewExpression.charAt(k+1)==' '){
            throw new RuntimeException("there are an operator at the end");
        }
        k++;
        }
        int i =0;
        while (i<size){
            char digit = NewExpression.charAt(i);
            if(Character.isLetterOrDigit(digit)){
                words+=digit;
                if(NewExpression.charAt(i+1)=='(') {
       			 throw new RuntimeException("there is a ( after a digit/letter without operator");
                }
            }
            else if(checkOperator(digit)==true){
            	if(words.length()==0) {
            		if(digit=='/'||digit=='*'||digit==')') {
            			 throw new RuntimeException("there is an extra operator at the begining");
            		}
            		else if(digit=='-'||digit=='+') {
            			if(Character.isLetterOrDigit(NewExpression.charAt(i+1))) {
            				if (digit=='+') {           					
            				}
            				else {
            				 char n=NewExpression.charAt(i+1);
            				 words+='(';
                             words+=' ';
                             words+='0';
                             words+=' ';
                             words+=digit;
                             words+=' ';
                             
                             while(checkOperator(n)==false){
                                 words+=n;
                                 i=i+1;
                                 n = NewExpression.charAt(i+1);
                             }
                           
                             words+=' ';
                             words+=')';
            			}	}
            			else if(NewExpression.charAt(i+1)=='(') {
            				 words+=' ';
            	                words+=digit;
            	                words+=' ';
            			}
            			else if (NewExpression.charAt(i+1)=='-'||NewExpression.charAt(i+1)=='+') {
            				if(digit=='+'&&NewExpression.charAt(i+1)=='+') {
            					i++;
            				}
            				else if(digit=='-'&&NewExpression.charAt(i+1)=='-') {
           				i++;
           				}
            				else {
            					 words+=' ';
             	                words+=digit;
             	                words+=' ';
            				}
           			}
            		}
            			else if(digit=='(') {
           				 words+=' ';
           	                words+=digit;
           	                words+=' ';
                       char n = NewExpression.charAt(i+1);
           	             if(checkOperator(NewExpression.charAt(i+1))){
           	            	 if ((n=='/'||n=='*'||n==')')&&((valid(digit)==true||digit=='('))){
                                 throw new RuntimeException("there is 2 successive operators");
                             }
                             else if(valid(n)==true &&valid(NewExpression.charAt(i+2))==true&&valid(digit)==true){
                                 throw new RuntimeException("there is 3 or more successives operators");
                             }
                             else if((n=='-'||n=='+')&&((valid(digit)==true||digit=='('))){
                                 char num=NewExpression.charAt(i+2);
                                 if(Character.isLetterOrDigit(num)){
                                  
                                 	words+='(';
                                     words+=' ';
                                     words+='0';
                                     words+=' ';
                                     words+=n;
                                     words+=' ';
                                     while(checkOperator(num)==false&&num!=' '){
                                     	 words+=num;
                                     	 i++;
                                     	 num=NewExpression.charAt(i+2);
                                     }
                                    
                                     words+=' ';
                                     words+=')';
                                     i=i+1;
                                   
                                 }
                                
                                 }
           	            	 
           	             }
           	                
           	                
           	                }
             	}
            	else {
            	
                words+=' ';
                words+=digit;
                words+=' ';
              

                if(i<size-1&&  checkOperator(NewExpression.charAt(i+1))){
                    char n=NewExpression.charAt(i+1);

                    if ((n=='/'||n=='*'||n==')')&&((valid(digit)==true||digit=='('))){
                        throw new RuntimeException("there is 2 successive operators");
                    }
                    else if(valid(n)==true &&valid(NewExpression.charAt(i+2))==true&&valid(digit)==true){
                        throw new RuntimeException("there is 3 or more successives operators");
                    }
                    else if ((n=='(')&&(digit==')')){
                        throw new RuntimeException("there is 2 successive operators");
                    }
                    else if((n=='-'||n=='+')&&((valid(digit)==true||digit=='('))){
                        char num=NewExpression.charAt(i+2);
                        if(Character.isLetterOrDigit(num)){
                         
                        	words+='(';
                            words+=' ';
                            words+='0';
                            words+=' ';
                            words+=n;
                            words+=' ';
                            while(checkOperator(num)==false&&num!=' '){
                            	 words+=num;
                            	 i++;
                            	 num=NewExpression.charAt(i+2);
                            }
                           
                            words+=' ';
                            words+=')';
                            i=i+1;
                          
                        }
                        else if(num=='('){
                            if(n=='+'){
                                i++;
                            }
                        }
                    }
                }
            }}
            i++;
        }
       
       String tr=minus(words);

        String pr =null;
        tr=space(tr);
        pr=tr;
        int counter=0;
      for(int f=0;f<tr.length();f++) {
        	if((tr.charAt(f)=='-'||tr.charAt(f)=='+')&&(valid(tr.charAt(f-1)))){
            pr=minus(pr);
            pr=space(pr);
            counter=1;

        	}
        }
      if(counter==0) {
    	  pr=tr;
      }
        return pr;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 
     * @param expression refer to the final string modified in the check method and this method have like target
     * to handle the minus as sign that exist before a parentheses
     * @return the final expression that enter to the postfix method
     */
    public String minus(String expression){
        String test = space(expression);
        
        String exp="";
        Stack stack=new Stack();
        int size=test.length();
        for (int i=0; i<size; i++){
            char digit = test.charAt(i);

            if(checkOperator(digit)==false){
                exp+=digit;
            }
            else if (checkOperator(digit)==true){
                if(digit=='-'||digit=='+'){
                    if(exp.length()==0 ||(test.charAt(i+1)=='('&&checkOperator(test.charAt(i-1)) &&test.charAt(i-1)!=')')){
                        if(digit=='+') {
                            i++;
                        }
                        else{
                            exp+=' ' ;
                            exp+='(';
                            exp+=' ';
                            exp+='(';
                            exp+=' ';
                            exp+='0';
                            exp+=' ';
                            exp+=digit;
                            exp+=' ';
                            exp+=1;
                            exp+=' ';
                            exp+=')';
                            exp+=' ';
                            exp+='*';
                            exp+=' ';
                            boolean p=true;
                            while(p){
                                char n=test.charAt(i+1);
                                i++;
                                if(n=='('){
                                    stack.push(n);
                                }
                                else if (n==')'){
                                    stack.pop();
                                }
                                if(stack.isEmpty()==true){
                                    exp+=')';
                                    exp+=' ';
                                    exp+=')';
                                    exp+=' ';
                                    p=false;
                                }
                                else{
                                    exp+=n;
                                    exp+=' ';
                                }

                            }
                        }
                    }
                    else{
                        exp+=' ';
                        exp+=digit;
                        exp+=' ';
                    }
                }
                else{
                    exp+=' ';
                    exp+=digit;
                    exp+=' ';
                }
            }
            
        }
        return exp;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    
    public String infixToPostfix(String expression){
        Stack stack=new Stack();
        String words="" ;
        String NewExpression=check(expression);
        int compare=0;
        int size=NewExpression.length();
        for (int i=0; i<size; i++){
            char digit = NewExpression.charAt(i);

            if(Character.isLetterOrDigit(digit)){
            	if(Character.isLetter(digit)) {
            		if((Character.isLetterOrDigit(NewExpression.charAt(i+1)))) {
                        throw new RuntimeException("there is 2 successives symbols");
            		}
            	}
            	else if(Character.isDigit(digit)) {
            		if((Character.isLetter(NewExpression.charAt(i+1)))) {
                        throw new RuntimeException("there is 2 successives symbols and number");

            	}
            	}
                words+=digit;
            }
            else if(checkOperator(digit)==true){
                if(stack.isEmpty()==true&&digit!=')'){
                    stack.push(digit);
                    words+=' ';
                }
                else if(digit=='('){
                    stack.push(digit);
                }
                else if(digit==')'){
                    while(!stack.isEmpty()&& (char)stack.peek()!='('){
                        words+=' ';
                        words+=stack.pop();
                    }
                    if (stack.isEmpty()){
                        throw new RuntimeException("there is an extra ( or )");
                    }
                    else{
                        stack.pop();
                    }
                }
                else{
                    words+=' ';
                    compare=comparePrecedence(digit,(char)stack.peek());
                    if(compare==1){
                        words+=(char) stack.pop();
                        words+=' ';

                        if((char)stack.peek()=='-'||(char)stack.peek()=='+'){
                            words+=(char) stack.pop();
                            words+=' ';
                            stack.push(digit);
                        }
                    }
                    else if(compare==2){
                        stack.push(digit);
                    }
                    else if(compare==3){
                        words+=(char) stack.pop();
                        words+=' ';
                        stack.push(digit);
                   }
                    else if(compare==0){
                        stack.push(digit);
                    }
                }
            }
        }
        while(!stack.isEmpty())      {
            words+=' ';
            words+=(char) stack.pop();
        }
        for(int k=0; k<words.length(); k++)      {
            char c = words.charAt(k);
            if(c=='('){
                throw new RuntimeException("there is an extra ( or )");
            }
        }
        return words;
    }
////////////////////////////////////////////////////////////////////////////////////////    
    @Override
    public int evaluate(String expression)
    {
        Stack stack=new Stack();
        String word="";
        int size= expression.length();
        for (int i=0; i<size; i++){
            char digit = expression.charAt(i);
            if(Character.isLetterOrDigit(digit)){
                while(digit!=' '){
                    word+=digit;
                    i++;
                    digit = expression.charAt(i);
                }
                stack.push(word);
                word="";
            }
            else if(valid(digit)==true){
                float number2=Float.parseFloat(stack.pop().toString());
                float number1=Float.parseFloat( stack.pop().toString());
                float result = 0;
                switch(digit){
                case '+':
                    result = number1+number2;
                    break;
                case '-':
                    result = number1-number2;
                    break;
                case '*':
                    result = number1*number2;
                    break;
                case '/':
                    if (number2==0)
                    {
                        throw new RuntimeException();
                    }
                    result = number1/number2;
                    break;
                default :
                    System.out.println(" invalid input");
                }
                stack.push(result);
            }
        }
        float k=Float.parseFloat( stack.pop().toString());
        int output=(int)k;
        return output;
    }


    
}
