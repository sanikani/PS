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
                System.out.print(a + " ");
            }
            System.out.println();
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
                    System.out.println("이동 실패");
                    continue;
                }
                for(int j=Math.min(answer[0],nx);j<=Math.max(answer[0],nx);j++){
                    System.out.println("좌표 확인 " + j + ", " + answer[1] + "=" + map[j][answer[1]]);
                    if(map[j][answer[1]]==1) {
                        move = false;
                        System.out.println("이동 실패");
                        break;
                    }
                }
            }else{
                if(ny<0 || ny>=w){
                    move = false;
                    System.out.println("이동 실패");
                    continue;
                } 
                for(int j=Math.min(answer[1],ny);j<=Math.max(answer[1],ny);j++){
                    System.out.println("좌표 확인 " + answer[0] + ", " + j + "=" + map[j][answer[1]]);
                    if(map[answer[0]][j]==1) {
                        move = false;
                        System.out.println("이동 실패");
                        break;
                    }
                }
            }
            if(move){
                    answer[0] = nx;
                    answer[1] = ny;
                    System.out.println("이동 완료 " + answer[0] + "," + answer[1]);
                }
        }
        return answer;
    }
}