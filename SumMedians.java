package ds;

public class SumMedians {

	static int getMedian(int[] farr, int[] sarr, int farrStart, int farrEnd, int sarrStart, int sarrEnd) {
		if(farrEnd-farrStart == 2) {
			return (Math.max(farr[farrStart], sarr[sarrStart])+Math.min(farr[farrEnd], sarr[sarrEnd]));
		}
		int m1= median(farr, farrStart, farrEnd);
		
		int m2= median(sarr, sarrStart, sarrEnd);
		
		if(m1==m2)
			return m1+m2;
		
		else if(m1>m2) {
			return getMedian(farr, sarr, farrStart, (farrEnd-farrStart+1)/2, (sarrEnd-sarrStart-1)/2, sarrEnd);
		}
		else {
			return getMedian(farr, sarr, (farrEnd-farrStart-1)/2, farrEnd, sarrStart, (sarrEnd-sarrStart+1)/2);
		}
	}
	
	static int median(int[] arr, int arrStart, int arrEnd) {
		int len=arrEnd- arrStart +1;
		if(len%2 ==0) {
			return (arr[arrStart + (len/2)] + arr[arrStart + (len/2-1)])/2;
		}
		else
			return arr[arrStart + (len/2)];
	}
	    public static void main(String[] args)
	    {
	        int arr1[] = { 1, 3, 5, 7 };
	        int arr2[] = { 2, 4, 6, 8 };
	        if (arr1.length == 0) {
	            System.out.println("0");
	        }
	        else if (arr1.length == 1) {
	            System.out.println(arr1[0] + arr2[0]);
	        }
	        else {
	            System.out.println(getMedian(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1));
	        }
	    }
}
