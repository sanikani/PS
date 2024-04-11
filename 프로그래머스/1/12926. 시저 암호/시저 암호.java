import java.util.*;
class Solution {
    public String solution(String s, int n) {
        char arr[] = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char x = arr[i];
            if(x>=97 && x<=122){
                arr[i] = (char)(((x+n)-97)%26+97);
            }else if(x>=65&&x<=90){
                arr[i] = (char)(((x+n)-65)%26+65);
            }
        }
        return new String(arr);
    }
}