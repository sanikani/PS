package section02;

import java.util.*;

public class 에라토스테네스의체 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution2(n));
    }

    public static int solution(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime(i)) {
                for (int j = i+1; j <= n; j++) {
                    if(j%i==0) set.add(j);
                }
            }
        }
        return n-set.size()-1;
    }

    public static boolean isPrime(int x) {
        if(x==2) return true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static int solution2(int n) {
        int[] arr = new int[n+1];
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) arr[j]=1;
            }
        }
        return answer;
    }
}
