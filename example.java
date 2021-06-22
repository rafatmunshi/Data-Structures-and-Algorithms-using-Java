package ds;

public class example {
	    int subArraySum(int a[], int s)
	    { 
	        int curr_sum = a[0], start = 0, i; 
	        int n = a.length;
	        // Pick a starting point 
	        for (i = 0; i < n; i++) { 
	        	// If curr_sum becomes equal to sum, 
	            // then return true 
	            if (curr_sum == s) { 
	                int end = i; 
	                System.out.println(start 
	                    + " " + end); 
	                return 1; 
	            } 
	            // If curr_sum exceeds the sum, 
	            // then remove the starting elements 
	            while (curr_sum > s && start < i) { 
	                curr_sum = curr_sum - a[start]; 
	                start++; 
	            } 
	            // Add this element to curr_sum 
	            if (i < n-1) 
	                curr_sum = curr_sum + a[i+1]; 
	        } 
	  
	        return 0; 
	    } 
	  
	    public static void main(String[] args) 
	    { 
	    	example arraysum = new example(); 
	        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
	        int sum = 23; 
	        int returned=arraysum.subArraySum(arr, sum); 
	        if(returned==0)
	        	System.out.println("-1");
	    }
	}