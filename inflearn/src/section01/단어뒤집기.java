package section01;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {
    public static String[] solution(int n, String[] str) {
        String[] answer = new String[n];
        int idx = 0;
        for (String x : str) {
            String tmp = "";
            for (int i = x.length() - 1; i >= 0; i--) {
                tmp += x.charAt(i);
            }
            answer[idx++] = tmp;
        }
        return answer;
    }

    public static ArrayList<String> solution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public static String reverse(String[] str) {
        String tmp = "";
        for (String s : str) {
            char[] a = s.toCharArray();
            int lt = 0, rt = s.length()-1;
            while (lt < rt) {
                char t = a[rt];
                a[rt] = a[lt];
                a[lt] = t;
                lt++;
                rt--;
            }
            tmp = String.valueOf(a);
        }
        return tmp;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }
        for (String x : solution(n, str)) {
            System.out.println(x);
        }
        return ;
    }
}