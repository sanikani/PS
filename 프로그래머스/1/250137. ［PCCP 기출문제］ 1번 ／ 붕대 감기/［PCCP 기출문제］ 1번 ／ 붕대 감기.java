class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int max = health;
        for(int i=0;i<attacks.length;i++){
            
            health += (attacks[i][0]-time-1)*bandage[1];
            System.out.println((attacks[i][0]-time-1)*bandage[1]+" 회복");
            if(attacks[i][0]-time>bandage[0]){
                health += ((attacks[i][0]-time-1)/bandage[0])*bandage[2];
                System.out.println(((attacks[i][0]-time-1)/bandage[0])*bandage[2]+" 추가 회복");
            }
            if(health>max) health = max;
            health -= attacks[i][1];
            System.out.println(attacks[i][1]+" 공격");
            if(health<=0) return -1;
            time = attacks[i][0];
            System.out.println(health+"현재체력, 시간"+time);
        }
        
        return health;
    }
    
}