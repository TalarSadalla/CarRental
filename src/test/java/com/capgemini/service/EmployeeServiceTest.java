package com.capgemini.service;


import com.capgemini.types.*;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;
import com.capgemini.types.EmployeePositionTO.EmployeePositionTOBuilder;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class EmployeeServiceTest {


	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AgencyService agencyService;

	@Autowired
	private EmployeePositionService employeePositionService;

	@Autowired
	private CarService carService;

	@Test
	@Transactional
	public void testShouldAddEmployee() {


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

		AgencyTO agency=new AgencyTO.AgencyTOBuilder().withContact("660461470").build();
		AgencyTO agency2=new AgencyTO.AgencyTOBuilder().withContact("6850329").build();
		agencyService.addAgency(agency);
		agencyService.addAgency(agency2);

		EmployeeTO employeeTO1 = new EmployeeTO.EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeeTO employeeTO2 = new EmployeeTO.EmployeeTOBuilder().withName("Marcin").withSurname("Wojtowicz")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeeTO employeeTO3 = new EmployeeTO.EmployeeTOBuilder().withName("Arek").withSurname("Mila")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		//when

		EmployeeTO savedEmployee1=employeeService.saveEmployee(employeeTO1);
		EmployeeTO savedEmployee2=employeeService.saveEmployee(employeeTO2);
		EmployeeTO savedEmployee3=employeeService.saveEmployee(employeeTO3);

		//then

		assertEquals("Talar",employeeService.findEmployeeById(savedEmployee1.getId()).getName());
		assertEquals("Wojtowicz",employeeService.findEmployeeById(savedEmployee2.getId()).getSurname());
	}

	@Test
	@Transactional
	public void testShouldDeleteEmployee() {


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

		EmployeeTO employeeTO1 = new EmployeeTO.EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeeTO employeeTO2 = new EmployeeTO.EmployeeTOBuilder().withName("Marcin").withSurname("Wojtowicz")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeeTO employeeTO3 = new EmployeeTO.EmployeeTOBuilder().withName("Arek").withSurname("Mila")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		//when

		EmployeeTO savedEmployee1=employeeService.saveEmployee(employeeTO1);
		EmployeeTO savedEmployee2=employeeService.saveEmployee(employeeTO2);
		EmployeeTO savedEmployee3=employeeService.saveEmployee(employeeTO3);

		//then

		assertTrue(employeeService.deleteEmployeeById(savedEmployee3.getId()));
	}


	@Test
	@Transactional
	public void testShouldFindEmployeeByDifferentSearchCriteria() {

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

		AgencyTO agency=new AgencyTO.AgencyTOBuilder().withContact("660461470").build();
		AgencyTO agency2=new AgencyTO.AgencyTOBuilder().withContact("6850329").build();
		agencyService.addAgency(agency);
		agencyService.addAgency(agency2);


		EmployeeTO employeeTO1 = new EmployeeTO.EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeeTO employeeTO2 = new EmployeeTO.EmployeeTOBuilder().withName("Marcin").withSurname("Wojtowicz")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeeTO employeeTO3 = new EmployeeTO.EmployeeTOBuilder().withName("Arek").withSurname("Mila")
				.withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

		EmployeePositionTO employeePositionTO1 = new EmployeePositionTOBuilder().withJobTitle("MANAGER").build();
		EmployeePositionTO employeePositionTO2 = new EmployeePositionTOBuilder().withJobTitle("ACCOUNTANT").build();

		employeePositionService.savePosition(employeePositionTO1);
		employeePositionService.savePosition(employeePositionTO2);

		employeePositionTO1=employeePositionService.getPosition((long) 1);
		employeePositionTO2=employeePositionService.getPosition((long) 2);

		EmployeeTO savedEmployee1=employeeService.saveEmployee(employeeTO1);
		EmployeeTO savedEmployee2=employeeService.saveEmployee(employeeTO2);
		EmployeeTO savedEmployee3=employeeService.saveEmployee(employeeTO3);

		AgencyTO savedAgency=agencyService.saveAgency(agency);
		AgencyTO savedAgency2=agencyService.saveAgency(agency2);


		EmployeeTO updatedEmployee1=new EmployeeTO.EmployeeTOBuilder().withId(savedEmployee1.getId()).withName(savedEmployee1.getName()).withSurname(savedEmployee1.getSurname())
				.withDateOfBirth(savedEmployee1.getDateOfBirth()).withAgencyTO(savedAgency).withEmployeePositionTO(employeePositionTO1).build();
		EmployeeTO updatedEmployee2=new EmployeeTO.EmployeeTOBuilder().withId(savedEmployee2.getId()).withName(savedEmployee2.getName()).withSurname(savedEmployee2.getSurname())
				.withDateOfBirth(savedEmployee2.getDateOfBirth()).withAgencyTO(savedAgency).withEmployeePositionTO(employeePositionTO1).build();
		EmployeeTO updatedEmployee3=new EmployeeTO.EmployeeTOBuilder().withId(savedEmployee3.getId()).withName(savedEmployee3.getName()).withSurname(savedEmployee3.getSurname())
				.withDateOfBirth(savedEmployee3.getDateOfBirth()).withAgencyTO(savedAgency2).withEmployeePositionTO(employeePositionTO2).build();


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

		CarTO savedCar1 = carService.saveCar(car1);
		CarTO savedCar2 = carService.saveCar(car2);
		CarTO savedCar3 = carService.saveCar(car3);
		CarTO savedCar4 = carService.saveCar(car4);
		CarTO savedCar5 = carService.saveCar(car5);
		CarTO savedCar6 = carService.saveCar(car6);

		EmployeeSearchCriteriaTO employeeSearchCriteriaTO = new EmployeeSearchCriteriaTO();
		employeeSearchCriteriaTO.setAgencyId(agency.getId());
		employeeSearchCriteriaTO.setEmployeePositionId(employeePositionTO1.getId());

		//when

		List<EmployeeTO> employeeList=employeeService.findEmployeesBySearchCriteria(employeeSearchCriteriaTO);


		//then

		assertEquals(2, employeeList.size());
		assertEquals("Talar",employeeList.get(0));
	}


}
