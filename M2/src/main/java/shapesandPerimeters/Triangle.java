/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapesandPerimeters;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Triangle extends Shape {

    protected int base;
    protected int height;
    protected int sides;

    public Triangle(int b, int h, int s) {
        this.base = b;
        this.height = h;
        this.sides = s;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getPerimeter() {//P=a+b+c or side + base + side
        return getSides() + getBase() + getSides();
        //return super.getPerimeter(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getArea() {//Area =  1/2(bh)
        return (getBase() * getHeight()) / 1 / 2;
        //return super.getArea(); //To change body of generated methods, choose Tools | Templates.
    }
}
