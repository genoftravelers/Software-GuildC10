/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapesandPerimeters;

/**
 * Hint: the area of a square is (side squared).....the area of a Circle is
 * (PI*(radius squared))....even though they are both Shapes, they have
 * different implementations for their area.
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Square extends Shape {

    protected double side;

    public Square(double s) {

        this.side = s;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getPerimeter() {
        return 4 * getSide();//perimeter of square p = 4a
        //return super.getPerimeter(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getArea() {
        return Math.pow(getSide(), 2);// A = a square or side squared.
        //return super.getArea(); //To change body of generated methods, choose Tools | Templates.
    }

}
