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
public class CarVidGame {

    private String model;
    private double price;
    private boolean buy;
    private String nameOfGame;
    private double speed;
    private double maxSpeed;
    private int gameLife;

    public CarVidGame(String mode, int gameL, double p, boolean b) {
        this.buy = b;
        this.gameLife = gameL;
        this.price = p;
        this.model = mode;
    }

    public CarVidGame(String name, double s, double maxS) {
        this.nameOfGame = name;
        this.maxSpeed = maxS;
        this.speed = s;
    }

    public CarVidGame(String mode, int gameL, double p, boolean b, String name, double s, double maxS) {
        this.buy = b;
        this.gameLife = gameL;
        this.price = p;
        this.model = mode;
        this.nameOfGame = name;
        this.maxSpeed = maxS;
        this.speed = s;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }

    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getGameLife() {
        return gameLife;
    }

    public void setGameLife(int gameLife) {
        this.gameLife = gameLife;
    }
    
    public void addToNameOfGame(String newNameOfGame) {
        this.nameOfGame = this.nameOfGame + newNameOfGame;
    }

}
