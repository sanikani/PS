class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4 || s.length()==6){
            try{
                int a = Integer.valueOf(s);
            }catch(NumberFormatException e){
                answer = false;
            }
        }else{
            answer = false;
        }
        return answer;
    }
}