import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(cnt==3){
                sb.append(sum);
                cnt = 0;
                sum = 0;
            }
            if(s.charAt(i)!='0'){
                sum += Math.pow(2, cnt);
            }
            cnt++;
        }
        if(cnt>0){
            sb.append(sum);
        }
        System.out.println(sb.reverse().toString());
    }
}