package section05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 응급실 {
    public static void main(String[] args) throws IOException {
        응급실 T = new 응급실();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(m,arr));
    }

    private int solution(int m, int[] arr) {
        Queue<Entry> Q = new LinkedList<>();
        int cnt = arr.length-1;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            Q.offer(new Entry(i,arr[i]));
        }
        Arrays.sort(arr);
        while (!Q.isEmpty()) {
            if (Q.peek().value >= arr[cnt]) {
                cnt--;
                answer++;
                if (Q.poll().key == m) {
                    return answer;
                }
            } else {
                Q.offer(Q.poll());
            }

        }
        return answer;
    }

    public class Entry {
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
