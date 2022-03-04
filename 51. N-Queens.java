//51. N-Queens
//https://leetcode.com/problems/n-queens/
//https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14&t=1479s
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0



class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        generate(0,board,ans);
        return ans;
    }
    public void generate(int col,char[][] board,List<List<String>> ans){
        //base case
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++){
            
            if(check(row,col,board)){
                board[row][col]='Q';
                generate(col+1,board,ans);
                board[row][col]='.';
            }
        }
    }
    public boolean check(int row,int col,char[][] board){
        int dupRow=row;
        int dupCol=col;
        
        //upper diagonal check
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')
                return false;
            row--;
            col--;
        }
        
        row=dupRow;
        col=dupCol;
        //left row check
        while(col>=0){
            if(board[row][col]=='Q')
                return false;
            col--;
        }
        
        
        row=dupRow;
        col=dupCol;
        ///lower diagonal check
        while(row<board.length && col>=0){
            if(board[row][col]=='Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    public List<String> construct(char[][] board){
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}






