package section04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        System.out.println(solution(str));
    }
    public static char solution(String str) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character character : map.keySet()) {
            if (map.get(character) > max) {
                answer = character;
                max = map.get(character);
            }
        }
        return answer;
    }
}
