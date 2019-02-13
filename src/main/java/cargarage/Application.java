package cargarage;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Create starting car inventory
		Car electricCar = new ElectricCar("MED9211");
		Car fuelEngineCar = new FuelEngineCar("JPL2212");

		// Create garage
		Garage smartGarage = new Garage();

		// Add starting cars to garage map
		smartGarage.addCar(electricCar);
		smartGarage.addCar(fuelEngineCar);

		// Main garage greeting
		System.out.println("Welcome to the Smart Garage.");
		System.out.println("You have the following cars parked in our facility:");
		smartGarage.checkCarsInventory();
		System.out.println("");

		// Main garage menu
		boolean repeatMainMenu = true;
		while (repeatMainMenu) {
			System.out.println("What would you like to do?");
			System.out.println("1. Rent an Additional Parking Space");
			System.out.println("2. Remove a Car Permanently");
			System.out.println("3. Drive a Car");
			System.out.println("4. Check the Levels of Your Parked Cars");
			System.out.println("5. Exit the Garage");

			String mainMenuSelection = input.nextLine();
			switch (mainMenuSelection) {

			// Add either an electric car or fuel engine car to the garage
			case "1":
				System.out.println(
						"Please provide the license plate number of the car you wish to park in the Smart Garage:");
				String newPlate = input.nextLine();
				System.out.println("Is this an Electric Car or a Fuel Engine Car?");
				System.out.println("1. Electric Car");
				System.out.println("2. Fuel Engine Car");
				String carType = input.nextLine();
				switch (carType) {
				case "1":
					Car electricCarToAdd = new ElectricCar(newPlate);
					smartGarage.addCar(electricCarToAdd);
					System.out.println("Car " + electricCarToAdd.getPlate() + " is now parked in the Smart Garage.");
					break;
				case "2":
					Car fuelEngineCarToAdd = new FuelEngineCar(newPlate);
					smartGarage.addCar(fuelEngineCarToAdd);
					System.out.println("Car " + fuelEngineCarToAdd.getPlate() + " is now parked in the Smart Garage.");
					break;
				}
				System.out.println("");
				break;

			// Remove a Car from the Garage
			case "2":
				if (smartGarage.getCarCount() < 1) {
					System.out.println("You do not have any cars parked in the Smart Garage.");
					System.out.println("");
				} else {
					System.out.println("You have the following cars parked in our facility:");
					smartGarage.checkCarsInventory();
					System.out.println("Please enter the license plate number of the car you wish to remove.");
					String plate = input.nextLine();
					Car carToRemove = smartGarage.findCar(plate);
					smartGarage.removeCar(carToRemove);
					System.out.println("Car " + plate + " has been permanently removed from the Smart Garage.");
					System.out.println("");
				}
				break;

			// Select One Car
			case "3":
				System.out.println("The following cars are available:");
				smartGarage.checkCarsInventory();
				System.out.println("Please enter the license plate number of the car you wish to drive.");
				String plate = input.nextLine();
				Car carToDrive = smartGarage.findCar(plate);
				System.out.println("Car " + carToDrive.getPlate() + " has been pulled out of the Smart Garage.");
				System.out.println("Start the car when you are ready to drive.");
				System.out.println("1. Start Car");
				System.out.println("2. Return Car to the Smart Garage");
				String ignitionMenuSelection = input.nextLine();
				switch (ignitionMenuSelection) {

				// Start Car
				case "1":
					carToDrive.toggleEngine();
					while (carToDrive.getIgnition()) {
						if (carToDrive instanceof ElectricCar) {

							// Electric Car Menu
							System.out.println("Car is currently going " + carToDrive.getSpeed() + " mph.");
							System.out.println("What would you like to do?");
							System.out.println("1. Accelerate");
							System.out.println("2. Apply Brakes");
							System.out.println("3. Maintain Current Speed");
							System.out.println("4. Check Battery Charge");
							System.out.println("5. Turn Off Car and Return to Smart Garage");
							String driveMenuSelection = input.nextLine();

							switch (driveMenuSelection) {
							// Accelerate
							case "1":
								System.out.println("1. Tap the pedal");
								System.out.println("2. Apply moderate pressure");
								System.out.println("3. Floor it");
								String accelerationRate = input.nextLine();
								switch (accelerationRate) {
								case "1":
									carToDrive.accelerate(5);
									break;
								case "2":
									carToDrive.accelerate(10);
									break;
								case "3":
									carToDrive.accelerate(15);
									break;
								}
								break;

							// Brake
							case "2":
								if (carToDrive.getSpeed() <= 0) {
									System.out.println("Car is currently idling. You cannot brake at this time.");
								} else {
									System.out.println("1. Tap the pedal");
									System.out.println("2. Apply moderate pressure");
									System.out.println("3. Slam on the brakes");
									String brakeRate = input.nextLine();
									switch (brakeRate) {
									case "1":
										carToDrive.brake(5);
										break;
									case "2":
										carToDrive.brake(15);
										break;
									case "3":
										carToDrive.brake(30);
										break;
									}
								}
								break;

							// Check Battery
							case "4":
								System.out.println(
										"Battery charge is " + ((ElectricCar) carToDrive).getBattery() + " out of 100");
								break;

							// Turn Off Car
							case "5":
								if (carToDrive.getSpeed() > 0) {
									System.out.println("Car cannot be turned off while moving.");
									System.out.println("Please apply brakes until car speed is 0 mph");
								} else {
									carToDrive.toggleEngine();
									System.out.println("Welcome back to the Smart Garage.");
								}
								break;
							}

							// Speed monitoring and battery drain while electric car is in use
							if (((ElectricCar) carToDrive).getBattery() == 0) {
								carToDrive.outOfJuice();
								System.out.println("Your car has insufficient charge to continuing driving.");
								System.out.println("Smart Garage is sending a tow truck to your location.");
								System.out.println("Your car is being returned to the Smart Garage.");
								carToDrive.toggleEngine();
							} else if (carToDrive.getSpeed() == 0) {
								int drainRate = 0;
								((ElectricCar) carToDrive).drainBattery(drainRate);
							} else if (carToDrive.getSpeed() <= 40) {
								int drainRate = 3;
								((ElectricCar) carToDrive).drainBattery(drainRate);
							} else if (carToDrive.getSpeed() <= 80) {
								int drainRate = 6;
								((ElectricCar) carToDrive).drainBattery(drainRate);
							} else if (carToDrive.getSpeed() <= 120) {
								int drainRate = 9;
								((ElectricCar) carToDrive).drainBattery(drainRate);
							} else if (carToDrive.getSpeed() > 120) {
								System.out.println("You are driving recklessly and police are in pursuit.");
								System.out.println("Your car is being returned to the Smart Garage.");
								System.out.println("You have lost Smart Garage priveleges. Goodbye.");
								carToDrive.toggleEngine();
								System.exit(0);
							}

						} else if (carToDrive instanceof FuelEngineCar) {

							// Fuel Engine Car Menu
							System.out.println("Car is currently going " + carToDrive.getSpeed() + " mph.");
							System.out.println("What would you like to do?");
							System.out.println("1. Accelerate");
							System.out.println("2. Apply Brakes");
							System.out.println("3. Maintain Current Speed");
							System.out.println("4. Check Fuel Gauge");
							System.out.println("5. Turn Off Car and Return to Smart Garage");
							String driveMenuSelection = input.nextLine();
							switch (driveMenuSelection) {

							// Accelerate
							case "1":
								System.out.println("1. Tap the pedal");
								System.out.println("2. Apply moderate pressure");
								System.out.println("3. Floor it");
								String accelerationRate = input.nextLine();
								switch (accelerationRate) {
								case "1":
									carToDrive.accelerate(5);
									break;
								case "2":
									carToDrive.accelerate(10);
									break;
								case "3":
									carToDrive.accelerate(15);
									break;
								}
								break;

							// Brake
							case "2":
								if (carToDrive.getSpeed() <= 0) {
									System.out.println("Car is currently idling. You cannot brake at this time.");
								} else {
									System.out.println("1. Tap the pedal");
									System.out.println("2. Apply moderate pressure");
									System.out.println("3. Slam on the brakes");
									String brakeRate = input.nextLine();
									switch (brakeRate) {
									case "1":
										carToDrive.brake(5);
										break;
									case "2":
										carToDrive.brake(15);
										break;
									case "3":
										carToDrive.brake(30);
										break;
									}
								}
								break;

							// Check Fuel Gauge
							case "4":
								System.out.println(
										"Fuel gauge is " + ((FuelEngineCar) carToDrive).getFuelLevel() + " out of 100");
								break;

							// Turn Off Car
							case "5":
								if (carToDrive.getSpeed() > 0) {
									System.out.println("Car cannot be turned off while moving.");
									System.out.println("Please apply brakes until car speed is 0 mph");
								} else {
									carToDrive.toggleEngine();
									System.out.println("Welcome back to the Smart Garage.");
								}
								break;
							}

							// Speed monitoring and gas consumption while fuel engine car is in use
							if (((FuelEngineCar) carToDrive).getFuelLevel() == 0) {
								carToDrive.outOfJuice();
								System.out.println("Your car has insufficient fuel to continuing driving.");
								System.out.println("Smart Garage is sending a tow truck to your location.");
								System.out.println("Your car is being returned to the Smart Garage.");
								carToDrive.toggleEngine();
							} else if (carToDrive.getSpeed() == 0) {
								int drainRate = 3;
								((FuelEngineCar) carToDrive).drainFuel(drainRate);
							} else if (carToDrive.getSpeed() <= 40) {
								int drainRate = 6;
								((FuelEngineCar) carToDrive).drainFuel(drainRate);
							} else if (carToDrive.getSpeed() <= 80) {
								int drainRate = 9;
								((FuelEngineCar) carToDrive).drainFuel(drainRate);
							} else if (carToDrive.getSpeed() <= 120) {
								int drainRate = 12;
								((FuelEngineCar) carToDrive).drainFuel(drainRate);
							} else if (carToDrive.getSpeed() > 120) {
								System.out.println("You are driving recklessly and police are in pursuit.");
								System.out.println("Your car is being returned to the Smart Garage.");
								System.out.println("You have lost Smart Garage priveleges. Goodbye.");
								carToDrive.toggleEngine();
								System.exit(0);
							}
						}
					}
					break;
				}
				break;

			// Check the Battery Charge of All Cars & Charge All Cars to 100
			case "4":
				smartGarage.checkLevels();
				System.out.println("");
				System.out.println("Would you like to top off all cars at this time?");
				System.out.println("1. Top off All Cars");
				System.out.println("2. Return to Smart Garage Menu");
				String chargeMenuSelection = input.nextLine();
				switch (chargeMenuSelection) {
				case "1":
					smartGarage.topOffAllCars();
					System.out.println(".");
					System.out.println("..");
					System.out.println("...");
					System.out.println("All cars are refilled.");
					System.out.println("");
					break;
				}
				break;

			// Exit the Garage
			case "5":
				System.out.println("Thank you for being a Smart Garage member.");
				System.out.println("Your session is now closed. Goodbye.");
				repeatMainMenu = false;
			}

		}

	}
}
