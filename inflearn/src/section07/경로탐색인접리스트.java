package section07;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색인접리스트 {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> list;
    static int[] ch;
    public static void main(String[] args) {
        경로탐색인접리스트 T = new 경로탐색인접리스트();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int x : list.get(v)) {
                if(ch[x]==0){
                    ch[x] = 1;
                    DFS(x);
                    ch[x] = 0;
                }
            }
        }
    }
}
