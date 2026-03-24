import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            String s = br.readLine();

            TreeSet<String> set = new TreeSet<>();

            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < s.length(); j++) {
                    sb.append(s.charAt(j));
                    set.add(sb.toString());
                }
            }

            String result = "none";

            if (set.size() >= k) {
                int idx = 1;
                for (String str : set) {
                    if (idx == k) {
                        result = str;
                        break;
                    }
                    idx++;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}