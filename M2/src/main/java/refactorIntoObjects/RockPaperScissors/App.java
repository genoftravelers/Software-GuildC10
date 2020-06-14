/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorIntoObjects;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {
    public static void main(String[] args) {
        
        RockPaperScissors myRockPaperScissors = new RockPaperScissors();
        myRockPaperScissors.playGame();
    }
}
