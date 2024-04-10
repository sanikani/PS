class Solution {
    static int sum=0;
    static int answer = 0;
    static int[] ch;
    public int solution(int[] number) {
        ch = new int[number.length];
        DFS(number, 0);
        return answer/6;
    }
    public void DFS(int[] number, int l){
        if(l==3){
            if(sum==0) answer++;
        }
        else{
            for(int i=0;i<number.length;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    sum+=number[i];
                    DFS(number,l+1);
                    ch[i]=0;
                    sum-=number[i];
                }
            }
        }
    }
}