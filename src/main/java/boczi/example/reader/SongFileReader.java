package boczi.example.reader;

import boczi.example.Song;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
    Set<Song> read(String fileName) throws ParserConfigurationException, IOException, SAXException;

}

