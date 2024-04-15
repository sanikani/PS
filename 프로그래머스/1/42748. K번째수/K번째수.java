import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; 
        int c=0;
        for(int[] arr : commands){
            int[] a = new int[arr[1]-arr[0]+1];
            int cnt = 0;
            for(int i=arr[0]-1;i<=arr[1]-1;i++){
                a[cnt++] = array[i];
            }
            Arrays.sort(a);
            answer[c++] = a[arr[2]-1];
        }
        return answer;
    }
}