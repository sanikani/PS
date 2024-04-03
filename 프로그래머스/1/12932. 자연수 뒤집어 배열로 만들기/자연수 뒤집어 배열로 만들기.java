class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        int[] answer = new int[num.length()];
        int idx = num.length()-1;
        for(String x : num.split("")){
            answer[idx--] = Integer.parseInt(x);
        }
        return answer;
    }
}