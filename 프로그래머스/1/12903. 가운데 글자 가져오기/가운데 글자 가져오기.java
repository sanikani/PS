class Solution {
    public String solution(String s) {
        int mid = s.length()/2;
        
        String answer = "";
        if(s.length()%2==1){
            answer += s.charAt(mid);
            return answer;
        }
        answer+=s.charAt(mid-1);
        answer += s.charAt(mid);
        return answer;
    }
}