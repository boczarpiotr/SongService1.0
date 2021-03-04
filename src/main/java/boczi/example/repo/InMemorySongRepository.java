package boczi.example.repo;

import boczi.example.Song;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class InMemorySongRepository implements SongRepository {

   private HashMap<Song, Integer> mapOfSongs = new HashMap<>();

   public HashMap<Song , Integer> getMap(){
       return mapOfSongs;
   }


    @Override
    public void voteForSong(Song song, int vote) {
        if (!(mapOfSongs.containsKey(song))) {
            System.out.println("This song is not present in our List. Please add it");
        } else {
            mapOfSongs.put(song, (mapOfSongs.get(song) + vote));
        }
    }

    @Override
    public void addSong(Song song, int vote) {
        if (mapOfSongs.containsKey(song)){
            mapOfSongs.put(song, (mapOfSongs.get(song) + vote));
        }
        mapOfSongs.put(song, vote);
    }

    @Override
    public void deleteVotesBySong(Song song) {
        mapOfSongs.put(song , 0);
    }

    @Override
    public void deleteAllVotes() {
        for(Song song: mapOfSongs.keySet()){
            mapOfSongs.put(song , 0);
        }
    }

    @Override
    public List<Song> getAllSongs() {
        return new ArrayList<>(mapOfSongs.keySet());
    }

    @Override
    public List<Song> getTop3() {
        List<Song> top3songs = new ArrayList<>();
        mapOfSongs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .peek(e -> top3songs.add(e.getKey()))
                .collect(Collectors.toList());

        List<Song> output = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            output.add(top3songs.get(i));
        }
        return output;
    }


    @Override
    public List<Song> getTop10() {

        List<Song> top10songs = new ArrayList<>();
        mapOfSongs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .peek(e -> top10songs.add(e.getKey()))
                .collect(Collectors.toList());

        List<Song> output = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            output.add(top10songs.get(i));
        }
        return output;

    }

    @Override
    public List<Song> getSongByCategory(String category) {
        List<Song> songsByCategory = new ArrayList<>();

        for(Song song : mapOfSongs.keySet()){
            if (song.getCategory().equals(category)){
                songsByCategory.add(song);
            }
        }
        return songsByCategory;
    }
}

