import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb =  new StringBuilder();
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] heigts = new int[N];
			for(int i = 0; i < N; i++) {
				heigts[i] = sc.nextInt();
			}
			
			sb.append('#').append(tc).append(' ').append(solution(N, heigts)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int n, int[] heigts) {
		int result = 0;
		
		for(int i = 1; i < n - 1; i++) {
			int now = heigts[i];
			int left = i - 1;
			int right = i + 1;
			if(heigts[left] > now || heigts[right] > now) continue;
			int lCnt = 1;
			int rCnt = 1;
			//왼쪽 가면서 확인
			for(int j = left; j >= 1; j--) {
				if(heigts[j] < heigts[j - 1]) break;
				lCnt++;
			}
			//오른쪽 가면서 확인
			for(int j = right; j < n - 1; j++) {
				if(heigts[j] < heigts[j + 1]) break;
				rCnt++;
			}
			result += lCnt * rCnt;
		}
		return result;
	}
}
