package 코딩테스트입문;

public class 직사각형넓이구하기 {
    public int solution(int[][] dots) {
        int x =0;
        int y = 0;
        for(int i=1;i<4;i++){
            if(dots[0][0]==dots[i][0]){
                y=Math.abs(dots[0][1]-dots[i][1]);
            }else if(dots[0][1]==dots[i][1]){
                x=Math.abs(dots[0][0]-dots[i][0]);
            }
        }
        return x*y;
    }
}
