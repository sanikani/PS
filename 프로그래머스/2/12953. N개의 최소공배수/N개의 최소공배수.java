import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            arr[i+1] = arr[i]*arr[i+1]/GCD(arr[i],arr[i+1]);
        }
        
        return arr[arr.length-1];
    }
    public int GCD(int x, int y){
        for(int i=x;i>0;i--){
            if(x%i==0&&y%i==0){
                return i;
            }
        }
        return 1;
    }
}