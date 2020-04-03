package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.EmptyStackException;
/**
 * 
 * class that implements the functions of the stack using nodes
 *
 */
public class Stack implements IStack {

	private Node top;
	private int size;
	public Stack() {
		this.top=null;
		this.size=0;
	}
	
	@Override
	public Object pop() {
		if(!isEmpty()) {
		Object temp=top.getData();
		top=top.getNext();
		size--;
		return temp;
	}
		
		throw new EmptyStackException();
	}

	@Override
	public Object peek() {
		if(top==null) {
			throw new EmptyStackException();
		}
		return top.getData();
	}

	@Override
	public void push(Object element) {
		Node newData= new Node(element, top);
		top=newData;
		size++;
		
	}

	@Override
	public boolean isEmpty() {
		return top==null;
	}

	@Override
	public int size() {
		return size;
	}
	/////////////////////////////////////////////////////////////
	public void show () {
		Node node = top;
		while( node != null ) {
			 System.out.printf("%d<-", node.getData());
			node = node.getNext();		   
		}
		System.out.println();
	}

	}
