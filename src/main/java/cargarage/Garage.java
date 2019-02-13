package cargarage;

import java.util.HashMap;

public class Garage {

	private HashMap<String, Car> cars = new HashMap<String, Car>();

	// Getter
	public HashMap<String, Car> getCars() {
		return cars;
	}

	// Methods
	public int getCarCount() {
		return cars.size();
	}

	public void addCar(Car carToAdd) {
		cars.put(carToAdd.getPlate(), carToAdd);
	}

	public void removeCar(Car carToRemove) {
		cars.remove(carToRemove.getPlate(), carToRemove);
	}

	public Car findCar(String plate) {
		return cars.get(plate);
	}

	public void checkCarsInventory() {
		for (Car car : cars.values()) {
			System.out.println("Car " + car.getPlate());
		}
	}

	public void checkLevels() {
		for (Car car : cars.values()) {
			if (car instanceof ElectricCar) {
				System.out.println("Car " + car.getPlate() + " has a battery charge of "
						+ ((ElectricCar) car).getBattery() + " out of 100.");
			} else if (car instanceof FuelEngineCar) {
				System.out.println("Car " + car.getPlate() + " has a fuel level of "
						+ ((FuelEngineCar) car).getFuelLevel() + " out of 100.");
			}
		}
	}

	public void topOffAllCars() {
		for (Car car : cars.values()) {
			if (car instanceof ElectricCar) {
				((ElectricCar) car).chargeUp();
			} else if (car instanceof FuelEngineCar) {
				((FuelEngineCar) car).refuel();
			}
		}
	}
}
