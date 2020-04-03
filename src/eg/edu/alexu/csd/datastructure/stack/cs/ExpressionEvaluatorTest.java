package eg.edu.alexu.csd.datastructure.stack.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {
  static ExpressionEvaluator test=new ExpressionEvaluator();

	@Test
	void testPostfix() {
		String test1 ="-(4+8)*(6--5)/-(+(3-2)*(2+2))";
		String result=" 0 1 - 4 8 + * 6 0 5 - - * 0 1 - 3 2 - 2 2 + * * /";
		assertEquals(result,test.infixToPostfix(test1));
		
		String test2 ="-100++300--400*-(2*4)";
		String result2=" 0 100 - 0 300 + + 0 400 - 0 1 - 2 4 * * * -";
		assertEquals(result2,test.infixToPostfix(test2));
		
		String test3 ="(a / (b - c + d)) * (e - a) * c";
		String result3=" a b c - d + / e a - * c *";
		assertEquals(result3,test.infixToPostfix(test3));
		
		String test0 ="x+y/-(8+9*-(x+7)-1)";
		String result0="x y 0 1 - 8 9 0 1 - x 7 + * * + 1 - * / +";
		assertEquals(result0,test.infixToPostfix(test0));

		
		String test4 ="5+99)";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(test4));
		
		String test5 ="a+k*y/";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(test5));

		String test6 ="a++++k*y";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(test6));
	}

	@Test
	void testEvaluate() {
		String test7 ="-(4+8)*(6--5)/-(+(3-2)*(2+2))";
        int output1=33;
		assertEquals(output1,test.evaluate(test.infixToPostfix(test7)));

		String test8 ="-100++300--400*-(2*4)";
        int output2=-3000;
		assertEquals(output2,test.evaluate(test.infixToPostfix(test8)));
		
		String test9 ="6 2 / 3 - 4 2 * +";
        int output3=8;
		assertEquals(output3,test.evaluate(test9));
		
		String test10 ="1+-(2+-((8*1)+-(9+3))+9)";		
        int output4=-14;
		assertEquals(output4,test.evaluate(test.infixToPostfix(test10)));
		

		String test11 ="(1-3)/-(1--2+-(7+0))*6";
        int output5=-3;
		assertEquals(output5,test.evaluate(test.infixToPostfix(test11)));
		
		String test12 ="6 2 / **3 - 4 2 * +";
		assertThrows(RuntimeException.class,() -> test.evaluate(test12));
		
		
	}
	
	
}
