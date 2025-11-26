import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(solution(N, K));
    }
    
    private static String solution(int N, int K){
        List<Integer> people = new LinkedList<>();
        for(int i=1; i<=N; i++){
            people.add(i);
        }
        List<Integer> deletedPeople = new ArrayList<>();
        ListIterator cursor = people.listIterator(0);
        int cnt = 0;
        while(!people.isEmpty()){
            cnt++;
            if(!cursor.hasNext()){
                cursor = people.listIterator(0);
            }
            
            int num = (int)cursor.next();
            
            if(cnt==K){
                cursor.remove();
                cnt=0;
                deletedPeople.add(num);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int p : deletedPeople){
            sb.append(p).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        return sb.toString();
    }
}