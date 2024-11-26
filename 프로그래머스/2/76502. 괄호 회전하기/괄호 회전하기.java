import java.util.*;
import java.util.stream.*;
class Solution {
    static List<String> left = List.of("(","[","{");
    static List<String> right = List.of(")","]","}");
    public int solution(String s) {
        int answer = 0;
        List<String> list = Stream.of(s.split("")).collect(Collectors.toList());
        for(int i=0;i<s.length();i++){
            if(check(list,i,s.length())) answer++;
            list.add(list.get(i));
        }
        return answer;
    }
    
    public boolean check(List<String> list, int startIndex, int size){
        Stack<String> stack = new Stack<>();
        stack.push(list.get(startIndex));
        for(int i=startIndex+1;i<startIndex+size;i++){
            String s = list.get(i);
            if(left.contains(s)){
                stack.push(s);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(right.indexOf(s)!=left.indexOf(stack.peek())){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }
            
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}