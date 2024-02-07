package section07;

import java.util.*;

public class 송아지찾기 {
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public static void main(String[] args) {
        송아지찾기 T = new 송아지찾기();
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int E = in.nextInt();
        System.out.println(T.solution(S,E));
    }

    private int solution(int s,int E) {
        ch = new int[10001];
        Q.offer(s);
        ch[s] = 1;
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int value = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = value + dis[j];
                    if (nx == E) {
                        return L + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return L;
    }
}
