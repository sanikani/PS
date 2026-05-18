import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Genre> map = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++){
            if(!map.containsKey(genres[i])){
                Genre genre = new Genre(genres[i]);
                genre.addSong(new Song(i, plays[i]));
                map.put(genres[i], genre);
            }else{
                map.get(genres[i]).addSong(new Song(i, plays[i]));
            }
        }
        
        List<Genre> list = new ArrayList<>(map.values());
        
        Collections.sort(list, (a, b) -> Integer.compare(b.plays, a.plays));
        

        
        for(int i = 0; i < list.size(); i++){
            PriorityQueue<Song> songs = list.get(i).songs;
            
            for(int k = 0; k < 2; k++){
                if(!songs.isEmpty()){
                    answer.add(songs.poll().num);
                }
            }
        }
        
        return  answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Genre{
        String genre;
        int plays;
        PriorityQueue<Song> songs;
        
        Genre(String genre){
            this.genre = genre;
            songs = new PriorityQueue<>((a, b) -> {
                if(a.plays == b.plays) return Integer.compare(a.num, b.num);
                return Integer.compare(b.plays, a.plays);
            });
        }
        
        void addSong(Song song){
            songs.offer(song);
            plays += song.plays;
        }
    }
    
    class Song{
        int num;
        int plays;
        
        Song(int num, int plays){
            this.num = num;
            this.plays = plays;
        }
    }
}