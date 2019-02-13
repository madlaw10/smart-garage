package cargarage;

public abstract class Car { // "Abstract" blocks the creation of a generic Car object

	// Properties
	private String plate;
	private boolean ignition;
	private int speed;

	// Constructor
	public Car(String plate) {
		this.plate = plate;
		this.ignition = false;
		this.speed = 0;
	}

	// Getters
	public String getPlate() {
		return plate;
	}

	public boolean getIgnition() {
		return ignition;
	}

	public int getSpeed() {
		return speed;
	}

	// Methods
	public void toggleEngine() {
		ignition = !ignition;
	}

	public void accelerate(int acceleration) {
		speed += acceleration;
	}

	public void brake(int brakePedal) {
		speed -= brakePedal;
		if (speed < 0) {
			speed = 0;
		}
	}

	public void outOfJuice() {
		speed = 0;
	}

}
