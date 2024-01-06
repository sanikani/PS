package 코딩테스트입문;

public class 다항식더하기 {
    public String solution(String polynomial) {
        polynomial = polynomial.replace("+","");
        String[] polyArr = polynomial.split("  ");
        int xCoef = 0;
        int constant = 0;
        for(String x : polyArr){
            if(x.contains("x")){
                if(x.length()>=2){
                    x = x.replace("x","");
                    xCoef += Integer.valueOf(x);
                }else{
                    xCoef++;
                }
            }else{
                constant += Integer.valueOf(x);
            }
        }

        String answer = "";
        if(xCoef!=0 && constant!=0){
            if(xCoef==1){
                answer = "x"+" + "+constant;
            }else{
                answer = xCoef+"x"+" + "+constant;
            }
        }else if(xCoef==0 && constant!=0){
            answer += constant;
        }else if(xCoef!=0 && constant==0){
            if(xCoef==1){
                answer = "x";
            }else{
                answer = xCoef+"x";
            }

        }
        return answer;
    }
}
