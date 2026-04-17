import java.util.*;

class Solution {
    public static int solution(int[] players, int m, int k) {
        int answer = 0;

        int serverCnt = 0;
        Queue<Integer> serverQ = new ArrayDeque<>();

        for (int i = 0; i < players.length; i++) {
            while (!serverQ.isEmpty() && serverQ.peek() + k <= i) {
                serverCnt--;
                serverQ.poll();
            }
            int availablePlayer = (serverCnt + 1) * m - 1;
            if (players[i] > availablePlayer) {
                int newServer = players[i] / m - serverCnt;
                for (int j = 0; j < newServer; j++) {
                    serverQ.offer(i);
                }
                answer += newServer;
                serverCnt += newServer;
            }
        }
        return answer;
    }
}