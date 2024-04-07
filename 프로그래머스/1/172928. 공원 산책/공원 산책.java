import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int[][] map = new int[h][w];
        int[] answer = new int[2];
        for(int i=0;i<h;i++){
            for(int j=0; j<w;j++){
                if(park[i].charAt(j)=='X') map[i][j] = 1;
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        for(int[] arr : map){
            for(int a : arr){
            }
        }
        Map<String, int[]> r = new HashMap<>();
        r.put("E", new int[] {0,1});
        r.put("S", new int[] {1,0});
        r.put("W", new int[] {0,-1});
        r.put("N", new int[] {-1,0});
        
        
        for(int i=0;i<routes.length;i++){
            String[] tmp = routes[i].split(" ");
            int[] route = r.get(tmp[0]);
            int nx = answer[0] + route[0]*Integer.valueOf(tmp[1]);
            int ny = answer[1] + route[1]*Integer.valueOf(tmp[1]);
            boolean move = true;
            if(nx != answer[0]){
                if(nx<0 || nx>=h) {
                    move = false;
                    continue;
                }
                for(int j=Math.min(answer[0],nx);j<=Math.max(answer[0],nx);j++){
                    if(map[j][answer[1]]==1) {
                        move = false;
                        break;
                    }
                }
            }else{
                if(ny<0 || ny>=w){
                    move = false;
                    continue;
                } 
                for(int j=Math.min(answer[1],ny);j<=Math.max(answer[1],ny);j++){
                    if(map[answer[0]][j]==1) {
                        move = false;
                        break;
                    }
                }
            }
            if(move){
                    answer[0] = nx;
                    answer[1] = ny;
                }
        }
        return answer;
    }
}