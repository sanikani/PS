import java.util.*;
import java.util.stream.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Data> list = new ArrayList<>();
        for(int[] d : data){
            list.add(new Data(d[0],d[1],d[2],d[3]));
        }
        
        list = list.stream()
            .filter(d -> d.getXxx(ext)<val_ext)
            .sorted(Comparator.comparing(d->d.getXxx(sort_by)))
            .collect(Collectors.toList());
        
        int[][] answer = new int[list.size()][4];
        
        for(int i=0;i<list.size();i++){
            answer[i][0] = list.get(i).code;
            answer[i][1] = list.get(i).date;
            answer[i][2] = list.get(i).maximum;
            answer[i][3] = list.get(i).remain;
        }
        
        return answer;
    }
    
    class Data{
        
        int code;
        int date;
        int maximum;
        int remain;
        
        public Data(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
        public int getXxx(String s){
            if(s.equals("code")){
                return code;
            }else if(s.equals("date")){
                return date;
            }else if(s.equals("maximum")){
                return maximum;
            }else{
                return remain;
            }
        }
        
    }
}