package boczi.example.repo;

import boczi.example.Song;

import java.util.List;

public interface SongRepository {

    void voteForSong(Song song, int vote);
    void addSong(Song song, int vote);
    void deleteVotesBySong(Song song);
    void deleteAllVotes();
    List<Song> getAllSongs();
    List<Song> getTop3();
    List<Song> getTop10();
    List<Song> getSongByCategory(String category);
}
