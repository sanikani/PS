import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[] tanks = {'^', 'v', '<', '>'};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			for(int i = 0 ; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int N = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray();
			
			
			sb.append('#').append(test_case).append(' ').append(solution(H, W, map, N, command));
		}
		
		System.out.println(sb);
	}

	private static String solution(int h, int w, char[][] map, int n, char[] command) {
		StringBuilder sb = new StringBuilder();
		int[] tank = findTank(map);
		map[tank[0]][tank[1]] = '.';
		for(int i = 0; i < n; i++) {
			if(command[i] == 'U' || command[i] == 'D' || command[i] == 'L' || command[i] == 'R') {
				int dir = commandToIndex(command[i]);
				tank[2] = dir;
				move(map, dr[dir], dc[dir], tank);
			}else if(command[i] == 'S') {
				shoot(map, tank);
			}
		}
		map[tank[0]][tank[1]] = indexToTank(tank[2]);
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	private static int[] findTank(char[][] map) {
		int[] tank = new int[2];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0 ; j < map[i].length; j++) {
				if(isTank(map[i][j])) {
					return tank = new int[]{i, j, tankToIndex(map[i][j])};
				}
			}
		}
		return tank;
	}

	static void move(char[][] map, int dr, int dc, int[] tank) {
		int nr = tank[0] + dr;
		int nc = tank[1] + dc;
		
		if(inRange(map, nr, nc)) return;
		if(map[nr][nc] =='#' || map[nr][nc] =='*' || map[nr][nc] =='-') return;
		tank[0] = nr;
		tank[1] = nc;
	}
	
	static void shoot(char[][] map, int[] tank) {
		int nr = tank[0] + dr[tank[2]];
		int nc = tank[1] + dc[tank[2]];
		while(true) {
			if(inRange(map, nr, nc)) return;
			if(map[nr][nc] == '#') return;
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				return;
			}
			nr += dr[tank[2]];
			nc += dc[tank[2]];
		}
	}

	private static boolean inRange(char[][] map, int nr, int nc) {
		return nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length;
	}
	
	private static boolean isTank(char c) {
		return c == 'v' || c == '^' || c == '<' || c == '>';
	}
	
	static int commandToIndex(char c) {
		if(c == 'U') return 0;
		if(c == 'D') return 1;
		if(c == 'L') return 2;
		return 3;
	}
	
	static int tankToIndex(char c) {
		if(c == '^') return 0;
		if(c == 'v') return 1;
		if(c == '<') return 2;
		return 3;
	}
	
	static char indexToTank(int i) {
		if(i == 0) return '^';
		if(i == 1) return 'v';
		if(i == 2) return '<';
		return '>';
	}
}
