/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class BookCatalogSystem {

    private int books;
    private String publisher;
    private String genre;
    private String[] newReleases;
    private String format;
    private String author;
    private boolean availableforrent;
    private String rentby;
    private String rentDue;

    public BookCatalogSystem(int b, String p, String g) {
        this.books = b;
        this.genre = g;
        this.publisher = p;
    }

    public BookCatalogSystem(String[] newRel, String form, boolean a, String author, String rentD, String rentB) {
        this.newReleases = newRel;
        this.format = form;
        this.availableforrent = a;
        this.author = author;
        this.rentDue = rentD;
        this.rentby = rentB;

    }

    public BookCatalogSystem(int b, String p, String g, String[] newRel, String form, boolean a, String author, String rentD, String rentB) {
        this.books = b;
        this.genre = g;
        this.publisher = p;
        this.newReleases = newRel;
        this.format = form;
        this.availableforrent = a;
        this.author = author;
        this.rentDue = rentD;
        this.rentby = rentB;
    }

    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getNewReleases() {
        return newReleases;
    }

    public void setNewReleases(String[] newReleases) {
        this.newReleases = newReleases;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailableforrent() {
        return availableforrent;
    }

    public void setAvailableforrent(boolean availableforrent) {
        this.availableforrent = availableforrent;
    }

    public String getRentby() {
        return rentby;
    }

    public void setRentby(String rentby) {
        this.rentby = rentby;
    }

    public String getRentDue() {
        return rentDue;
    }

    public void setRentDue(String rentDue) {
        this.rentDue = rentDue;
    }

    public void extendRentDue(String newRentDue) {
        this.rentDue = this.rentDue + newRentDue;
    }
}
