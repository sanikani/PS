import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String X = st.nextToken();
			
			if (N==2) {
				System.out.println("#"+test_case+" "+0);
			}else {
				int sum = 0;
				for(int i=0; i<X.length(); i++) {
					int num = X.charAt(i)-'0';
					sum += num;
				}
				System.out.println("#"+test_case+" "+sum%(N-1));
			}
			
		}

	}
}
/*
 * N진법의 수 X
 * X를 N-1로 나눈 나머지
 * X가 주어졌을 때 X/(N-1)을 계산하는 프로그램
 * 9진법 234는 4+27+162 = 193/ 8로 나눈 나머지는  1
 * X를 10진법으로 변환해야됨
 * 한자리씩 가면서 
 * 3으로 봤을때
 * 3의 1승 나머지 1
 * 2승 나머지 1
 * 
 * 0승이면 나머지 1
 * 1승이면 나머지 1
 * 2승이면 나머지 81 = 1
 * 3승이면 나머지 9 * 9 * 9 = 1
 * 나머지는 모두 1이다.
 */