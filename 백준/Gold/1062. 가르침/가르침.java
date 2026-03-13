import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<Character> alphabetSet;
	static List<Character> alphabetList;
	static int N;
	static int K;
	static List<Set<Character>> words;
	static int max;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
        if (K < 5) {
		    System.out.println(0);
		    return;
		}
		alphabetSet = new HashSet<>();
		words = new ArrayList<>();
		max = 0;
		isSelected = new boolean[26];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			words.add(new HashSet<>());
			for(int j = 4; j < s.length() - 4; j++) {
				char c = s.charAt(j);
				if(c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') continue;
				alphabetSet.add(c);
				words.get(i).add(c);
			}
		}
        
		alphabetList = new ArrayList<>(alphabetSet);
        
        if (alphabetList.size() <= K - 5) {
            System.out.println(N);
            return;
        }
        
		dfs(0, 0);
		System.out.println(max);
	}
	
	static void dfs(int l, int start) {
		if(max == N) return;
		
		if(l == K - 5) {
			int result = 0;
			for (Set<Character> chars : words) {
				int cnt = 0;
                if(chars.size() == 0) result++;
				for (Character c : chars) {
					if(!isSelected[c - 'a']) continue;
					cnt++;
					if(cnt == chars.size()) {
						result++;
						break;
					}
				}
			}
			max = Math.max(max, result);
			return;
		}
		
		for(int i = start; i < alphabetList.size(); i++) {
			
			isSelected[alphabetList.get(i) - 'a'] = true;
			dfs(l + 1, i + 1);
			isSelected[alphabetList.get(i) - 'a'] = false;
		}
	}
}
