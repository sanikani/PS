import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dfs(0, 1);
        System.out.print(sb);
    }

    static void dfs(int l, int num){
        if(l == m){
            for(int i : arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = num; i <= n; i++){
            arr[l] = i;
            dfs(l + 1, i);
        }
    }
}