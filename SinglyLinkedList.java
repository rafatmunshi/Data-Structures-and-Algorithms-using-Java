package ds;
class SNode{
	int data;
	SNode next;
	
	public static SNode newNode(int data) {
		SNode n= new SNode();
		n.data=data;
		n.next= null;
		return n;
	}
}
public class SinglyLinkedList {
public SNode addNode(int data, SNode head) {
	SNode temp=head;
	SNode n= SNode.newNode(data);
	if(head==null) {
		return n;
	}
	
	while(head.next!=null) {
		head=head.next;
	}
	head.next=n;
	return temp;
}
public void printList(SNode head) {
	while(head!=null) {
		System.out.println(head.data);
		head=head.next;
	}
}

public SNode addAtFront(SNode node, SNode head) {
	if(head==null) {
		return node;
	}
	node.next =head;
	return node;
}

public int size(SNode head) {
	int size=0;
	while(head!=null) {
		size++;
		head=head.next;
	}
	return size;
}

public SNode find(SNode head, int data) {
	while(head!=null) {
		if(head.data==data) {
			return head;
		}
		head=head.next;
	}
	return null;
}

public SNode insertNodeAtPosition(SNode head, int data, int position) {
	SNode temp=head;
	SNode newNode=SNode.newNode(data);
	if(size(head)<position)
		System.out.println("LinkedList is smaller than the position");
	for(int i=0; i<position-2 && head!=null; i++) {
		head=head.next;
	}
	newNode.next=head.next;
	head.next=newNode;
	return temp;
}

public SNode deleteNode(SNode head, int position) {
	SNode temp=head;
	SNode nextNode;
	if(head==null) {
		return head;
	}
	if(position==0) 
	{
		temp=head.next;
		return temp;
	}
	if(size(head)<position) {
		System.out.println("LinkedList is smaller than the position");
	return head;
	}
	for(int i=0; head!=null&&i<position-2;i++) {
		head=head.next;
	}
	nextNode=head.next.next;
	head.next=nextNode;
	
	return temp;
	
}

public static void main(String args[]) {
	SinglyLinkedList ll= new SinglyLinkedList();
	SNode head=null;
	head=ll.addNode(1, head);
	head=ll.addNode(2, head);
	head=ll.addNode(3, head);
	head=ll.addNode(4, head);
	SNode newNode=SNode.newNode(6);
	head = ll.addAtFront(newNode, head);
	head=ll.deleteNode(head, 2);
	ll.printList(head);
//	if(ll.find(head, 3)!=null) {
//		System.out.println("Data present in the linkedlist");
//	}
	
}
}
