import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static boolean[] isSelected;
	static int[][] synergy;
	static int result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			synergy = new int[N][N];
			result = Integer.MAX_VALUE;
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			sb.append('#').append(test_case).append(' ').append(result).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int l, int cnt){
		if(cnt==N/2) {
			result = Math.min(result, calScore());
            return;
		}
        for(int i = l; i < N; i++) {
            isSelected[i] = true;
            dfs(i+1, cnt + 1);
            isSelected[i] = false;
        }
	}

	private static int calScore() {
		int aScore = 0;
		int bScore = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i +1; j < N; j++) {
				if(isSelected[i] && isSelected[j]) aScore += synergy[i][j] + synergy[j][i];
				else if(!isSelected[i] && !isSelected[j]) bScore += synergy[i][j] + synergy[j][i];
			}
		}
		return Math.abs(aScore - bScore);
	}
}
