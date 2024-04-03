class Solution {
    public boolean solution(int x) {
        int sum = 0;
        for(String a : String.valueOf(x).split("")){
            sum += Integer.parseInt(a);
        }
        if(x%sum==0) return true;
        return false;
    }
}