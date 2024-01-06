package section01;

import java.util.Scanner;

public class 문자찾기 {
    public int solution(String input1, char input2) {
        int answer = 0;
        input1 = input1.toLowerCase();
        input2 = Character.toLowerCase(input2);
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2) answer++;
        }
        return answer;
    }
    public static void main(String[] args){
        문자찾기 x = new 문자찾기();
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        char input2 = in.nextLine().charAt(0);
        System.out.println(x.solution(input1,input2));
    }
}