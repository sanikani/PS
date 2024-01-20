package section03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(k,arr));
    }

    private static int solution(int k, int[] arr) {
        int lt=0;
        int rt = k;
        int max = 0;
        for (int i = 0; i < rt; i++) {
            max += arr[i];
        }
        int sum=max;
        while (rt < arr.length-1) {
            sum = sum - arr[lt++] + arr[rt++];
            if(sum>max) max = sum;
        }
        return max;
    }
}
