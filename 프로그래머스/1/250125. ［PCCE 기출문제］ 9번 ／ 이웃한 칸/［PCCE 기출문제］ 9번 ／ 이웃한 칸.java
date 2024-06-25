class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dh = {1,0,-1,0};
        int[] dw = {0,1,0,-1};
        int hLen = board.length;
        int wLen = board[0].length;
        int answer = 0;
        for(int i=0;i<4;i++){
            int ch = h+dh[i];
            int cw = w+dw[i];
            if(ch>=hLen || ch<0 || cw>=wLen || cw <0){
                continue;
            } 
            if(board[ch][cw].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}