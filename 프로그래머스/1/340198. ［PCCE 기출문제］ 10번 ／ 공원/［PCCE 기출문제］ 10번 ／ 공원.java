import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int dx[] = {0,-1,-1};
        int dy[] = {-1,0,-1};
        List<Integer> list = Arrays.stream(mats).boxed().collect(Collectors.toList());
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                int min = Integer.MAX_VALUE;
                if(!isNumeric(park[i][j])){
                    continue;
                }
                if(i==0||j==0){
                    park[i][j] = "1";
                    if(list.contains(1)){
                        answer = Math.max(answer, 1);
                    }
                    continue;
                }
                int cnt = 0;
                for(int k=0;k<3;k++){
                    if(isNumeric(park[i+dx[k]][j+dy[k]])){
                        min = Math.min(min,Integer.parseInt(park[i+dx[k]][j+dy[k]]));
                        cnt++;
                    }else{
                        park[i][j] = "1";
                        break;
                    }
                }
                if(cnt==3){
                    park[i][j]=String.valueOf(++min);
                    if(list.contains(min)){
                        answer = Math.max(answer, min);
                    }
                }
            }
        }
        
        return answer;
    }
    
    boolean isNumeric(String target) {
        try{
            Integer.parseInt(target);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}