/*
 * Model an airplane as if the class were to be part of an air traffic control system.
 */
package ClassModeling;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class AirPlaneATCSystem {// class 
    //Fields

    private double speed;
    private double heightAboveGround;
    private int capacity;
    private String flightfrom;
    private String flightTo;
    private double milesTraveled;
    private int amountOfPlanesinAir;
    private double spacesBetweenPlanes;

    public AirPlaneATCSystem(double sp, double heightAGround, double mTraveled) {
        this.speed = sp;
        this.heightAboveGround = heightAGround;
        this.milesTraveled = mTraveled;
    }

    public AirPlaneATCSystem(String fFrom, String fTo) {
        this.flightfrom = fFrom;
        this.flightTo = fTo;
    }
    
    public AirPlaneATCSystem(double sp, double heightAGround, double mTraveled, String fFrom, String fTo, int cap, double spaceBtw, int amtPlane ) {
        this.speed = sp;
        this.heightAboveGround = heightAGround;
        this.milesTraveled = mTraveled;
        this.flightfrom = fFrom;
        this.flightTo = fTo;
        this.capacity = cap;
        this.spacesBetweenPlanes = spaceBtw;
        this.amountOfPlanesinAir= amtPlane;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHeightAboveGround() {
        return heightAboveGround;
    }

    public void setHeightAboveGround(double heightAboveGround) {
        this.heightAboveGround = heightAboveGround;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFlightfrom() {
        return flightfrom;
    }

    public void setFlightfrom(String flightfrom) {
        this.flightfrom = flightfrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public double getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(double milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public int getAmountOfPlanesinAir() {
        return amountOfPlanesinAir;
    }

    public void setAmountOfPlanesinAir(int amountOfPlanesinAir) {
        this.amountOfPlanesinAir = amountOfPlanesinAir;
    }

    public double getSpacesBetweenPlanes() {
        return spacesBetweenPlanes;
    }

    public void setSpacesBetweenPlanes(double spacesBetweenPlanes) {
        this.spacesBetweenPlanes = spacesBetweenPlanes;
    }
    public void addTomountOfPlanesinAir(int newamountOfPlanesinAir) {
        this.amountOfPlanesinAir = this.amountOfPlanesinAir + newamountOfPlanesinAir;
    }
}
