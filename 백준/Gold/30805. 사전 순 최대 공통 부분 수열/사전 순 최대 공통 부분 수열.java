import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, List<Integer>> aMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!aMap.containsKey(num)) aMap.put(num, new ArrayList<>());
			aMap.get(num).add(i);
		}
		
		int m = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> bMap = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!bMap.containsKey(num)) bMap.put(num, new ArrayList<>());
			bMap.get(num).add(i);
		}
		
		List<Integer> list = new ArrayList<>();
		int aIdx = 0;
		int bIdx = 0;
		for(int i = 100; i > 0; i--) {
			while(true) {
				int nextA = -1;
				for (int idx : aMap.getOrDefault(i, new ArrayList<>())) {
					if(idx >= aIdx) {
						nextA = idx;
						break;
					}
				}
				
				int nextB = -1;
				for(int idx : bMap.getOrDefault(i, new ArrayList<>())) {
					if(idx >= bIdx) {
						nextB = idx;
						break;
					}
				}
				
				if(nextA == -1 || nextB == -1) break;
				
				list.add(i);
				aIdx = nextA + 1;
				bIdx = nextB + 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');
		list.stream().forEach(i -> sb.append(i).append(' '));
		System.out.println(sb);
		
	}
}
