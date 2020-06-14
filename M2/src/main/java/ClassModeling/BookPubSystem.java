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
public class BookPubSystem {
    private boolean isHardCover;
    private String title;
    private String genre;
    private int numOfPages;
    private int numOfCopies;
    private boolean hasAudioBook;
    private double price;
    private double revenue;
    private double profit;
    
    public BookPubSystem(boolean isHard, String title, String g, int numPages, boolean hasA) {
        this.isHardCover = isHard;
        this.title = title;
        this.genre = g;
        this.numOfPages = numPages;
        this.isHardCover = hasA;
    }
    
    public BookPubSystem(double p, double rev, double prof, int copies) {
        this.price = p;
        this.revenue = rev;
        this.profit = prof;
        this.numOfCopies = copies;
    }
    public BookPubSystem(boolean isHard, String title, String g, int numPages, boolean hasA, double p, double rev, double prof, int copies ){
        this.isHardCover = isHard;
        this.title = title;
        this.genre = g;
        this.numOfPages = numPages;
        this.isHardCover = hasA;
        this.price = p;
        this.revenue = rev;
        this.profit = prof;
        this.numOfCopies = copies;
    }

    public boolean isIsHardCover() {
        return isHardCover;
    }

    public void setIsHardCover(boolean isHardCover) {
        this.isHardCover = isHardCover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public boolean isHasAudioBook() {
        return hasAudioBook;
    }

    public void setHasAudioBook(boolean hasAudioBook) {
        this.hasAudioBook = hasAudioBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
    public void addToNumOfCopies(int newNumOfCopies) {
        this.numOfCopies = this.numOfCopies + newNumOfCopies;
    }
}
