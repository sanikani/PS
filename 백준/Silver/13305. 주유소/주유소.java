import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] length = new long[N-1];
		long[] price = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		long totalPrice = 0;
		for(int i=0; i<N-1; i++) {
			totalPrice += price[i]*length[i];
			long curPrice = price[i];
			int index = i+1;
			
			while(index<N-1) {
				if (curPrice<price[index]) {
					totalPrice += curPrice*length[index];
					index++;
					i++;
				}else {
					break;
				}
			}
		}
		System.out.println(totalPrice);
	}

}