package be.vdab.spring_jdbc;

/**
 * Created by brandonstark on 31/08/16.
 */
public class Film {
    private String title;
    private int releaseYear;
    private String description;

    public Film(String title, int releaseYear, String description) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + "\t" + "(" + releaseYear + ")" + "\t" + description ;
    }
}
