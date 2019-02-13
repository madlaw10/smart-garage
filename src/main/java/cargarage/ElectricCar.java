package cargarage;

import java.util.Random;

public class ElectricCar extends Car {

	// Properties
	private int battery;

	// Constructor
	public ElectricCar(String plate) {
		super(plate);
		Random rng = new Random();
		this.battery = rng.nextInt(50) + 51;
	}

	// Getter
	public int getBattery() {
		return battery;
	}

	// Methods
	public void drainBattery(int drainRate) {
		battery -= drainRate;
		if (battery < 0) {
			battery = 0;
		}
	}

	public void chargeUp() {
		battery = 100;
	}
	
	public void outOfCharge() {
		if(battery == 0) {
			outOfJuice();
		}
	}

}
