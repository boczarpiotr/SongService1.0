package boczi.example;

import boczi.example.reader.SongCSVFileReader;
import boczi.example.repo.InMemorySongRepository;
import boczi.example.reader.SongXMLFileReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        SongCSVFileReader songCSVFileReader = new SongCSVFileReader();
        SongXMLFileReader songXMLFileReader = new SongXMLFileReader();

        Set<Song> read = songCSVFileReader.read("C:\\Users\\Piortek\\Desktop\\songs.csv");
        Set<Song> read2 = songXMLFileReader.read("C:\\Users\\Piortek\\Desktop\\Point\\SongService1.0\\file.xml");

    }
}

