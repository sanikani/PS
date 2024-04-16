class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int a = 0;
        int b = 0;
        for(String x : goal){
            if(a<cards1.length && b<cards2.length){
                System.out.println(cards1[a]+" "+cards2[b]+" "+x);
                if(cards1[a].equals(x)) a++;
                else if(cards2[b].equals(x)) b++;
                else return "No";
            }else if(a>=cards1.length){
                System.out.println(cards2[b]+" "+x);
                if(cards2[b].equals(x)) b++;
                else return "No";
            }else if(b>=cards2.length){
                System.out.println(cards1[a]+" "+x);
                if(cards1[a].equals(x)) a++;
                else return "No";
            }
            
        }
        return "Yes";
    }
}