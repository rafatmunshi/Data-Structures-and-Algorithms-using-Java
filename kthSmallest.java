package ds;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class kthSmallest {
public static void main(String[] args) {
	List<Integer> a=Arrays.asList(7,5,3,9,1);
	int k=3;
	findKthSmallest(a, k);
}

private static void findKthSmallest(List<Integer> a, int k) {
	PriorityQueue<Integer> pq= new PriorityQueue<Integer>(a); // min-heap
	while(--k>0) {
		pq.poll();
	}
	
	System.out.println("The kth smallest element is "+pq.peek()); 
}
}
