package ds;

public class Search {
	static int count=0;
	int linearSearch(int arr[], int key) {
		for(int i=0; i< arr.length-1; i++) {
			if(arr[i]==key) {
				return i;
			}
			System.out.println("Step "+i);
		}
		return -1;
			
	}
	int binarySearch(int arr[], int l, int r, int key) {
		count++;
		System.out.println("Step "+count);
		if(r>=l) {
			
			int mid=l+(r-l)/2;
			if(arr[mid]==key)
				return mid;
			if(arr[mid]>key)
				return binarySearch(arr, l, mid-1, key);
			return binarySearch(arr, mid+1, r, key);
		}
		return -1;
	}
	public static void main(String args[]) 
    { 
        Search obj = new Search(); 
        int arr[] = { 2, 3, 8, 4, 14, 10, 24, 74, 28, 48, 57, 92, 0, 40 }; 
        //int item= obj.linearSearch(arr, 57);
        int item = obj.binarySearch(arr, 0,  arr.length - 1, 57); 
        if (item == -1) 
            System.out.println("item not present"); 
        else
            System.out.println("item found at index " + item); 
    } 
}
