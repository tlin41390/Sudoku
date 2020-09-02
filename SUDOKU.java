import java.util.*;

public class SUDOKU
{

	//this checks to see if therre are no duplicate numbers in a row.
	public boolean checkInRow (int[][] board, int row, int value) 
	{
		for (int i =0; i<board.length;i++)
		{
			if (board[row][i] == value)
			{
				return true;
			}
		}
		return false;
	}
	//this checks to see if there are no duplicate numbers in a column.
	public boolean checkInCol (int[][] board, int col, int value)
	{
		for (int i=0;i<board.length;i++)
		{
			if (board[i][col] == value)
			{
				return true;
			}
		}
		return false;
	}
	//this checks to see if there are no duplicate numbers in a box.
	public boolean checkBox (int[][] board, int boxRow, int boxCol, int value)
	{
		for (int row=0; row<3; row++)
		{
			for (int col =0; col<3; col++)
			{
				if (board[row+boxRow][col+boxCol]==value)
				{
					return true;
				}
			}
		}
		return false;
	}
	//this code here checks to find where an empty cell is.
	public int[] isUnassigned(int[][] board)
	{
		int[] checker = new int[2];
		checker[0]=-1;
		checker[1]=-1;	
		for (int row=0; row<board.length;row++)
		{
			for (int col=0;col<board.length;col++)
			{
				if (board[row][col]==0)
				{
					checker[0]=row;
					checker[1]=col;
					return checker;
				}
			}
		}
		return checker;
	}
	//this code here checks to see if the  value is safe to put in the  empty cell.
	public boolean isValid(int[][] board, int row, int col, int value )
	{
		return !checkInRow(board,row,value)&&!checkInCol(board,col,value)&&!checkBox(board, row - row % 3, col - col % 3,value);
		
	}
	//this code here prints the board.
	public void printBoard(int[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
	//this part is the algorithim to solve the sudoku board
	public boolean solve(int [][] board)
	{
		int [] blankCell = isUnassigned(board);

		if(blankCell[0]== -1)
		{
			return true;
		}

		int emptyRow = blankCell[0];
		int emptyCol = blankCell[1];

		for (int i=1;i<=9;i++)
		{
			if(isValid(board,emptyRow,emptyCol,i))
			{
				board[emptyRow][emptyCol]=i;
				if(solve(board))
				{
					return true;
				}
			}
		}
		board[emptyRow][emptyCol]=0;
		return false;
	}

	public static void main(String[] args)
	{
		//TODO create board and add the solve function as well as printing out the completed and correct board.
	}	
}
