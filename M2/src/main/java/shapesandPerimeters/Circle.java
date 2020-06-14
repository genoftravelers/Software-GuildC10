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
public class Circle extends Shape {

    protected int radious;

    public Circle(int r) {
        this.radious = r;

    }

    public int getRadious() {
        return radious;
    }

    public void setRadious(int radious) {
        this.radious = radious;
    }

    @Override
    public double getPerimeter() {//C=2πr perimeter = 2 * pi * radious
        return 2 * Math.PI * getRadious();
    }

    @Override
    public double getArea() {//A=πr2
        return Math.PI * getRadious() * 2;
    }
}
