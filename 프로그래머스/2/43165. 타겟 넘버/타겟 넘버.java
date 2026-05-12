class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    void dfs(int[] numbers, int target, int sum, int l){
        if(l == numbers.length){
            if(sum == target){
                answer++;            
            }
            return;
        }
        dfs(numbers, target, sum + numbers[l], l + 1);
        dfs(numbers, target, sum - numbers[l], l + 1);
    }
}