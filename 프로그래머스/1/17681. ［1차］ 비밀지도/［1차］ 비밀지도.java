
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            StringBuilder sb = new StringBuilder();
            
            for(int k = 0; k < n-a.length();k++){
                sb.append(0);
            }
            sb.append(a);
            a = sb.toString();
            sb.setLength(0);
            
            for(int k = 0; k < n-b.length();k++){
                sb.append(0);
            }
            sb.append(b);
            b = sb.toString();
            sb.setLength(0);
            
            for(int j=0;j<n;j++){
                if(a.charAt(j)=='0' && b.charAt(j)=='0'){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}