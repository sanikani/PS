class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] arr = binomial.split(" ");
        int a = Integer.parseInt(arr[0]);
        String k = arr[1];
        int b = Integer.parseInt(arr[2]);
        
        if(k.equals("+")){
            return a + b;
        }if(k.equals("-")){
            return a - b;
        }else{
            return a * b;
        }
    }
}