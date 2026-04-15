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
        
        System.out.println(rabinKarp(T, P));
    }
    
    static String rabinKarp(String T, String P) {
        long MOD1 = 1_000_000_007L;
        long MOD2 = 1_000_000_009L;
        long MOD3 = 998_244_353L;

        long BASE1 = 31L;
        long BASE2 = 37L;
        long BASE3 = 41L;

        long tHash1 = 0, pHash1 = 0, power1 = 1;
        long tHash2 = 0, pHash2 = 0, power2 = 1;
        long tHash3 = 0, pHash3 = 0, power3 = 1;


        int n = T.length();
        int m = P.length();
        
        if (m > n) {
            return "0";
        }

        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            tHash1 = (tHash1 * BASE1 + T.charAt(i)) % MOD1;
            pHash1 = (pHash1 * BASE1 + P.charAt(i)) % MOD1;

            tHash2 = (tHash2 * BASE2 + T.charAt(i)) % MOD2;
            pHash2 = (pHash2 * BASE2 + P.charAt(i)) % MOD2;

            tHash3 = (tHash3 * BASE3 + T.charAt(i)) % MOD3;
            pHash3 = (pHash3 * BASE3 + P.charAt(i)) % MOD3;

            if (i < m - 1) {
                power1 = (power1 * BASE1) % MOD1;
                power2 = (power2 * BASE2) % MOD2;
                power3 = (power3 * BASE3) % MOD3;
            }
        }

        if (sameHash(tHash1, pHash1, tHash2, pHash2, tHash3, pHash3)) {
            idx.add(1);
        }

        // 롤링
        for (int i = 1; i <= n - m; i++) {
            tHash1 = rollHash(tHash1, T.charAt(i - 1), T.charAt(i + m - 1), power1, BASE1, MOD1);
            tHash2 = rollHash(tHash2, T.charAt(i - 1), T.charAt(i + m - 1), power2, BASE2, MOD2);
            tHash3 = rollHash(tHash3, T.charAt(i - 1), T.charAt(i + m - 1), power3, BASE3, MOD3);

            if (sameHash(tHash1, pHash1, tHash2, pHash2, tHash3, pHash3)) {
                idx.add(i + 1); // 1-based
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(idx.size()).append('\n');
        for (int pos : idx) {
            sb.append(pos).append(' ');
        }

        return sb.toString();
    }

    static long rollHash(long hash, char oldChar, char newChar,
                         long power, long base, long mod) {
        hash = (hash - (oldChar * power) % mod + mod) % mod;
        hash = (hash * base) % mod;
        hash = (hash + newChar) % mod;
        return hash;
    }

    static boolean sameHash(long t1, long p1, long t2, long p2, long t3, long p3) {
        return t1 == p1 && t2 == p2 && t3 == p3;
    }
}
