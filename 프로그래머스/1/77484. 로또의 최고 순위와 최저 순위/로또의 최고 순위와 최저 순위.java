class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 7;
        int cntZero = 0;
        int[] answer = new int[2];
        
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                cntZero++;
                continue;
            }
            for(int j=0;j<lottos.length;j++){
                if(lottos[i]==win_nums[j]) cnt--;
            }
        }
        
        if(cnt==7) cnt = 6;
        if(cnt-cntZero==0) answer[0] = 1;
        else answer[0] = cnt-cntZero;
        answer[1] = cnt;
        return answer;
        
    }
}