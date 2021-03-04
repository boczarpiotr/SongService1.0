package boczi.example.reader;

import boczi.example.Song;

import java.util.List;
import java.util.Set;

/**
TODO
 */
public interface SongFileReader {
    /**
     * TODO
     * @param fileName
     * @return
     */
    Set<Song> read(String fileName);

}

