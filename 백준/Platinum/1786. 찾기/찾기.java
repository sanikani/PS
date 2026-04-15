import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        System.out.println(kmp(T, P));
    }

    static int[] getLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
            }
        }

        return lps;
    }

    static String kmp(String text, String pattern) {
        StringBuilder sb = new StringBuilder();
        int[] lps = getLPS(pattern);
        int n = text.length();
        int m = pattern.length();

        int j = 0;
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    idx.add(i - m + 2);
                    j = lps[j];
                } else {
                    j++;
                }
            }
        }

        sb.append(idx.size()).append('\n');
        idx.forEach(i -> sb.append(i).append(' '));
        return sb.toString();
    }
}