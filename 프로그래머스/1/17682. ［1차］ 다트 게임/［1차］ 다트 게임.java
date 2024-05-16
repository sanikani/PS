import java.util.*;
class Solution {
    public int solution(String dartResult) {
        dartResult = dartResult.replace("10","K").replace("S","1").replace("D","2").replace("T","3");
        double[] scores = new double[100];
        int index = 0;
        
        for(int i=0;i<dartResult.length();i++){
            char cur = dartResult.charAt(i);
            
            if(Character.isDigit(cur)||cur=='K'){
                int x = cur-'0';
                if(cur == 'K') x = 10;
                int y = dartResult.charAt(++i) - '0';
                scores[index++] = Math.pow(x,y);
            }else{
                if(cur=='*'){
                    if(index == 1){
                        scores[index-1] = scores[index-1]*2;
                    }else{
                        scores[index-1] = scores[index-1]*2;
                        scores[index-2] = scores[index-2]*2;
                    }
                }else{
                    scores[index-1] = scores[index-1]*(-1);
                }
            }
        }
        
        int answer = 0;
        
        for(double x : scores){
            answer += x;
        }
        
        return answer;
    }
}