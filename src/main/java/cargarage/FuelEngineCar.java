package cargarage;

import java.util.Random;

public class FuelEngineCar extends Car {

	// Properties
	private int fuelTank;

	// Constructor
	public FuelEngineCar(String plate) {
		super(plate);
		Random rng = new Random();
		this.fuelTank = rng.nextInt(50) + 51;
	}

	// Getter
	public int getFuelLevel() {
		return fuelTank;
	}

	// Methods
	public void drainFuel(int drainRate) {
		fuelTank -= drainRate;
		if (fuelTank < 0) {
			fuelTank = 0;
		}
	}

	public void refuel() {
		fuelTank = 100;
	}
	
	public void outOfGas() {
		if(fuelTank == 0) {
			outOfJuice();
		}
	}

}
