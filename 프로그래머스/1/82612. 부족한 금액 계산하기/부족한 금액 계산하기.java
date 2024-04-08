class Solution {
    public long solution(int price, int money, int count) {
        long sum = (long)price*(count*(count+1)/2);
        if(sum>money) return sum-money;
        return 0;
    }
}