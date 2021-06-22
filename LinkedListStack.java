package ds;

public class LinkedListStack {
	private class ListNode{
		int data;
		ListNode link;
	}
int length;
ListNode top;
public LinkedListStack() {
	length=0;
	top=null;
}
public void push(int x) {
	ListNode temp=new ListNode();
	temp.data=x;
	temp.link=top;
	top=temp;
	System.out.println("Added "+x);
}
public int pop() {
	if(top==null) {
		System.out.println("Stack Underflow");
		return -1;
	}
	else {
	int temp=top.data;
	top=top.link;
	System.out.println("Popping out " + temp);
	return temp;
	}
}
public boolean isEmpty() {
	return top==null;
}
public int peek() {
	if(isEmpty()) {
		System.out.println("Stack is Empty");
	return -1;
	}
	else {
		System.out.println("Peeking "+top.data);
		return top.data;
	}
}
public static void main(String []args) {
	LinkedListStack stack= new LinkedListStack();
	for(int i=1;i<12;i++) {
		try {
			stack.push(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	for(int i =1; i<4; i++) {
		try {
			stack.peek();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
