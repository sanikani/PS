package section04;

import java.io.*;
import java.util.*;

public class 매출액의종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : solution(k,arr)) {
            System.out.print(x+" ");
        }
    }
    private static int[] solution(int k, int[] arr) {
        int[] answer = new int[arr.length - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < k; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
        }
        answer[0]=map.size();
        int lt = 1;
        for (int i = 1; i < answer.length; i++) {
            map.put(arr[lt - 1], map.get(arr[lt - 1]) - 1);
            if (map.get(arr[lt - 1]) == 0) {
                map.remove(arr[lt - 1]);
            }
            map.put(arr[k], map.getOrDefault(arr[k], 0) + 1);
            answer[i] = map.size();
            lt++;
            k++;
        }
        return answer;
    }
}
