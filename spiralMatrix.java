package ds;

public class spiralMatrix {
    static void spiralPrint(int m, int n, int a[][]) 
    { 
        int i, r = 0, c = 0; 
        /*  r - starting row index 
        m - ending row index 
        c - starting column index 
        n - ending column index 
        i - iterator 
        */
  
        while (r < m && c < n) { 
            // Print the first row from the remaining rows 
            for (i = c; i < n; ++i) { 
                System.out.print(a[r][i] + " "); 
            } 
            r++; 
  
            // Print the last column from the remaining columns 
            for (i = r; i < m; ++i) { 
                System.out.print(a[i][n - 1] + " "); 
            } 
            n--; 
  
            // Print the last row from the remaining rows */ 
            if (r < m) { 
                for (i = n - 1; i >= c; --i) { 
                    System.out.print(a[m - 1][i] + " "); 
                } 
                m--; 
            } 
  
            // Print the first column from the remaining columns */ 
            if (c < n) { 
                for (i = m - 1; i >= r; --i) { 
                    System.out.print(a[i][c] + " "); 
                } 
                c++; 
            } 
        } 
    } 
  
    // driver program 
    public static void main(String[] args) 
    { 
        int row = 3; 
        int col = 6; 
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } }; 
        spiralPrint(row, col, a); 
    } 
}
