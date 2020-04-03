package eg.edu.alexu.csd.datastructure.stack.cs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class StackTest {
	
		Stack stack1= new Stack();
		StackTest(){
			stack1.push(1);
			stack1.push(2);
			stack1.push('a');
			stack1.push(26);
		}
		
		@Test
		void testPush() {
	         stack1.push(70);
	         assertEquals(70,stack1.peek());
	         assertEquals(5,stack1.size());
		}

	@Test
	void testPop() {
		 stack1.pop();
         assertEquals('a',stack1.peek());
         assertEquals(3,stack1.size());	
         
         Stack stack2= new Stack();
	assertThrows(EmptyStackException.class ,() -> stack2.pop());	
	}
	

	@Test
	void testSize() {
         stack1.push(70);
         assertEquals(5,stack1.size());
         stack1.pop();
         assertEquals(4,stack1.size());	
         Stack stack2= new Stack();
         assertEquals(0,stack2.size());	
	}
	
	@Test
	void testPeek() {
         stack1.push(70);
         assertEquals(70,stack1.peek());
         stack1.pop();
         assertEquals(26,stack1.peek());	
         Stack stack2= new Stack();
         stack2.push(5);
         assertEquals(5,stack2.pop());	
	}
	@Test
	void testEmpty() {
         assertEquals(false,stack1.isEmpty());	
         Stack stack2= new Stack();
         assertEquals(true,stack2.isEmpty());	
         stack2.push(5);
         assertEquals(false,stack2.isEmpty());	
	}
}
