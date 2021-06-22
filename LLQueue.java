package ds;
class QNode{
	int key;
	QNode next;
	
	public QNode(int key) {
		this.key=key;
		this.next=null;
	}
}
public class LLQueue {
QNode front, rear;

public LLQueue() {
	this.front = this.rear= null;
}

void enqueue(int key) {
	QNode temp=new QNode(key);
	if(this.rear==null) {
		this.front=this.rear=temp;
		System.out.println("Enqueued "+key);
		return;
	}
	System.out.println("Enqueued "+key);
	this.rear.next=temp;
	this.rear=temp;
}

void dequeue() {
	if(this.front==null) {
		return;
	}
	System.out.println("Dequeued "+this.front.key);
	this.front=this.front.next;
	
	if(this.front==null)
		this.rear=null;
	
	
}
public static void main(String args[]) {
	LLQueue lq= new LLQueue();
	lq.enqueue(1);
	lq.enqueue(2);
	lq.enqueue(3);
	lq.enqueue(4);
	lq.dequeue();
}
}
