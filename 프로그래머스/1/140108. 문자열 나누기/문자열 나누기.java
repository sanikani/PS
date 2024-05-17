class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1){
                answer++;
                break;
            }
            char x = s.charAt(i);
            int a = 1;
            int b = 0;
            while(a!=b){
                if(x==s.charAt(i+1)) a++;
                else b++;
                i++;
                if(i==s.length()-1){
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}