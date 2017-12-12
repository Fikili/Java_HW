package com.tieto.ecm.training.java;

public class BicycleMain {

	public static void main(String[] args) {
		Bicycle myBike = new Bicycle(60, 30, 21);
		System.out.println("Cadence = " + myBike.getCadence() + " || Speed = " + myBike.getSpeed() + " || Gears = " + myBike.getGear());
		myBike.speedUp(10);
		System.out.println("Cadence = " + myBike.getCadence() + " || Speed = " + myBike.getSpeed() + " || Gears = " + myBike.getGear());
		Bicycle.decreaseCadence(myBike);
		System.out.println("Cadence = " + myBike.getCadence() + " || Speed = " + myBike.getSpeed() + " || Gears = " + myBike.getGear());
	}

}
