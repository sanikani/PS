import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			
			System.out.println("#"+test_case+" "+ solution(first, second));
		}
		
	}

	private static String solution(String first, String second) {
		List<Character> diff = new ArrayList<Character>();
		diff.add('A');
		diff.add('D');
		diff.add('O');
		diff.add('P');
		diff.add('Q');
		diff.add('R');
		if (first.length()!=second.length()) {
			return "DIFF";
		}
	
		for(int i=0; i<first.length(); i++) {
			char a = first.charAt(i);
			char b = second.charAt(i);
			if (a=='B' && b=='B') {
				continue;
			}
			else if (diff.contains(a) && diff.contains(b)) {
				continue;
			}else if (!diff.contains(a) && !diff.contains(b) && a!='B' && b!='B') {
				continue;
			}
			return "DIFF";
			
		}
		return "SAME";
	}
}