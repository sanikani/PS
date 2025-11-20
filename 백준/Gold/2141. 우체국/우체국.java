import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] cities = new int[N][2];
		long cnt = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int a = Integer.parseInt(stringTokenizer.nextToken());
			cnt += a;
			cities[i][0] = x;
			cities[i][1] = a;
		}
		long center = (cnt+1)/2;
		Arrays.sort(cities, (a,b)->a[0]-b[0]);
		int result = 0;
		long sum = 0;
		for(int i=0; i<N; i++) {
			sum+=cities[i][1];
			if (sum>=center) {
				result = cities[i][0];
				break;
			}
		}
		System.out.println(result);
	}

}