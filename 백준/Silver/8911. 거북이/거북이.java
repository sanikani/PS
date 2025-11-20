import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	//상, 우, 하, 좌  순서로 돌아가게
	static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			
			int xMax = 0;
			int xMin = 0;
			int yMax = 0;
			int yMin = 0;
			int index = 0;
			int[] d = direction[index];
			int x = 0;
			int y = 0;
			//0, 1, 2, 3
			String command = br.readLine();
			for(int i=0; i<command.length(); i++){
				char nextCommand = command.charAt(i);
				if (nextCommand=='L') {
					index--;
					if (index<0) {
						index = 3;
					}
					d = direction[index];
				}else if (nextCommand=='R') {
					index++;
					if (index>3) {
						index = 0;
					}
					d = direction[index];
				}else if (nextCommand=='F') {
					x += d[0];
					y += d[1];
					xMax = Math.max(xMax, x);
					xMin = Math.min(xMin, x);
					yMax = Math.max(yMax, y);
					yMin = Math.min(yMin, y);
				}else {
					x -= d[0];
					y -= d[1];
					xMax = Math.max(xMax, x);
					xMin = Math.min(xMin, x);
					yMax = Math.max(yMax, y);
					yMin = Math.min(yMin, y);
				}
			}
			System.out.println(Math.abs(xMax-xMin)*Math.abs(yMax-yMin));
		}

	}

}