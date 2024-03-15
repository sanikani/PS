package section09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식{
    public static class Time implements Comparable<Time>{
        int t;
        char state;

        public Time(int t, char state) {
            this.t = t;
            this.state = state;
        }

        @Override
        public int compareTo(Time ob) {
            if (ob.t == this.t) {
                return this.state - ob.state;
            }
            return this.t - ob.t;
        }
    }
    public static void main(String[] args) throws IOException {
        결혼식 T = new 결혼식();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Time(Integer.parseInt(st.nextToken()), 's'));
            list.add(new Time(Integer.parseInt(st.nextToken()), 'e'));
        }
        System.out.println(T.solution(list));
    }

    private int solution(List<Time> list) {
        Collections.sort(list);
        int cnt = 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
