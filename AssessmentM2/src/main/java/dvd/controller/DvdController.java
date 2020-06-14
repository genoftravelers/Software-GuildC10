/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.controller;

import dvd.dao.DvdDao;
import dvd.dao.DvdDaoException;
import dvd.dao.DvdDaoFileImpl;
import dvd.dto.Dvd;
import dvd.ui.DvdView;
import dvd.ui.UserIO;
import dvd.ui.UserIOImpl;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */

/*
The Controller can "talk" to both View and the DAO but Dao and View cannot 
"talk" to each other.
The Controller is the brains. It knows what needs to be done and how, and 
what components can do it. It is like a constructor, directly work but never 
does it. 
 */
public class DvdController {
// declarations for dependency injection.

    private DvdView view;
    private DvdDao dao;
//implement constructor.
//dependency is injected in the constructor.

    public DvdController(DvdDao dao, DvdView view) {
//uses the incoming values to initialize the Dao and View member fields.
        this.dao = dao;
        this.view = view;
    }

    private UserIO io = new UserIOImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {

                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuSelection();
    }

    private void createDvd() throws DvdDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdDaoException {//ListDvds
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdDaoException {
        view.displayDisplayDvdBanner();
        String Title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(Title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void editDvd() throws DvdDaoException {
        view.displayEditDvdBanner();//ask the view to show banner for editing.
        String title = view.getDvdTitleChoice();// get the title of dvd you want
        //to edit.
        Dvd currentDvd = dao.getDvd(title);//get the current dvd by title.
        if (currentDvd != null) {
            Dvd editedDvd = view.getNewDvdInfo();//ask view to get info for new dvd
            dao.editDvdInfo(title, editedDvd);//ask dao to finally edit the dvd.
        }
        view.displayEditResult(currentDvd);//ask view to show the edited dvd.

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
