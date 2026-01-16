import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] board = new int[r][c];

        int[][] index = new int[2][2];
        int[][] firstDir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[][] secondDir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int a = Integer.parseInt(st.nextToken());
                board[i][j] = a;
                if (board[i][j] == -1) {
                    index[cnt][0] = i;
                    index[cnt++][1] = j;
                }
            }
        }

        for (int k = 0; k < t; k++) {
            int[][] sBoard = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] > 0) {
                        int amount = board[i][j] / 5;
                        int sCnt = 0;
                        for (int x = 0; x < 4; x++) {
                            int ni = i + firstDir[x][0];
                            int nj = j + firstDir[x][1];
                            if (ni >= 0 && ni < r && nj >= 0 && nj < c && board[ni][nj] != -1) {
                                sBoard[ni][nj] += amount;
                                sCnt++;
                            }
                        }
                        board[i][j] -= amount * sCnt;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    board[i][j] += sBoard[i][j];
                }
            }

            int tmp = 0;
            int ci = index[0][0];
            int cj = index[0][1];
            int idx = 0;
            while (idx < 4) {
                ci += firstDir[idx][0];
                cj += firstDir[idx][1];

                if (ci < 0 || ci > index[0][0] || cj < 0 || cj >= c) {
                    ci -= firstDir[idx][0];
                    cj -= firstDir[idx][1];
                    idx++;
                    continue;
                }

                if (ci == index[0][0] && cj == index[0][1]) {
                    break;
                }
                
                int sTmp = board[ci][cj];
                board[ci][cj] = tmp;
                tmp = sTmp;
            }

            tmp = 0;
            ci = index[1][0];
            cj = index[1][1];
            idx = 0;
            while (idx < 4) {
                ci += secondDir[idx][0];
                cj += secondDir[idx][1];

                if (ci < index[1][0] || ci >= r || cj < 0 || cj >= c) {
                    ci -= secondDir[idx][0];
                    cj -= secondDir[idx][1];
                    idx++;
                    continue;
                }

                if (ci == index[1][0] && cj == index[1][1]) {
                    break;
                }
                
                int sTmp = board[ci][cj];
                board[ci][cj] = tmp;
                tmp = sTmp;
            }
        }

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] != -1)
                    sum += board[i][j];
            }
        }

        System.out.print(sum);
    }
}