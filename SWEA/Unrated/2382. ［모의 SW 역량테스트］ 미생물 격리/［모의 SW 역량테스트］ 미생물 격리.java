import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//셀의 개수 N, 격리 시간 M, 미생물 군집의 개수 K
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<Group> groups = new ArrayList<>();
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				groups.add(new Group(new Location(r, c), amount, dir));
			}
			
			sb.append('#').append(tc).append(' ').append(solution(groups, N, M, K)).append('\n');
		}
		System.out.println(sb);
	}
	
	private static int solution(List<Group> groups, int n, int m, int k) {
		//모든 군집 이동시키며 Map에 이동 결과 기록
		for(int h = 0; h < m; h++) {
			Map<Location, List<Group>> map = new HashMap<>();
			for(Group g : groups) {
				if(g.amount == 0) continue;
				int nr = g.location.r + dr[g.dir];
				int nc = g.location.c + dc[g.dir];
				if(nr <= 0 || nr >= n - 1 || nc <= 0 || nc >= n - 1) {
					g.amount /= 2;
					changeDir(g);	
				}
				Location location = new Location(nr, nc);
				if(!map.containsKey(location)) {
					map.put(location, new ArrayList<>());
				}
				map.get(location).add(new Group(location, g.amount, g.dir));
			}
			
			groups.clear();
			for(Map.Entry<Location, List<Group>> entry : map.entrySet()) {
				if(entry.getValue().size() > 1) {
					//같은 위치에 모일 경우 수는 모든 값의 합, 이동방향은 최대 군집 방향
					int max = 0;
					int dir = 0;
					int sum = 0;
					for(Group g : entry.getValue()) {
						if(g.amount > max) {
							max = g.amount;
							dir = g.dir;
						}
						sum += g.amount;
					}
					groups.add(new Group(entry.getKey(), sum, dir));
				}else {
					groups.add(entry.getValue().get(0));
				}
			}
		}
		
		int remain = 0;
		for (Group group : groups) {
			remain += group.amount;
		}
		return remain;
	}

	private static void changeDir(Group g) {
		int dir = g.dir;
		if(dir % 2 == 1) g.dir--;
		else g.dir++;
	}

	static class Group{
		Location location;
		int amount;
		int dir;
		
		public Group(Location location, int amount, int dir) {
			this.location = location;
			this.amount = amount;
			this.dir = dir;
		}
	}
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int hashCode() {
			return Objects.hash(c, r);
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			Location other = (Location) obj;
			return c == other.c && r == other.r;
		}
	}
}
