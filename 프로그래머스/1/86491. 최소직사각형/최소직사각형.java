class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int Xmax = Integer.MIN_VALUE;
        int Ymax = Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][1]>sizes[i][0]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            Xmax = Math.max(sizes[i][0],Xmax);
            Ymax = Math.max(sizes[i][1],Ymax);
        }
        
        return Xmax*Ymax;
    }
}