package section09;

import java.util.Scanner;

public class 친구인가UNF {
    static int[] unf;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            Union(in.nextInt(), in.nextInt());
        }
        int fa = Find(in.nextInt());
        int fb = Find(in.nextInt());
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    private static void Union(int a, int b) {
        if(Find(a)!=Find(b)) unf[Find(a)] = Find(b);
    }
}
