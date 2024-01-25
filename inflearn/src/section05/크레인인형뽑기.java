package section05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인인형뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine());
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(s.nextToken());
        }
        System.out.println(solution(board,moves));
    }

    private static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> bucket = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = board.length - 1; j >= 0; j--) {
                if(board[j][i]==0) continue;
                stack.push(board[j][i]);
            }
            list.add(stack);
        }
        for (int move : moves) {
            Stack<Integer> stack = list.get(move - 1);
            if (stack.isEmpty()) continue;
            if (!bucket.isEmpty()) {
                int peek = bucket.peek();
                if (stack.peek()==peek) {
                    bucket.pop();
                    stack.pop();
                    cnt += 2;
                } else {
                    bucket.push(stack.pop());
                }
            } else {
                bucket.push(stack.pop());
            }
        }
        return cnt;
    }
}
