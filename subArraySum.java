package ds;

public class subArraySum {
public static void main(String [] args) {
	int arr[]= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int sum=15;
	int returned=subArrSum(arr, sum);
	if(returned==0)
		System.out.println("-1");
}

static int subArrSum(int a[], int s) {
	int curr_sum=a[0], start=0, i;
	int n=a.length;
	for(i=0; i<n;i++) {
		if(curr_sum == s) {
			int end =i;
			System.out.println(start+" "+end);
			return 1;
		}
		while(curr_sum>s&&start<i) {
			curr_sum=curr_sum-a[start];
			start++;
		}
		if(i<n-1)
		curr_sum=curr_sum+a[i+1];
	}
	return 0;
}
}
