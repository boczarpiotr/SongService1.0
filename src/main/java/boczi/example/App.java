package boczi.example;

import boczi.example.reader.SongCSVFileReader;
import boczi.example.repo.InMemorySongRepository;
import boczi.example.reader.SongXMLFileReader;

import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SongCSVFileReader songCSVFileReader = new SongCSVFileReader();
        SongXMLFileReader songXMLFileReader = new SongXMLFileReader();

        Set<Song> read = songCSVFileReader.read("C:\\Users\\Piortek\\Desktop\\songs.csv");




        //     List<Song> list =  songCSVFileReader.read(args[0]);
//        List<Song> list2 = songXMLFileReader.read(args[1]);
//        InMemorySongRepository inMemorySongRepository = new InMemorySongRepository();
//        list.forEach((song) -> {inMemorySongRepository.addSong(song);});
//        list2.forEach(song -> inMemorySongRepository.addSong(song));
    }
}
