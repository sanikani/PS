class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String word : babbling){
            word = word.replaceAll("aya","1");
            word = word.replaceAll("ye","2");
            word = word.replaceAll("woo","3");
            word = word.replaceAll("ma","4");
            boolean isCount = true;
            if(word.length()==1){
                if(!Character.isDigit(word.charAt(0))) isCount = false;
            }
            for(int i=0;i<word.length()-1;i++){
                if(Character.isDigit(word.charAt(i))){
                    if(word.charAt(i)==word.charAt(i+1)){
                        isCount = false;
                        break;
                    } 
                    else if(Character.isAlphabetic(word.charAt(i+1))){
                        isCount = false;
                        break;
                    }
                }else{
                    isCount = false;
                    break;
                }
            }
            if(isCount) answer++;
        }
        
        return answer;
    }
}