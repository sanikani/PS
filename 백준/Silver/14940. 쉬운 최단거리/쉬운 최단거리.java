import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		result = new int[n][m];
		for(int[] nums : result) {
			Arrays.fill(nums, -1);
		}
		
		
		int startI = 0;
		int startJ = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int value = Integer.parseInt(st.nextToken());
				board[i][j] = value;
				if (value==2) {
					startI = i;
					startJ = j;
				}
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startI, startJ));
		result[startI][startJ] = 0;
		while (!queue.isEmpty()) {
			
			Node node = queue.poll();
			int ci = node.getI();
		    int cj = node.getJ();
			for(int j=0; j<4; j++) {
				int di = node.getI() + direction[j][0];
				int dj = node.getJ() + direction[j][1];
				if (di<0 || di >= n || dj<0 || dj >=m ) {
					continue;	
				}
				if (board[di][dj] == 0) continue;
		        if (result[di][dj] != -1) continue;
				result[di][dj] = result[ci][cj] + 1;
				queue.add(new Node(di, dj));
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
		    for(int j=0; j<m; j++) {
		        if (board[i][j] == 0) {
		            sb.append("0 ");
		        } else {
		            sb.append(result[i][j]).append(" ");
		        }
		    }
		    sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Node{
		int i;
		int j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		public int getI() {
			return i;
		}
		
		public int getJ() {
			return j;
		}
	}
}
