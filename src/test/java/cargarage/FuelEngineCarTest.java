package cargarage;

import org.junit.Assert;
import org.junit.Test;

public class FuelEngineCarTest {

	@Test
	public void shouldConsumeFuel() {
		// Tests impact of accelerate()
		// Arrange
		FuelEngineCar underTest = new FuelEngineCar(null);

		// Act
		int initialCharge = underTest.getFuelLevel();
		underTest.drainFuel(10);
		int chargeAfterAcceleration = underTest.getFuelLevel();

		// Assert
		Assert.assertEquals(initialCharge - 10, chargeAfterAcceleration);
	}

	@Test
	public void shouldRefuel() {
		// Tests addFuel() to car
		// Arrange
		FuelEngineCar underTest = new FuelEngineCar(null);

		// Act
		underTest.refuel();
		int chargeAfterPluggingIn = underTest.getFuelLevel();

		// Assert
		Assert.assertEquals(100, chargeAfterPluggingIn);
	}

}
