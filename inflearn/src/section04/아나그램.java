package section04;

import java.io.*;
import java.util.*;

public class 아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.print(solution(a, b));
    }

    public static String solution(String a, String b) {
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        String answer = "YES";
        for (int i = 0; i < a.length(); i++) {
            aMap.put(a.charAt(i), aMap.getOrDefault(a.charAt(i), 0)+1);
            bMap.put(b.charAt(i), bMap.getOrDefault(b.charAt(i), 0)+1);
        }
        for (char x : aMap.keySet()) {
            if (bMap.get(x) == null) {
                answer = "NO";
                break;
            }
            if (!bMap.get(x).equals(aMap.get(x))) {
                answer = "NO";
            }
        }
        return answer;
    }

    public static String solution2(String a, String b) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (char x : a.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : b.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }
}
