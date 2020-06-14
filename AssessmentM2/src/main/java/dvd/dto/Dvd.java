/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.dto;

import java.util.Objects;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Dvd {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.releaseDate);
        hash = 53 * hash + Objects.hashCode(this.directorName);
        hash = 53 * hash + Objects.hashCode(this.studio);
        hash = 53 * hash + Objects.hashCode(this.userRatingOrNote);
        hash = 53 * hash + Objects.hashCode(this.mpaaRating);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userRatingOrNote, other.userRatingOrNote)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dvd{" + "title=" + title + ", releaseDate=" + releaseDate + ", directorName=" + directorName + ", studio=" + studio + ", userRatingOrNote=" + userRatingOrNote + ", mpaaRating=" + mpaaRating + '}';
    }

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
