import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int M = Integer.parseInt(br.readLine());
        System.out.println(solution(s, M, br));
        
    }
    
    private static String solution(String s, int M, BufferedReader br)  throws IOException{
        List<Character> str = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            str.add(s.charAt(i));
        }
        ListIterator<Character> cursor = str.listIterator(str.size());
        
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if(c=='L'){
                if(cursor.hasPrevious()) {
                    cursor.previous();
                }
            }else if(c=='D'){
                if(cursor.hasNext()){
                    cursor.next();
                }
            }else if(c=='B'){
                if(cursor.hasPrevious()){
                    cursor.previous();
                    cursor.remove();
                }
            }else{
                char text = st.nextToken().charAt(0);
                cursor.add(text);
            }
        }
        return str.stream().map(String::valueOf).collect(Collectors.joining());
    }
}