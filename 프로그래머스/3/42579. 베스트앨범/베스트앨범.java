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
        list.forEach(g -> 
                     Collections.sort(g.songs, (a, b) -> {
                         if(a.plays == b.plays) return Integer.compare(a.num, b.num);
                         return Integer.compare(b.plays, a.plays);}));

        
        for(int i = 0; i < list.size(); i++){
            List<Song> songs = list.get(i).songs;
            
            answer.add(songs.get(0).num);
            if(songs.size() > 1){
                answer.add(songs.get(1).num);
            }
        }
        
        return  answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Genre{
        String genre;
        int plays;
        List<Song> songs;
        
        Genre(String genre){
            this.genre = genre;
            songs = new ArrayList<>();
        }
        
        void addSong(Song song){
            songs.add(song);
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