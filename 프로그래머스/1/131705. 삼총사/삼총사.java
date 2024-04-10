class Solution {
    static int sum=0;
    static int answer = 0;
    public int solution(int[] number) {
        DFS(number,0, 0);
        return answer;
    }
    public void DFS(int[] number,int s, int l){
        if(l==3){
            if(sum==0) answer++;
        }
        else{
            for(int i=s;i<number.length;i++){
                sum+=number[i];
                DFS(number,i+1,l+1);
                sum-=number[i];
            }
        }
    }
}