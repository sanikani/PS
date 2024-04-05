class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len-4;i++){
            sb.append("*");
        }
        for(int i=len-4;i<len;i++){
            sb.append(phone_number.charAt(i));
        }
        return sb.toString();
    }
}