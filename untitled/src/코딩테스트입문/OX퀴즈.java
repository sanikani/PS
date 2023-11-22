package 코딩테스트입문;

public class OX퀴즈{
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length;i++){
            String[] arr = quiz[i].split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[2]);
            if(arr[1].equals("-")){
                if(x-y==Integer.parseInt(arr[4])){
                    answer[i]="O";
                }else{
                    answer[i]="X";
                }
            }else{
                if(x+y==Integer.parseInt(arr[4])){
                    answer[i]="O";
                }else{
                    answer[i]="X";
                }
            }
        }
        return answer;
    }
    //리팩토링
    public String[] solution2(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");

            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[2]);

            int result = (arr[1].equals("-")) ? x - y : x + y;

            answer[i] = (result == Integer.parseInt(arr[4])) ? "O" : "X";
        }

        return answer;
    }
}

