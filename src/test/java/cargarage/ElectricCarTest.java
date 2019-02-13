package cargarage;

import org.junit.Assert;
import org.junit.Test;

public class ElectricCarTest {

	@Test
	public void shouldDrainBattery() {
		// Tests impact of accelerate()
		// Arrange
		ElectricCar underTest = new ElectricCar(null);

		// Act
		int initialCharge = underTest.getBattery();
		underTest.drainBattery(10);
		int chargeAfterAcceleration = underTest.getBattery();

		// Assert
		Assert.assertEquals(initialCharge - 10, chargeAfterAcceleration);
	}

	@Test
	public void shouldChargeBattery() {
		// Tests charging the battery
		// Arrange
		ElectricCar underTest = new ElectricCar(null);

		// Act
		underTest.chargeUp();
		int chargeAfterPluggingIn = underTest.getBattery();

		// Assert
		Assert.assertEquals(100, chargeAfterPluggingIn);
	}

}
