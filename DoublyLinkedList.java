package ds;
class DoublyNode{
	int data;
	DoublyNode next;
	DoublyNode prev;
	
	public static DoublyNode newDoublyNode(int data) {
		DoublyNode n= new DoublyNode();
		n.data=data;
		n.next= null;
		n.prev= null;
		return n;
	}
}
public class DoublyLinkedList {
	public DoublyNode addDoublyNode(int data, DoublyNode head) {
		DoublyNode temp=head;
		DoublyNode n= DoublyNode.newDoublyNode(data);
		if(head==null) {
			return n;
		}
		
		while(head.next!=null) {
			head=head.next;
		}
		head.next=n;
		n.prev=head;
		return temp;
	}
	public void printList(DoublyNode head) {
		while(head!=null) {
			System.out.println(head.data);
			head=head.next;
		}
	}

	public DoublyNode addAtFront(DoublyNode DoublyNode, DoublyNode head) {
		if(head==null) {
			return DoublyNode;
		}
		DoublyNode.next =head;
		head.prev=DoublyNode;
		return DoublyNode;
	}

	public int size(DoublyNode head) {
		int size=0;
		while(head!=null) {
			size++;
			head=head.next;
		}
		return size;
	}

	public DoublyNode find(DoublyNode head, int data) {
		while(head!=null) {
			if(head.data==data) {
				return head;
			}
			head=head.next;
		}
		return null;
	}

	public DoublyNode insertDoublyNodeAtPosition(DoublyNode head, int data, int position) {
		DoublyNode temp=head;
		DoublyNode newDoublyNode=DoublyNode.newDoublyNode(data);
		if(size(head)<position)
			System.out.println("LinkedList is smaller than the position");
		for(int i=0; i<position-2 && head!=null; i++) {
			head=head.next;
		}
		newDoublyNode.next=head.next;
		head.next.prev=newDoublyNode;
		head.next=newDoublyNode;
		newDoublyNode.prev=head;
		return temp;
	}

	public DoublyNode deleteDoublyNode(DoublyNode head, int position) {
		DoublyNode temp=head;
		DoublyNode nextDoublyNode;
		if(head==null) {
			return head;
		}
		if(position==0) 
		{
			temp=head.next;
			temp.prev=null;
			return temp;
		}
		if(size(head)<position) {
			System.out.println("LinkedList is smaller than the position");
		return head;
		}
		for(int i=0; head!=null&&i<position-2;i++) {
			head=head.next;
		}
		nextDoublyNode=head.next.next;
		head.next.next.prev=head;
		head.next=nextDoublyNode;
		
		return temp;
		
	}

	public void printReverse(DoublyNode head) {
		while(head.next!=null)
			head=head.next;
		while(head!=null) {
			System.out.println(head.data);
			head=head.prev;
		}
		
	}
	public static void main(String args[]) {
		DoublyLinkedList ll= new DoublyLinkedList();
		DoublyNode head=null;
		head=ll.addDoublyNode(1, head);
		head=ll.addDoublyNode(2, head);
		head=ll.addDoublyNode(3, head);
		head=ll.addDoublyNode(4, head);
//		DoublyNode newDoublyNode=DoublyNode.newDoublyNode(6);
//		head = ll.addAtFront(newDoublyNode, head);
//		head=ll.deleteDoublyNode(head, 2);
//		ll.printList(head);
		ll.printReverse(head);
//		if(ll.find(head, 3)!=null) {
//			System.out.println("Data present in the linkedlist");
//		}
		
	}
}
