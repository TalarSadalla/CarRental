package com.capgemini.service;

import com.capgemini.types.AgencyTO;
import com.capgemini.types.AgencyTO.AgencyTOBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class AgencyServiceTest {

	@Autowired
	private AgencyService agencyService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CarService carService;

	@Test
	@Transactional
	public void testShouldAddAgency() {

		// given
		AgencyTO agency=new AgencyTOBuilder().withContact("660461470").build();

		// when
		agencyService.addAgency(agency);

		// then
		assertTrue(agencyService.addAgency(agency));
		assertEquals("660461470",agencyService.findAgencyById(agency).getContact());
		assertEquals(java.util.Optional.of(1),agencyService.findAgencyById(agency).getId());
	}

	@Test
	@Transactional
	public void testShouldFindAllEmployeesInAgency() {
		// given
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Date dateOfBirth = null;
		try {
			date = dateFormat.parse("01/05/2016");
			dateOfBirth=dateFormat.parse("17/06/1990");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time = date.getTime();
		long employeeDateOfBirth=dateOfBirth.getTime();

		AgencyTO agency=new AgencyTOBuilder().withContact("660461470").build();
		AgencyTO agency2=new AgencyTOBuilder().withContact("6850329").build();
		agencyService.addAgency(agency);

		EmployeeTO employeeTO1 = new EmployeeTO.EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).withAgencyTO(agency).build();

		EmployeeTO employeeTO2 = new EmployeeTO.EmployeeTOBuilder().withName("Marcin").withSurname("Wojtowicz")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).withAgencyTO(agency).build();

		EmployeeTO employeeTO3 = new EmployeeTO.EmployeeTOBuilder().withName("Arek").withSurname("Mila")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).withAgencyTO(agency2).build();

		//when

		EmployeeTO savedEmployee1=employeeService.saveEmployee(employeeTO1);
		EmployeeTO savedEmployee2=employeeService.saveEmployee(employeeTO2);
		EmployeeTO savedEmployee3=employeeService.saveEmployee(employeeTO3);


		//then

		assertEquals(2,agencyService.findAllEmployeesInAgency(agency).size());
		assertEquals(1,agencyService.findAllEmployeesInAgency(agency2).size());

	}

	@Test
	@Transactional
	public void testShouldFindBooksByAuthor() {

		// given
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Date dateOfBirth = null;
		try {
			date = dateFormat.parse("01/05/2016");
			dateOfBirth=dateFormat.parse("17/06/1990");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time = date.getTime();
		long employeeDateOfBirth=dateOfBirth.getTime();

		AgencyTO agency=new AgencyTOBuilder().withContact("660461470").build();
		AgencyTO agency2=new AgencyTOBuilder().withContact("6850329").build();
		agencyService.addAgency(agency);

		EmployeeTO employeeTO1 = new EmployeeTO.EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).withAgencyTO(agency).build();

		EmployeeTO employeeTO2 = new EmployeeTO.EmployeeTOBuilder().withName("Marcin").withSurname("Wojtowicz")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).withAgencyTO(agency).build();

		EmployeeTO employeeTO3 = new EmployeeTO.EmployeeTOBuilder().withName("Arek").withSurname("Mila")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).withAgencyTO(agency2).build();

		CarTO car1 = new CarTO.CarTOBuilder().withCarType("SEDAN").withBrand("Mazda").withColor("Blue").withEngineCapacity(1.6)
				.withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

		CarTO car2 = new CarTO.CarTOBuilder().withCarType("COUPE").withBrand("Audi").withColor("Brown").withEngineCapacity(1.6)
				.withHorsepower(170).withMilleage(353456.0).withProductionYear(new Timestamp(time)).build();

		CarTO car3 = new CarTO.CarTOBuilder().withCarType("SUV").withBrand("Mazda").withColor("Yellow").withEngineCapacity(1.6)
				.withHorsepower(160).withMilleage(53143.0).withProductionYear(new Timestamp(time)).build();

		CarTO car4 = new CarTO.CarTOBuilder().withCarType("SUV").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
				.withHorsepower(252).withMilleage(2200.0).withProductionYear(new Timestamp(time)).build();

		CarTO car5 = new CarTO.CarTOBuilder().withCarType("SEDAN").withBrand("Mercedes").withColor("Blue").withEngineCapacity(1.6)
				.withHorsepower(184).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

		CarTO car6 = new CarTO.CarTOBuilder().withCarType("SUV").withBrand("Mazda").withColor("Red").withEngineCapacity(1.6)
				.withHorsepower(145).withMilleage(1250.0).withProductionYear(new Timestamp(time)).build();

		// when
		CarTO savedCar1 = carService.saveCar(car1);
		CarTO savedCar2 = carService.saveCar(car2);
		CarTO savedCar3 = carService.saveCar(car3);
		CarTO savedCar4 = carService.saveCar(car4);
		CarTO savedCar5 = carService.saveCar(car5);
		CarTO savedCar6 = carService.saveCar(car6);

		EmployeeTO savedEmployee1=employeeService.saveEmployee(employeeTO1);
		EmployeeTO savedEmployee2=employeeService.saveEmployee(employeeTO2);
		EmployeeTO savedEmployee3=employeeService.saveEmployee(employeeTO3);

		carService.addCarToEmployee(savedCar1,savedEmployee1);
		carService.addCarToEmployee(savedCar3,savedEmployee1);
		carService.addCarToEmployee(savedCar5,savedEmployee1);
		carService.addCarToEmployee(savedCar1,savedEmployee2);
		carService.addCarToEmployee(savedCar2,savedEmployee2);
		carService.addCarToEmployee(savedCar3,savedEmployee2);
		carService.addCarToEmployee(savedCar4,savedEmployee2);
		carService.addCarToEmployee(savedCar5,savedEmployee3);
		carService.addCarToEmployee(savedCar6,savedEmployee3);
		carService.addCarToEmployee(savedCar3,savedEmployee3);
		carService.addCarToEmployee(savedCar2,savedEmployee3);

		//then

	}
}
