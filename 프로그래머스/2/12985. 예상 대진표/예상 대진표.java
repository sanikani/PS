class Solution
{   
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(a!=b){
            int x = (a+1)/2;
            int y = (b+1)/2;
            if(x==y) return answer;
            else{
                a = x;
                b = y;
                answer++;
            }
        }
        return answer;
    }
}