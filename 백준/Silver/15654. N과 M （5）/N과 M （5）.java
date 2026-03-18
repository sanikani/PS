import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    static int[] arr;
    static boolean[] vis;
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        arr = new int[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int l){
        if(l == m){
            for(int i : result){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            result[l] = arr[i];
            dfs(l + 1);
            vis[i] = false;
        }
    }
}