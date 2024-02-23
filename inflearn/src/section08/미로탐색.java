package section08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] board = new int[7][7];
    static int answer = 0;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        미로탐색 T = new 미로탐색();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
        }
        board[0][0] = 1;
        T.DFS(0,0);
        System.out.println(answer);

    }

    private void DFS(int x,int y) {
        if (x == 6 && y == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        DFS(nx, ny);
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
