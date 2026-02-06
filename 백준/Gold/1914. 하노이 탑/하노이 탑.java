import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(BigInteger.TWO.pow(n).subtract(BigInteger.ONE));
		if(n <= 20) hanoi(n, 1, 2, 3);
		bw.flush();
		sc.close();
	}
	
	static void hanoi(int n, int from, int mid, int to) throws IOException {
		if(n==1) {
			bw.write(from + " " + to + "\n");
			return;
		}

		hanoi(n - 1, from, to, mid);
		bw.write(from + " " + to + "\n");
		hanoi(n - 1, mid, from, to);
	}
}
