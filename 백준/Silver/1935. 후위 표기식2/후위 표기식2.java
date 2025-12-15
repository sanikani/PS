import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] arr = new double[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isAlphabetic(c)){
                stack.push(arr[(str.charAt(i)-'A'+1)]);
            }else{
                double a = stack.pop();
                double b = stack.pop();
                if(c == '+'){
                    stack.push(b+a);
                }else if(c == '-'){
                    stack.push(b-a);
                }else if(c == '*'){
                    stack.push(b*a);
                }else if(c == '/'){
                    stack.push(b/a);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}