/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.dto;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Dvd {

    private final String title;
    private String releaseDate;
    private String directorName;
    private String studio;
    private String userRatingOrNote;
    private String mpaaRating;

    public Dvd(String title) {
// constructor that we will be using to create new dvd object using title.
        this.title = title;
    }

    public String getTitle() {// no setter for the title because its read only.
        return title;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingOrNote() {
        return userRatingOrNote;
    }

    public void setUserRatingOrNote(String userRatingOrNote) {
        this.userRatingOrNote = userRatingOrNote;
    }
}
