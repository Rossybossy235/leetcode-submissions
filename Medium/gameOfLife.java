class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] temp = new int[rows][cols];
        
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                int count = neighborCount(board, r - 1, c - 1) 
                            + neighborCount(board, r - 1, c) 
                            + neighborCount(board, r - 1, c + 1) 
                            + neighborCount(board, r, c + 1) 
                            + neighborCount(board, r + 1, c + 1) 
                            + neighborCount(board, r + 1, c) 
                            + neighborCount(board, r + 1, c - 1) 
                            + neighborCount(board, r, c - 1);
                
                if (board[r][c] == 1)
                {
                    if (count < 2 || count > 3)
                    {
                        temp[r][c] = 0;
                    }
                    else
                    {
                        temp[r][c] = 1;
                    }
                }
                else
                {
                    if (count == 3)
                    {
                        temp[r][c] = 1;
                    }
                    else
                    {
                        temp[r][c] = 0;
                    }
                }
            }
        }
        
        for (int r = 0; r < rows; r++)
        {
            board[r] = temp[r].clone();
        }
    }
    
    public int neighborCount(int[][] board, int row, int col)
    {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 0)
            return 0;
        else
            return 1;
    }
}