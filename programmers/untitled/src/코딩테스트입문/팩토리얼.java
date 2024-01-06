package 코딩테스트입문;

public class 팩토리얼 {
    public int solution(int n) {
        int fac = 1;
        for(int i=1;i<=10;i++){
            fac *= i;
            if(fac==n){
                return i;
            }
            if(fac>n){
                return i-1;
            }
        }
        return fac;
    }
}
