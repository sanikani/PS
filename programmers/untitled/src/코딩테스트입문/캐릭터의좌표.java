package 코딩테스트입문;

public class 캐릭터의좌표 {
    public int[] solution(String[] keyInput, int[] board) {
        int x = 0;
        int y = 0;
        int[] answer = {0,0};
        for(String input : keyInput){
            if(input.equals("left")){
                if(!(answer[0] <= -board[0] / 2)){
                    answer[0]--;
                }
            }else if(input.equals("right")){
                if(!(answer[0]>=(board[0]/2))){
                    answer[0]++;
                }
            }else if(input.equals("up")){
                if(!(answer[1]>=(board[1]/2))){
                    answer[1]++;
                }
            }else{
                if(!(answer[1]<=-1*(board[1]/2))){
                    answer[1]--;
                }
            }
        }
        return answer;
    }
}
