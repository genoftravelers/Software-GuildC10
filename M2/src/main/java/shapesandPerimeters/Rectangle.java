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
public class Rectangle extends Shape {

    protected final int length;
    protected final int width;

    public Rectangle(int l, int w) {
        this.length = l;

        this.width = w;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (getWidth() * getLength());
        //  return super.getPerimeter(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getArea() {
        return getWidth() * getLength();
        //return super.getArea(); //To change body of generated methods, choose Tools | Templates.
    }
}
