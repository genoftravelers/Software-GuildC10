/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.ui;

import dvd.dto.Dvd;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */

/*
The View is responsible for all the user interactions. No other component 
is able to interact with the user.
 */
public class DvdView {
// declaration for dependency injection.

    private UserIO io;
//implement constructor
//dependency is injected in the constructor.

    public DvdView(UserIO io) {
//uses the incoming values to initialize the view fields.
        this.io = io;
    }

    public int printMenuSelection() {

        io.print("Main Menu");
        io.print("1. List all Dvds");
        io.print("2. Add Dvd");
        io.print("3. Display One Dvd");
        io.print("4. Remove Dvd");
        io.print("5. Edit Dvd");
        io.print("6. Exit");

        return io.readInt("Please select from the" + " above choices.", 1, 6);
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create Dvd ===");
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter Dvd Title.");
        String releaseDate = io.readString("Please enter Release Date.");
        String mpaaRating = io.readString("Please enter MPAA Rating.");
        String directorName = io.readString("Please enter Director's name.");
        String studio = io.readString("Please enter Studio Name. ");
        String userRatingOrNote = io.readString("Please enter a rating or a Note.");
        Dvd currentDvd = new Dvd(title);//making a new object through new.
        currentDvd.setReleaseDate(releaseDate);//setting in all the properties.
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setUserRatingOrNote(userRatingOrNote);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);

        return currentDvd;
    }

    public void displayCreateSuccessBanner() {
        io.readString("Dvd successfully created. Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("== Display All Dvds === ");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            //%s prints out the string written by user.
            String dvdInfo = String.format("Title: %s, Release Date: %s, Mpaa Rating: %s, Director's Name: %s, Studio: %s, Rating or Note: %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getUserRatingOrNote());
            io.print(dvdInfo);
        }
        // io.print("Please hit enter to continue.");
    }

    public void displayDisplayDvdBanner() {
        io.print("== Display Dvd === ");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the Dvd Title");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            //  io.print(dvd.getTitle());

            //shows the information of the dvd to the user.
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRatingOrNote());
            io.print(" ");
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("== Remove Dvd ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("Dvd successfully removed.");
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit Dvd Information ===");
    }

    public void displayEditResult(Dvd dvdToEdit) {
        //if the dvd is null or doesn't exit, it will say "no such dvd".
        if (dvdToEdit != null) {
            io.print("Dvd successfully edited.");
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public Dvd getDvdInfo(Dvd dvd) {
        String releaseDate = io.readString("Please enter the Release date.");
        String mpaaRating = io.readString("Please enter the MPAA rating.");
        String directorName = io.readString("Please enter the name of Director.");
        String studio = io.readString("Please enter the name of studio.");
        String userRating = io.readString("Please enter the user Rating.");

        Dvd editedDvd = new Dvd(dvd.getTitle());

        editedDvd.setReleaseDate(releaseDate);
        editedDvd.setMpaaRating(mpaaRating);
        editedDvd.getDirectorName();
        editedDvd.getStudio();
        editedDvd.getUserRatingOrNote();

        return editedDvd;

        // return io.readString("Please enter the Title of the DVD you wish to edit.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
