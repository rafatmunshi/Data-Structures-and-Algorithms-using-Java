package ds;

public class NQueensProblem {

	public static void nQueens(int N){
        int board[][] = 
      	  { { 0, 0, 0, 0 }, 
              { 0, 0, 0, 0 }, 
              { 0, 0, 0, 0 }, 
              { 0, 0, 0, 0 } }; 
        if(solveNQueens(N, board, 0)==false) {
        	System.out.println("Solution does not exist");
        	return;
        }
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + board[i][j] + " "); 
            System.out.println(); 
        }
	}
	static boolean solveNQueens(int N, int[][] board, int col){
		if(col>=N)
			return true;
		
		for(int i=0; i<N; i++) {
			if(feasible(board, i, col, N)) {
				board[i][col]=1;
				
				if(solveNQueens(N, board, col+1) == true) {
					return true;
				}
				board[i][col]=0;
			}
			
		}
		return false; // trigger backtracking
	}
    private static boolean feasible(int[][] board, int row, int col, int N) {
		int i, j;
		for(i=0;i<col;i++) {
			if(board[row][i]==1)
				return false;
		}
		for(i=row, j=col; i>=0&&j>=0; i--,j--) {
			if(board[i][j]==1)
				return false;
		}
		for(i=row, j=col; j>=0 && i<N; i++, j--) {
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	public static void main(String args[]) 
    { 
        int N=4;
        NQueensProblem.nQueens(N); 
    } 
}
