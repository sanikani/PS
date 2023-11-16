package 코딩테스트입문;

public class 합성수찾기 {
    public int solution(int n) {
        int answer = 0;
        if(n<4){
            return 0;
        }
        for(int i=4;i<=n;i++){
            if(isComposite(i)){
                answer++;
            }
        }

        return answer;
    }

    public boolean isComposite(int n){
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                cnt++;
                System.out.println("i: "+i+" cnt: "+cnt);
            }
        }
        if(cnt>=3){
            return true;
        }

        return false;

    }

}
