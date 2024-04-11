class Solution {
    public int solution(int[][] sizes) {
        int Xmax = Integer.MIN_VALUE;
        int Ymax = Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++){
            Xmax = Math.max(Math.max(sizes[i][0],sizes[i][1]),Xmax);
            Ymax = Math.max(Math.min(sizes[i][0],sizes[i][1]),Ymax);
        }
        
        return Xmax*Ymax;
    }
}