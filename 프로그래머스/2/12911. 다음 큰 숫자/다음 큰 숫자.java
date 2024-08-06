
class Solution {
    public int solution(int n) {
        int x = Integer.bitCount(n);
        while(true){
            int y = Integer.bitCount(++n);
            
            if(x==y) break;
        }
        return n;
    }
}