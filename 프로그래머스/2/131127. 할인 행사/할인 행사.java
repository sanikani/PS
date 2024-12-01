import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wantList = List.of(want);
        int[] answerCnt = new int[number.length];
        for(int i=0;i<10;i++){
            if(wantList.contains(discount[i])){
                answerCnt[wantList.indexOf(discount[i])]++;
            }
        }
        if(check(answerCnt, number)) answer++;
        for(int i=10;i<discount.length;i++){
            if(wantList.contains(discount[i-10])){
                answerCnt[wantList.indexOf(discount[i-10])]--;
            }
            if(wantList.contains(discount[i])){
                answerCnt[wantList.indexOf(discount[i])]++;
            }
            if(check(answerCnt, number)) answer++;
        }
        return answer;
    }
    
    public boolean check(int[] answerCnt, int[] number){
        for(int i=0; i<number.length;i++){
            if(answerCnt[i] != number[i]){
                return false;
            }
        }
        return true;
    }
}