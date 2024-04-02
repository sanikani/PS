package section10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 동전교환 {
    static int[] ch;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        int money = in.nextInt();
        ch = new int[money + 1];
        System.out.println(solution2(n, coins, money));
    }

    public static int solution(int n, int[] coins, int money) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        while (!Q.isEmpty()) {
            int len = Q.size();
            answer++;
            for (int j = 0; j < len; j++) {
                int a = Q.poll();

                for (int i = 0; i < n; i++) {
                    if (a + coins[i] < money && ch[a+coins[i]]==0) {
                        ch[a + coins[i]] = 1;
                        Q.offer(a + coins[i]);
                    } else if (a + coins[i] == money) {
                        return answer;
                    }
                }
            }

        }
        return answer;
    }

    public static int solution2(int n, int[] coins, int money) {
        Arrays.fill(ch, Integer.MAX_VALUE);
        ch[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j < ch.length; j++) {
                ch[j] = Math.min(ch[j], ch[j - coins[i]] + 1);
            }
        }
        return ch[money];
    }
}
