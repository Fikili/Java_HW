package com.tieto.ecm.training.java;

public class Bicycle {
    
    private int cadence;
    private int gear;
    private int speed;
        
    public Bicycle(int cadence, int speed, int gear) {
        this.gear = gear;
        this.cadence = cadence;
        this.speed = speed;
    }
        
    public int getCadence() {
        return cadence;
    }
        
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public int getGear() {
        return gear;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public int getSpeed() {
        return speed;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
    
    public static void decreaseCadence(Bicycle bike) {
    	bike.setCadence(bike.getCadence()/2);
    	bike = new Bicycle(0, 0, 0);
    }
}
