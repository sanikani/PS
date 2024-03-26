package section10;

import java.io.*;
import java.util.*;

public class 가장높은탑쌓기 {
    static int[] dy;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Brick> list = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Brick(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        System.out.print(solution(list,n));
    }

    public static int solution(List<Brick> list, int n) {
        int answer = 0;
        Collections.sort(list);
        dy[0] = list.get(0).h;
        for (int i = 1; i < n; i++) {
            Brick a = list.get(i);
            dy[i] = a.h;
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(j).w < a.w) max = Math.max(max, dy[i] + dy[j]);
            }
            if (max == 0) {
                dy[i] = a.h;
            }else{
                dy[i] = max;
            }
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static class Brick implements Comparable<Brick>{
        int a;
        int h;
        int w;

        public Brick(int a, int h, int w) {
            this.a = a;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.a - this.a;
        }
    }

}
