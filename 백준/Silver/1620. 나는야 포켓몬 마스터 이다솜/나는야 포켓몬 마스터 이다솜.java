import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> nameMap = new HashMap<>();
        Map<String, Integer> numberMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            nameMap.put(i, name);
            numberMap.put(name, i);
        }
        for(int i=0; i<M; i++){
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))){
                System.out.println(nameMap.get(Integer.parseInt(s)));
            }else{
                System.out.println(numberMap.get(s));
            }
        }
    }
}
