class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=3;i<2500;i++){
            for(int j = 3; j<=i;j++){
                if((i*2+j*2-4)==brown && (i*j-brown)==yellow) return new int[]{i,j};
            }
        }
        return new int[]{0,0};
    }
}