package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(solution(n,k));
    }

    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (cnt != k) {
                queue.offer(i);
                cnt++;
            } else {
                cnt = 1;
            }
        }
        while (queue.size() > 1) {
            if (cnt != k) {
                queue.offer(queue.poll());
                cnt++;
            } else {
                cnt = 1;
                queue.poll();
            }
        }
        return queue.poll();
    }
}
