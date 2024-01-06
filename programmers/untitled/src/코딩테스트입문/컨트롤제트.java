package 코딩테스트입문;

public class 컨트롤제트 {
    public int solution(String s) {
        String[] arr = s.split(" ");
        int answer = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("Z")){
                answer -= Integer.valueOf(arr[i-1]);
            }else{
                answer += Integer.valueOf(arr[i]);
            }
        }
        return answer;
    }
}
