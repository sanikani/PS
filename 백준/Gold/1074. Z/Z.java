import java.util.Scanner;

public class Main {
	static int cnt;
	static int r;
	static int c;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		cnt = 0;
		int len = (int) Math.pow(2, N);
		solution(0, 0, len - 1, len - 1, len);
		System.out.println(cnt);
	}

	private static void solution(int sR, int sC, int eR, int eC, int len) {
		if (flag) return;
		
		if(r < sR || r > eR || c < sC || c > eC) {
			cnt += len * len;
			return;
		}
		
		if (len == 2) {
			int a = c - sC;
	        int b = r - sR;
	        cnt += b * 2 + a;
	        flag = true;
	        return;
		}
		
		int nextLen = len / 2;
		solution(sR, sC, sR + nextLen - 1, sC + nextLen - 1, nextLen);
		solution(sR, sC + nextLen, sR + nextLen - 1, eC, nextLen);
		solution(sR + nextLen, sC, eR, sC + nextLen - 1, nextLen);
		solution(sR + nextLen, sC + nextLen, eR, eC, nextLen);
	}
}
