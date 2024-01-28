package section06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int s = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i : solution2(s, n, arr)) {
            System.out.print(i+" ");
        }
    }

    private static List<Integer> solution(int s, int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.contains(arr[i])) {
                list.remove(list.indexOf(arr[i]));
                list.add(0, arr[i]);
            } else {
                if (list.size() == s) {
                    list.remove(list.size() - 1);
                    list.add(0, arr[i]);
                } else {
                    list.add(0, arr[i]);
                }
            }
        }
        return list;
    }

    private static int[] solution2(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int i = 0; i < n; i++) {
            int pos = isContain(arr[i], cache);
            if (pos!=-1) {
                for (int j = pos; j >= 1; j--) {
                    cache[j] = cache[j - 1];
                }
                cache[0] = arr[i];
            } else {
                for (int j = cache.length - 1; j >= 1; j--) {
                    cache[j]=cache[j-1];
                }
                cache[0] = arr[i];
            }
        }
        return cache;
    }

    public static int isContain(int x, int[] cache) {
        for (int i = 0; i < cache.length; i++) if (cache[i] == x) return i;
        return -1;
    }
}
