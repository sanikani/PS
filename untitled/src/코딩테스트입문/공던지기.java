package 코딩테스트입문;

public class 공던지기 {
    public int solution(int[] numbers, int k) {
        if((k*2-1)%numbers.length==0){
            return numbers.length;
        }
        return (k*2-1)%numbers.length;

    }
}
