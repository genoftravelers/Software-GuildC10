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
public class AirPlaneFlightSim {

    private double acceleration;
    private double maxAcceleration;
    private double speed;
    private double maxSpeed;
    private String pilotView;
    private double heightAboveGround;

    public AirPlaneFlightSim (String pilotV) {
        this.pilotView = pilotV;
    }
    
    public AirPlaneFlightSim(double acc, double maxAcc, double sp, double maxSp, double heightAGround) {
        this.acceleration = acc;
        this.maxAcceleration = maxAcc;
        this.speed = sp;
        this.maxSpeed = maxSp;
        this.heightAboveGround = heightAGround;
    }
    
    public AirPlaneFlightSim (String pilotV, double acc, double maxAcc, double sp, double maxSp, double heightAGround) {
        this.pilotView = pilotV;
        this.acceleration = acc;
        this.maxAcceleration = maxAcc;
        this.speed = sp;
        this.maxSpeed = maxSp;
        this.heightAboveGround = heightAGround;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    public void setMaxAcceleration(double maxAcceleration) {
        this.maxAcceleration = maxAcceleration;
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

    public String getPilotView() {
        return pilotView;
    }

    public void setPilotView(String pilotView) {
        this.pilotView = pilotView;
    }

    public double getHeightAboveGround() {
        return heightAboveGround;
    }

    public void setHeightAboveGround(double heightAboveGround) {
        this.heightAboveGround = heightAboveGround;
    }
    
    public void addToPilotView(String newPilotView){
        this.pilotView = this.pilotView + newPilotView;
    }
}
