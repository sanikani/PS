import java.util.*;
class Solution {
    public String solution(String s, int n) {
        char arr[] = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char x = arr[i];
            if(x>=97 && x<=122){
                int k = ((x+n)-97)%26+97;
                arr[i] = (char)k;
                System.out.println(k);
            }else if(x>=65&&x<=90){
                int z = ((x+n)-65)%26+65;
                arr[i] = (char)z;
            }
        }
        return new String(arr);
    }
}