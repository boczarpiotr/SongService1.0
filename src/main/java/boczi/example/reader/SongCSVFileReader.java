package boczi.example.reader;

import boczi.example.Song;
import boczi.example.repo.InMemorySongRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SongCSVFileReader implements SongFileReader {

    InMemorySongRepository inMemorySongRepository = new InMemorySongRepository();


    @Override
    public Set<Song> read(String fileName) {


        try {
            FileReader fileReader = new FileReader(fileName);
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .build();

            String[] nextRecord;

            String[] insideList = new String[5];
            while ((nextRecord = csvReader.readNext()) != null) {
                for (int i = 0; i < nextRecord.length; i++) {
                    insideList[i] = nextRecord[i];
                }
                Song song = createSong(insideList);
                inMemorySongRepository.addSong(song , Integer.parseInt(insideList[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inMemorySongRepository.getMap().keySet();
    }

    public static Song createSong(String[] metaData) {
        String title = metaData[0];
        String author = metaData[1];
        String album = metaData[2];
        String category = metaData[3];

        return new Song(title, author, album, category);

    }
}
