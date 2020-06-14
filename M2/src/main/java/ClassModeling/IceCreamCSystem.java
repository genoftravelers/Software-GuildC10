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
public class IceCreamCSystem {

    private String[] flavor;
    private int price;
    private String ingredients;
    private double size;
    private boolean inAcone;
    private int amountOfIceCream;

    public IceCreamCSystem(boolean cone) {
        this.inAcone = cone;
    }

    public IceCreamCSystem(String[] f, int p) {
        this.flavor = f;
        this.price = p;
    }

    public IceCreamCSystem(String ingre, int s, int amt) {
        this.ingredients = ingre;
        this.size = s;
        this.amountOfIceCream = amt;
    }

    public IceCreamCSystem(boolean cone, String[] f, int p, String ingre, int s, int amt) {
        this.inAcone = cone;
        this.flavor = f;
        this.price = p;
        this.ingredients = ingre;
        this.size = s;
        this.amountOfIceCream = amt;
    }

    public String[] getFlavor() {
        return flavor;
    }

    public void setFlavor(String[] flavor) {
        this.flavor = flavor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isInAcone() {
        return inAcone;
    }

    public void setInAcone(boolean inAcone) {
        this.inAcone = inAcone;
    }

    public int getAmountOfIceCream() {
        return amountOfIceCream;
    }

    public void setAmountOfIceCream(int amountOfIceCream) {
        this.amountOfIceCream = amountOfIceCream;
    }
    public void addToSize(double newSize) {
       this.size = this.size + newSize;
    }
}
