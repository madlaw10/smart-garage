package cargarage;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

	@Test
	public void shouldAccelerate() {
		// Tests the accelerate() method in Car
		// Arrange
		Car underTest = new ElectricCar(null);

		// Act
		int initialSpeed = underTest.getSpeed();
		underTest.accelerate(10);
		int speedAfterAcceleration = underTest.getSpeed();

		// Assert
		Assert.assertEquals(initialSpeed + 10, speedAfterAcceleration);

	}

	@Test
	public void shouldSlowDown() {
		// Tests the brake() method in Car
		// Arrange
		Car underTest = new ElectricCar(null);
		underTest.accelerate(10);

		// Act
		int initialSpeed = underTest.getSpeed();
		underTest.brake(10);
		int speedAfterBraking = underTest.getSpeed();

		// Assert
		Assert.assertEquals(initialSpeed - 10, speedAfterBraking);
	}

	@Test
	public void shouldStart() {
		// Tests toggleEngine()
		// Arrange
		Car underTest = new ElectricCar(null);

		// Act
		underTest.toggleEngine();

		// Assert
		Assert.assertTrue(underTest.getIgnition());

	}

	@Test
	public void shouldTurnOff() {
		// Tests toggleEngine()
		// Arrange
		Car underTest = new ElectricCar(null);
		underTest.toggleEngine();

		// Act
		underTest.toggleEngine();

		// Assert
		Assert.assertFalse(underTest.getIgnition());

	}

}
