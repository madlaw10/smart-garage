package cargarage;

import org.junit.Assert;
import org.junit.Test;

public class GarageTest {

	@Test
	public void shouldAddCarToGarage() {
		// Tests addCar()
		// Arrange
		Garage underTest = new Garage();
		Car carToAdd = new ElectricCar(null);

		// Act
		int initialCars = underTest.getCarCount();
		underTest.addCar(carToAdd);
		int carsAfterAddition = underTest.getCarCount();

		// Assert
		Assert.assertEquals(initialCars + 1, carsAfterAddition);
	}

	@Test
	public void shouldRemoveCarFromGarage() {
		// Tests removeCar()
		// Arrange
		Garage underTest = new Garage();
		Car carToRemove = new ElectricCar(null);
		underTest.addCar(carToRemove);

		// Act
		int initialCars = underTest.getCarCount();
		underTest.removeCar(carToRemove);
		int carsAfterRemoval = underTest.getCarCount();

		// Assert
		Assert.assertEquals(initialCars - 1, carsAfterRemoval);
	}

	@Test
	public void shouldTopOffAllCars() {
		// Tests topOffAllCars()
		// Arrange
		Garage underTest = new Garage();
		Car carToCharge = new ElectricCar("Electric Car");
		Car carToRefuel = new FuelEngineCar("Fuel Engine Car");
		underTest.addCar(carToCharge);
		underTest.addCar(carToRefuel);

		// Act
		underTest.topOffAllCars();
		int levelsAfterToppingOff = ((ElectricCar) carToCharge).getBattery()
				+ ((FuelEngineCar) carToRefuel).getFuelLevel();

		// Assert
		Assert.assertEquals(200, levelsAfterToppingOff);

	}

	@Test
	public void shouldTestDriveOneCar() {
		// Should select a single car
		// Arrange
		Garage underTest = new Garage();
		Car carToAdd = new ElectricCar("MEL9211");
		underTest.addCar(carToAdd);

		// Act
		Car carToDrive = underTest.findCar("MEL9211");

		// Assert
		Assert.assertEquals(carToAdd, carToDrive);
	}
}
