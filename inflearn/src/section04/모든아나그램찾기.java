package section04;

import java.util.*;
import java.io.*;

public class 모든아나그램찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(solution(a, b));
    }

    public static int solution(String a, String b) {
        int lt = 0;
        int rt = b.length()-1;
        int answer = a.length() - b.length() + 1;
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (char x : b.toCharArray()) {
            bMap.put(x, bMap.getOrDefault(x, 0) + 1);
        }

        for (int i = lt; i <= rt; i++) {
            aMap.put(a.charAt(i), aMap.getOrDefault(a.charAt(i), 0) + 1);
        }
        lt++;
        rt++;
        for (int j = lt; rt<=a.length(); j++) {
            for (char x : bMap.keySet()) {
                if (!aMap.containsKey(x)) {
                    answer--;
                    break;
                } else if (!aMap.get(x).equals(bMap.get(x))) {
                    answer--;
                    break;
                }
            }
            aMap.put(a.charAt(j - 1), aMap.get(a.charAt(j - 1)) - 1);
            if (aMap.get(a.charAt(j - 1)) == 0) {
                aMap.remove(a.charAt(j - 1));
            }
            if (rt == a.length()) {
                break;
            }
            aMap.put(a.charAt(rt), aMap.getOrDefault(a.charAt(rt), 0) + 1);
            lt++;
            rt++;
        }
        return answer;
    }
}
