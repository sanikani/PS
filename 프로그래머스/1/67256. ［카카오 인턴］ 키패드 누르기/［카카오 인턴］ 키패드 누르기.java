import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(num == 1 || num == 4 || num==7){
                left = num;
                sb.append("L");
            }else if(num == 3 || num == 6 || num==9){
                right = num;
                sb.append("R");
            }else{                
                if(num == 0){
                    num = 11;
                }
                int leftD = Math.abs(left-num)/3 + Math.abs(left-num)%3;
                int rightD = Math.abs(right-num)/3 + Math.abs(right-num)%3;
                if(leftD>rightD){
                    right = num;
                    sb.append("R");
                }else if(leftD<rightD){
                    left = num;
                    sb.append("L");
                }else{
                    if(hand.equals("left")){
                        left = num;
                        sb.append("L");
                    }else{
                        right = num;
                        sb.append("R");
                    }
                }
            }
        }
        return sb.toString();
    }
}