import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean hasTarget = false;

        for (String word : words) {
            if (word.equals(target)) {
                hasTarget = true;
                break;
            }
        }

        if (!hasTarget) return 0;

        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.word.equals(target)) {
                return current.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                if (canChange(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.count + 1));
                }
            }
        }

        return 0;
    }

    private boolean canChange(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }

            if (diff > 1) return false;
        }

        return diff == 1;
    }

    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}