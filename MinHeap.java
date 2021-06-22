package ds;

public class MinHeap {
int[] Heap;
int size;
int maxsize;
public MinHeap(int maxsize)
{
	this.maxsize=maxsize;
	this.size=0;
	Heap= new int[maxsize+1];
	Heap[0]=Integer.MIN_VALUE;
}

public void buildHeap() {
	for(int pos=(size/2); pos>=1; pos--) {
		heapify(pos);
	}
}
void heapify(int pos) {
	if(!isLeaf(pos)) {
		if(Heap[pos]>Heap[leftChild(pos)]) {
			swap(pos, leftChild(pos));
			heapify(leftChild(pos));
		}
		if(Heap[pos]>Heap[rightChild(pos)]) {
			swap(pos, rightChild(pos));
			heapify(rightChild(pos));
		}
	}
}
int leftChild(int pos) {
	return (2*pos);
}
int rightChild(int pos) {
	return (2*pos+1);
}
boolean isLeaf(int pos) {
	if(pos>=(size/2)&& pos<=size)
		return true;
	return false;
}
void swap(int pos1, int pos2) {
	int temp;
	temp=Heap[pos1];
	Heap[pos1]=Heap[pos2];
	Heap[pos2]=temp;
}
void insert(int entry) {
	if(size>=maxsize) {
		return;
	}
	Heap[++size]=entry;
	int current=size;
	while(Heap[current]<Heap[parent(current)]) {
		swap(current, parent(current));
		current= parent(current);
	}
}
int parent(int pos) {
	return pos/2;
}
int removeMin() {
	int min=Heap[1];
	Heap[1]=Heap[size--];
	heapify(1);
	return min;
}
void print() {
	for(int i=1;i<=size/2; i++) {
		System.out.print(Heap[i]+" "+Heap[2*i]+" ");
		if(2*i+1<=size)
		System.out.print(Heap[2*i+1]);
		System.out.println(" ");
	}
}

public static void main(String args[]) {
	System.out.println();
	MinHeap minHeap= new MinHeap(15);
	minHeap.insert(7);
	minHeap.insert(2);
	minHeap.insert(9);
	minHeap.insert(5);
	minHeap.insert(12);
	minHeap.insert(19);
	minHeap.insert(4);
	minHeap.buildHeap();
	
	minHeap.print();
	System.out.println(minHeap.removeMin());
	minHeap.print();
}
}
