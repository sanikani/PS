package section10;

import java.util.*;

public class 최대점수구하기 {
    static int[] dy;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<P> ps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ps.add(new P(in.nextInt(), in.nextInt()));
        }
        dy = new int[m + 1];
        System.out.println(solution(m,ps));
    }

    public static int solution(int m, List<P> ps) {
        Arrays.fill(dy,0);
        for (P p : ps) {
            for (int j = m; j >=p.time; j--) {
                dy[j] = Math.max(dy[j], dy[j - p.time] + p.point);
            }
        }
        return dy[m];
    }

    public static class P{
        int time;
        int point;

        public P(int p, int t) {
            time = t;
            point = p;
        }
    }
}
