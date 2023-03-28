https://leetcode.com/problems/word-search/description/
https://www.youtube.com/watch?v=vYYNp0Jrdv0

TC:O(M*N)
  SC:O(M*N)

class Solution {
    public boolean dfs(char[][] board,String word,int i,int j,int count){

        if(count==word.length())
            return true;

         if(i<0 || i>=board.length || j<0 || j>=board[i].length || word.charAt(count)!=board[i][j])
            return false;

        char temp=board[i][j];
        board[i][j]=' ';

        Boolean found=dfs(board,word,i-1,j,count+1)||dfs(board,word,i,j+1,count+1)||dfs(board,word,i+1,j,count+1)||dfs(board,word,i,j-1,count+1);
        board[i][j]=temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int r=board.length,c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
}
