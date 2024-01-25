package section04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class K번째큰수 {
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
        System.out.println(solution2(k,arr));
    }

    private static int solution(int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int x = j + 1; x < arr.length; x++) {
                    set.add(arr[i]+arr[j]+arr[x]);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (list.size() < k) {
            return -1;
        }
        return list.get(list.size()-k);
    }

    private static int solution2(int k, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int x = j + 1; x < arr.length; x++) {
                    set.add(arr[i]+arr[j]+arr[x]);
                }
            }
        }
        int cnt = 0;
        for (Integer i : set) {
            cnt++;
            if (cnt == k) {
                return i;
            }
        }
        return -1;
    }
}
