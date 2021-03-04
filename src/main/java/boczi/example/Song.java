package boczi.example;

import java.util.Objects;

public class Song {
    private String title;
    private String author;
    private String album;
    private String category;

    public Song(String title, String author, String album, String category) {
        this.title = title;
        this.author = author;
        this.album = album;
        this.category = category;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return
                Objects.equals(title, song.title) &&
                        Objects.equals(author, song.author) &&
                        Objects.equals(album, song.album) &&
                        Objects.equals(category, song.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, album, category);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", album='" + album + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
