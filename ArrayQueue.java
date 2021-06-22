package ds;

public class ArrayQueue {
int front, rear, size;
int capacity;
int array[];
public ArrayQueue(int capacity) {
	this.capacity=capacity;
	front=this.size = 0;
	rear=capacity-1;
	array=new int[this.capacity];
}
void enqueue(int entry) {
	if(isFull())
		return;
	this.rear= (this.rear+1)% this.capacity;
	this.array[this.rear] = entry;
	this.size++;
	System.out.println("Enqueued "+entry);
}
int dequeue(){
	if(isEmpty())
		return -1;
	int entry= this.array[this.front];
	this.front=(this.front+1)%this.capacity;
	this.size--;
	System.out.println("Dequeueing "+entry);
	return entry;
}
boolean isFull() {
	return (this.size==this.capacity);
}
boolean isEmpty() {
	return (this.size==0);
}

public static void main(String[] args) {
	ArrayQueue aq= new ArrayQueue(20);
	aq.enqueue(1);
	aq.enqueue(2);
	aq.enqueue(3);
	aq.enqueue(4);
	int entry=aq.dequeue();
	System.out.println("Got "+entry);
	
}
}
