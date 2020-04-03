package eg.edu.alexu.csd.datastructure.stack.cs;
/**
 * 
 * Node class used in the implementation of stack
 *
 */
public class Node {
		private Object data;
	    private Node next;
	    
	    public Node (){
	    	this(null,null);
	    }
	    public Node(Object object, Node n) {
			data=object;
			next=n;
		}
		public Object getData() {
	    	return this.data;
	    }
	    
	    public void setData(Object element) {
	    	this.data =element ;
	    }
	    
	    public Node getNext() {
	    	return this.next;
	    }
	    
	    public void setNext(Node next) {
	    	this.next = next;
	    }    
	    
	}	
	

