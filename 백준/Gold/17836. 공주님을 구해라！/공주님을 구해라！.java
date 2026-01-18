import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] di = {1,0,-1,0};
        int[] dj = {0,-1,0,1};
        
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        boolean[][] visitedWithS = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        int time = 0;
        int min = 0;
        visited[0][0] = true;
        while(!q.isEmpty()){
            time++;
            if(time>T) break;
            int len = q.size();
            for(int i=0; i<len; i++){
                int[] info = q.poll();
                for(int j=0; j<4; j++){
                    int ni = info[0] + di[j];
                    int nj = info[1] + dj[j];
                    if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
                    if(ni==N-1 && nj==M-1){
                        min = time;
                        System.out.print(min);
                        return;
                    }
                	if(map[ni][nj]==1) {
                    	if(info[2]==0) continue;
                    	else {
                    		if (!visitedWithS[ni][nj]) {
                    			q.add(new int[]{ni, nj, 1});
                    			visitedWithS[ni][nj] = true;
							}
                    	}
                    }else {
                    	if(map[ni][nj]==2 || info[2]==1) {
                    		if(!visitedWithS[ni][nj]) {
                    			q.add(new int[]{ni, nj, 1});
                                visitedWithS[ni][nj] = true;
                    		}
                    	}else {
                    		if (!visited[ni][nj]) {
                    			q.add(new int[]{ni, nj, 0});
                                visited[ni][nj] = true;
							}
                    	}
                    }
                }
            }
        }
        System.out.print("Fail");
    }
}