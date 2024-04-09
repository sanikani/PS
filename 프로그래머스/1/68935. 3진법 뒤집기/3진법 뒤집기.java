import java.util.*;
class Solution {
    public int solution(int n) {
        int div = 3;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            if(n/div == 0){
                div = div/3;
                int cnt = 0;
                for(int i=1; i<3;i++){
                    if(n-div<0){
                        break;
                    }
                    n = n-div;
                    cnt++;
                }
                sb.append(String.valueOf(cnt));   
            }else{
                div *= 3;
            }
        }
        String answer = sb.toString();
        String arr[] = answer.split("");
        int a = 0;
        for(int i = 0;i<answer.length();i++){
            a += Math.pow(3,i)*Integer.valueOf(arr[i]);
        }
        return a;
    }
}