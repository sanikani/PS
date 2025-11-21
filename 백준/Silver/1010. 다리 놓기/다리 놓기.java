import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bReader.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int M = Integer.parseInt(stringTokenizer.nextToken());
			int[][] arr = new int[M+1][N+1];
			for(int j=0; j<=M; j++) {
			    arr[j][0] = 1;
			}
			for(int j=1; j<=M; j++) {
			    for(int k=1; k<=N; k++) {
			        arr[j][k] = arr[j-1][k] + arr[j-1][k-1];
			    }
			}
			System.out.println(arr[M][N]);
		}
	}

}