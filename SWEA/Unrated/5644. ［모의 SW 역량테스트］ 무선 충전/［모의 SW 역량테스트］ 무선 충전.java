import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] aMove = new int[M+1];
			int[] bMove = new int[M+1];
			int[][] BCArr = new int[A][4];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BCArr[i][1] = Integer.parseInt(st.nextToken()) - 1;
				BCArr[i][0] = Integer.parseInt(st.nextToken()) - 1;
				BCArr[i][2] = Integer.parseInt(st.nextToken());
				BCArr[i][3] = Integer.parseInt(st.nextToken());
			}
			
			sb.append('#').append(test_case).append(' ').append(solution(aMove, bMove, BCArr, M, A)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int[] aMove, int[] bMove, int[][] bCArr, int m, int a) {
		int result = 0;
		int ar = 0, ac = 0, br = 9, bc = 9;
		for(int i = 0; i <= m; i++) {
			ar += dr[aMove[i]];
			ac += dc[aMove[i]];
			br += dr[bMove[i]];
			bc += dc[bMove[i]];
			List<Integer> validABC = new ArrayList<>();
			List<Integer> validBBC = new ArrayList<>();
			for(int j = 0; j < bCArr.length; j++) {
				if(inRange(ar, ac, bCArr[j][0], bCArr[j][1], bCArr[j][2])) {
					validABC.add(j);
					
				}
				if(inRange(br, bc, bCArr[j][0], bCArr[j][1], bCArr[j][2])) {
					validBBC.add(j);
				}
			}
			result += getMax(validABC, validBBC, bCArr);
		}
		return result;
	}

	private static int getMax(List<Integer> validABC, List<Integer> validBBC, int[][] bCArr) {
		int max = 0;
		if(validABC.isEmpty() && validBBC.isEmpty()) return 0;
		if(!validABC.isEmpty() && validBBC.isEmpty()) return validABC.stream().mapToInt(i -> bCArr[i][3]).max().getAsInt();
		if(validABC.isEmpty() && !validBBC.isEmpty()) return validBBC.stream().mapToInt(i -> bCArr[i][3]).max().getAsInt();
		
		for(int i = 0; i < validABC.size(); i++) {
			int[] aBC = bCArr[validABC.get(i)];
			int sum = 0;
			for(int j = 0; j < validBBC.size(); j++) {
				int[] bBC = bCArr[validBBC.get(j)];
				if(aBC[0] == bBC[0] && aBC[1] == bBC[1]) {
					sum = aBC[3];
				}else {
					sum = aBC[3] + bBC[3];
				}
				max = Math.max(max, sum);
			}			
		}
		return max;
	}

	private static boolean inRange(int r, int c, int i, int j, int d) {
		return (Math.abs(r-i) + Math.abs(c-j)) <= d;
	}
}
