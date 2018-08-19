package com.capgemini.service;


import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;
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

		assertEquals("Arek",employeeService.findEmployeeById(employeeTO3).getName());
		assertEquals("Wojtowicz",employeeService.findEmployeeById(employeeTO2).getSurname());
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

		employeeService.deleteEmployee(savedEmployee3);

		//then

		assertEquals(null,employeeService.findEmployeeById(savedEmployee3).getName());
	}


}
