import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] s;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			
			int k = Integer.parseInt(st.nextToken());
			if (k==0) {
				break;
			}
			s = new int[k];
			result = new int[6];
			for(int i=0; i<k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i= 0; i<s.length; i++) {
				result[0] =s[i];
				for(int j= i+1; j<s.length; j++) {
					result[1] = s[j];
					for(int n= j+1; n<s.length; n++) {
						result[2] = s[n];
						for(int m= n+1; m<s.length; m++) {
							result[3] = s[m];
							for(int x= m+1; x<s.length; x++) {
								result[4] = s[x];
								for(int y= x+1; y<s.length; y++) {
									result[5] = s[y];
									StringBuilder sb = new StringBuilder();
									for(int index = 0; index<6; index++) {
										sb.append(result[index]).append(" ");
									}
									System.out.println(sb.toString().trim());
								}
							}
						}
					}
				}
			}
			System.out.println();
			st = new StringTokenizer(br.readLine());
		}
	}
}