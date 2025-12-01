import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] nameMap = new String[N+1];
        Map<String, Integer> numberMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            nameMap[i] = name;
            numberMap.put(name, i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))){
                sb.append(nameMap[Integer.parseInt(s)]).append('\n');
            }else{
                sb.append(numberMap.get(s)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
