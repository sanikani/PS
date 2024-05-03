class Solution {
    static int result = 0;
    static int cnt = 0;
    static int[] ch;
    public int solution(int[] nums) {
        ch = new int[nums.length];
        DFS(0,0,nums);
        return result;        
    }
    
    public void DFS(int l,int sum, int[] nums){
        if(cnt==3){
            for(int i=0;i<ch.length;i++){
                if(ch[i]==1) System.out.print(i+" ");
            }
            if(isPrime(sum)) result++;
        }else{
            for(int i=l;i<nums.length;i++){
                cnt++;
                DFS(i+1,sum+nums[i],nums);
                cnt--;
            }
        }
    }
    
    public boolean isPrime(int a){
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0) return false;
        }
            return true;
        
    }
}