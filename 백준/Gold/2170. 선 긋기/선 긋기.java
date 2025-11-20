import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(st.nextToken());
			lines[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(lines, (a, b) -> {
		    if (a[0] != b[0]) {
		        return a[0] - b[0];
		    }
		    return a[1] - b[1];
		});
		int start = lines[0][0];
		int end = lines[0][1];
		int sum = end - start;
		for(int i=1; i<N; i++) {
			int nowStart = lines[i][0];
			int nowEnd = lines[i][1];
			if (nowStart < end) {
				if (nowEnd > end) {
		            sum += nowEnd - end;
		            end = nowEnd;
		        }
			}else {
				sum += nowEnd - nowStart;
				end = nowEnd;
			}
		}
		System.out.println(sum);
	}

}