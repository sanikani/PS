package section09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 씨름선수 {
    static int n;
    public static void main(String[] args) throws IOException {

        씨름선수 T = new 씨름선수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
//        int[][] arr = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < 2; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        System.out.println(T.solution2(arr));
        List<Body> bodies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bodies.add(new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        System.out.println(T.solution3(bodies));
    }

    private int solution(int[][] arr) {
        int answer = n;
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i][1] < arr[j][1]) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    private int solution2(int[][] arr) {
        int answer = n;
        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]).reversed());
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i][1]);
            if (arr[i][1] < max) {
                answer--;
            }
        }
        return answer;
    }

    private int solution3(List<Body> bodies) {
        int answer = n;
        Collections.sort(bodies);
        int max = bodies.get(0).weight;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, bodies.get(i).weight);
            if (bodies.get(i).weight < max) {
                answer--;
            }
        }
        return answer;
    }

    public static class Body implements Comparable<Body>{
        int height;
        int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height-this.height;
        }
    }
}
