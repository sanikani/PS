package section09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대수입스케쥴 {
    public static class Schedule implements Comparable<Schedule>{
        int m;
        int d;

        public Schedule(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Schedule ob) {
            if (m == ob.m) {
                return this.d - ob.d;
            }
            return ob.m - m;
        }
    }

    public static void main(String[] args) throws IOException {
        최대수입스케쥴 T = new 최대수입스케쥴();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Schedule> Q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Q.add(new Schedule(m, d));
        }
        System.out.println(T.solution(Q));
    }

    private int solution(PriorityQueue<Schedule> Q) {
        int[] days = new int[10001];
        int sum = 0;
        int len = Q.size();
        for (int i = 0; i < len; i++) {
            Schedule s = Q.poll();
            for (int j = s.d; j > 0; j--) {
                if (days[j] == 0) {
                    days[j] = 1;
                    sum += s.m;
                    break;
                }
            }
        }
        return sum;
    }
}
