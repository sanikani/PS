import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] pos = new int[26];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                pos[Integer.parseInt(st.nextToken())] =  i * 5 + j;
            }
        }

        int[] ver = new int[5];
        int[] hor = new int[5];
        int[] cross = new int[2];
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int idx = pos[Integer.parseInt(st.nextToken())];

                int row = idx / 5;
                ver[row]++;
                int col = idx % 5;
                hor[col]++;
                if (ver[row] == 5) cnt++;
                if (hor[col] == 5) cnt++;
                if (row == col){
                    cross[0]++;
                    if(cross[0] == 5)cnt++;
                }
                if (row + col == 4){
                    cross[1]++;
                    if(cross[1] == 5)cnt++;
                }
                if (cnt >= 3){
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }
    }
}
