package ds;

import java.util.Collections;
import java.util.LinkedList;

public class Sorts {

	
	void bubbleSort(int arr[]) {
		int n= arr.length;
		boolean swapped=false;
		for(int i=0; i<n-1; i++) {
			swapped=false;
			for(int j=0; j<n-1-i; j++) {
				if(arr[j]>arr[j+1])
				{
					int temp= arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
					swapped=true;
				}
			}
			if(swapped==false)
				break;
		}
	}
    void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    void printArray(float arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    int partition(int arr[], int low, int high) {
    	int pivot= arr[high];
    	int i= low-1;
    	for(int j= low; j<high;j++) {
    		if(arr[j]<pivot) {
    			i++;
    			
    			int temp= arr[i];
    			arr[i]=arr[j];
    			arr[j]=temp;
    		}
    	}
    	int temp= arr[i+1];
    	arr[i+1]=arr[high];
    	arr[high]=temp;
    	
    	return i+1;
    }
    void quickSort(int arr[], int low, int high) {
    	if(low<high) {
    		int p= partition(arr, low, high);
    		quickSort(arr, low, p-1);
    		quickSort(arr, p+1, high);
    	}
    }
    void mergeSort(int arr[], int l, int r) {
    	if(l<r) {
    		int m=(l+r)/2;
    		mergeSort(arr, l, m);
    		mergeSort(arr, m+1, r);
    		
    		merge(arr, l, m, r);
    	}
    }
    
    void merge(int arr[], int l, int m, int r) {
    	int s1= m-l+1;
    	int s2= r-m;
    	int L[]= new int[s1];
    	int R[]= new int[s2];
    	
    	for(int i=0; i<s1;i++)
    		L[i]=arr[l+i];
    	for(int j=0; j<s2; j++)
    		R[j]=arr[m+1+j];
    	int k=l;
    	int i=0, j=0;
    	while(i<s1 && j<s2) {
    		if(L[i]<=R[j]) {
    			arr[k]=L[i];
    			i++;
    		}
    		else {
    			arr[k]=R[j];
    			j++;
    		}
    		k++;
    	}
    	while(i<s1) {
    		arr[k]=L[i];
    		i++;
    		k++;
    	}
    	while(j<s2) {
    		arr[k]=R[j];
    		j++;
    		k++;
    	}
    		
    }

void heapSort(int arr[], int n) {
	for(int i=n/2-1; i>=0; i--)
		heapify(arr, n, i);
	
	for(int i=n-1; i>0; i--) {
		int temp=arr[0];
		arr[0]=arr[i];
		arr[i]=temp;
		
		heapify(arr, i, 0);
	}
}

    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2; 
 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 

        if (r < n && arr[r] > arr[largest]) 
            largest = r; 

        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
 
            heapify(arr, n, largest); 
        } 
    } 
  
    void countSort(int[] arr, int k) {
    	int counter[]= new int[k+1];
    	for(int i:arr) {
    		counter[i]++;
    	}
    	int j=0;
    	for(int i=0; i<counter.length;i++) {
    		while(counter[i]>0) {
    		arr[j++]=i;
    		counter[i]--;
    		}
    	}
    }
    // 0.134 0.597 0.4 0.74 0.82 0.06 Range-0.0 to 1.0
    void bucketSort(float arr[], int k) {
    	if(k<=0)
    		return;
    	
    	LinkedList<Float> buckets[] = new LinkedList[k];
    	for(int i=0; i<k; i++) {
    		buckets[i]= new LinkedList<Float>();
    	}
    	for(int i=0; i<arr.length; i++) {
    		float index=arr[i]*k;
    		buckets[(int)index].add(arr[i]);
    	}
    	for(int i=0; i<k; i++) {
    		Collections.sort(buckets[i]);
    	}
    	int index=0;
    	for(int i=0;i<k; i++) {
    		for(int j=0; j<buckets[i].size(); j++) {
    			arr[index++]=buckets[i].get(j);
    		}
    	}
    }
    public static void main(String args[]) 
    { 
    	Sorts obj= new Sorts();
        int arr[] = {6, 3, 2, 1, 2, 0, 9}; 
        float farr[] = {(float)0.134, (float)0.597, (float)0.4, (float)0.74, (float)0.82, (float)0.06}; 
        obj.bucketSort(farr, 10); 
        System.out.println("Sorted array"); 
        obj.printArray(farr); 
        
    } 
}
