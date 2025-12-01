import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='X'){
                cnt++;
            }else{
                if(cnt%2!=0){
                    System.out.println("-1");
                    return;
                }else if(cnt==0){
                    sb.append(".");
                }else{
                    int aCount = cnt/4;
                    for(int j=0; j<aCount; j++){
                        sb.append("AAAA");
                    }
                    if(cnt%4!=0){
                        sb.append("BB");
                    }
                    sb.append(".");
                }
                cnt = 0;
            }
        }
        
        if(cnt!=0){
            if(cnt%2!=0){
                    System.out.println("-1");
                    return;
            }else{
                int aCount = cnt/4;
                for(int j=0; j<aCount; j++){
                    sb.append("AAAA");
                }
                if(cnt%4!=0){
                    sb.append("BB");
                }
            }
        }
        
        if(sb.length()==0){
            System.out.println("-1");
        }else{
            System.out.println(sb.toString());
        }
    }
}