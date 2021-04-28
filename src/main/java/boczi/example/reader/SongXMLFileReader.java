package boczi.example.reader;

import boczi.example.Song;
import boczi.example.repo.InMemorySongRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SongXMLFileReader implements SongFileReader {

    public static final InMemorySongRepository inMemorySongRepository = new InMemorySongRepository();


    @Override
    public Set<Song> read(String fileName) throws ParserConfigurationException, IOException, SAXException {

        Set<Song> setOfSongs = new HashSet<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("SONG");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;

                Song song = new Song(eElement.getElementsByTagName("TITLE").item(0).getTextContent(), eElement.getElementsByTagName("AUTHOR").item(0).getTextContent()
                        , eElement.getElementsByTagName("ALBUM").item(0).getTextContent(), eElement.getElementsByTagName("CATEGORY").item(0).getTextContent());
                setOfSongs.add(song);
                inMemorySongRepository.addSong(song, Integer.parseInt(eElement.getElementsByTagName("VOTES").item(0).getTextContent()));
            }
        }
        return setOfSongs;
    }

}
