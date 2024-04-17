class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int a = 0;
        int b = 0;
        for(String x : goal){
            if(a<cards1.length && cards1[a].equals(x)) a++;
            else if(b<cards2.length && cards2[b].equals(x)) b++;
            else return "No";
        }
        return "Yes";
    }
}