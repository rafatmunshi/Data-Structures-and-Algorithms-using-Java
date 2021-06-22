package ds;

public class spiralMatrixPrint {
public static void main(String[] args) {
	int row=4;
	int col=4;
	int a[][]= {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
	};
	spiralPrint(row, col, a);
}
static void spiralPrint(int m, int n, int a[][]) {
	int r=0, c=0, i;
	while(r<m&&c<n) {
		//print first row from the remaining rows
		for(i=c;i<n;i++) {
			System.out.println(a[r][i]+" ");
		}
		r++;
		//print last column from the remaining columns
		for(i=r;i<m;i++) {
			System.out.println(a[i][n-1]+" ");
		}
		n--;
		//print the last row from the remaining rows
		if(r<m) {
		for(i=n-1;i>=c;--i) {
			System.out.println(a[m-1][i]+" ");
		}
		m--;
		}
		//print the first column from the remaining columns
		if(c<n) {
		for(i=m-1; i>=r;--i) {
			System.out.println(a[i][c]+" ");
		}
		c++;
		}
	}
}
}
