import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                if(s.charAt(i)==')'){
                    return false;
                }
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }else{
                stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
