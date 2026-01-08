import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
            int[] a = new int[N];
            int[] b = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
            	a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
            	b[i] = Integer.parseInt(st.nextToken());
            }
            
            int result;
            if(a.length < b.length){
            	result = solution(a, b);
            }else{
                result = solution(b, a);
            }
            
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static int solution(int[] a, int[] b){
        int result = Integer.MIN_VALUE;
    	for(int i = 0; i <= b.length - a.length; i++){
        	int sum = 0;
            for(int j = i; j < i + a.length; j++){
            	sum += a[j - i] * b[j];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}