package section02;

import java.util.*;

public class 등수구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
            arrB[i] = arrA[i];
        }
        Map<Integer, Integer> result = solution(n, arrA);
        for (int x : arrB) {
            System.out.print(result.get(x) + " ");
        }
    }

    public static Map<Integer,Integer> solution(int n, Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0],1);
        for (int i = 1; i < n; i++) {
            if(arr[i].equals(arr[i-1])) map.put(arr[i], map.get(arr[i - 1]));
            else map.put(arr[i], i + 1);
        }

        return map;
    }

    public static int[] solution2(int[] arr) {
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = i; j < arr.length; j++) {
                if(arr[i]<arr[j]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
