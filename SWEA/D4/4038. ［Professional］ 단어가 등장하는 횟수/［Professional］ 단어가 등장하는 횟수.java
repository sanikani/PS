import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	private static final int EXPONET1= 31;
	private static final int EXPONET2= 34;
	private static final int EXPONET3= 37;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String B = br.readLine();
			String S = br.readLine();
			
			int stringHash1 = 0;
			int stringHash2 = 0;
			int stringHash3 = 0;
			
			int patternHash1 = 0;
			int patternHash2 = 0;
			int patternHash3 = 0;
			
			int power1 = 1;
			int power2 = 1;
			int power3 = 1;
			
			//0 ~ B - S 까지
			int bookLen = B.length();
			int patternLen = S.length();
			int cnt = 0;
			
			for(int i = 0; i <= bookLen - patternLen; i++) {
				if(i == 0) {
					for(int j = 0; j < patternLen; j++) {
						
						stringHash1 += hash(B.charAt(patternLen - 1 - j), power1);
						patternHash1 += hash(S.charAt(patternLen - 1 - j), power1);
						
						stringHash2 += hash(B.charAt(patternLen - 1 - j), power2);
						patternHash2 += hash(S.charAt(patternLen - 1 - j), power2);
						
						stringHash3 += hash(B.charAt(patternLen - 1 - j), power3);
						patternHash3 += hash(S.charAt(patternLen - 1 - j), power3);
						
						if(j < patternLen - 1) {
							power1 *= EXPONET1;
							power2 *= EXPONET2;
							power3 *= EXPONET3;
						}
					}
				}else {
					stringHash1 = EXPONET1 * (stringHash1 - hash(B.charAt(i - 1), power1)) 
							+ B.charAt(i + patternLen - 1);
					stringHash2 = EXPONET2 * (stringHash2 - hash(B.charAt(i - 1), power2)) 
							+ B.charAt(i + patternLen - 1);
					stringHash3 = EXPONET3 * (stringHash3 - hash(B.charAt(i - 1), power3)) 
							+ B.charAt(i + patternLen - 1);
				}
				
				if(stringHash1 == patternHash1 && stringHash2 == patternHash2 && stringHash3 == patternHash3) cnt++; 
			}
			sb.append('#').append(tc).append(' ').append(cnt).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int hash(int v, int p) {
		return v * p;
	}
}
