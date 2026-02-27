import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            sb.append('#').append(tc).append(' ');
            //연산 1: 2개의 자연수가 주어지며, x를 최대 힙에 추가하는 연산
            //연산 2: 1개의 자연수 2가 주어지며 현재 최대 힙의 루트 노드의 키 값을 출력하고 해당 노드 삭제
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());

                if(command == 1){
                    int value = Integer.parseInt(st.nextToken());
                    q.offer(value);
                }else {
                    if (q.isEmpty()) sb.append(-1).append(' ');
                    else sb.append(q.poll()).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
