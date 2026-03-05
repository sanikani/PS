import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(isConstructor(i, n)){
                System.out.print(i);
                return;
            }
        }
        System.out.print(result);
    }
    
    static boolean isConstructor(int n, int m){
        int sum = n;
        while(n > 0){
            sum += n%10;
            if(sum > m) return false;
            n /= 10;
        }
        
        return sum == m;
    }
}