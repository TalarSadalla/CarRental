package com.capgemini.service;


import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.types.AddressTO;
import com.capgemini.types.AddressTO.AddressTOBuilder;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.AgencyTO.AgencyTOBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Transactional
    public void testShouldAddCar() {

        // given
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/01/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();

        CarTO car = new CarTOBuilder().withCarType("SEDAN").withBrand("Audi").withColor("RED").withEngineCapacity(2.0)
                .withHorsepower(170).withMilleage(12500.0).withProductionYear(new Timestamp(time)).build();
        CarTO savedCar = carService.saveCar(car);

        // when
        carService.addCar(car);
        CarTO selectedCar = carService.findCarById(savedCar.getId());
        // then
        assertTrue(carService.addCar(car));
        assertEquals(savedCar.getBrand(), selectedCar.getBrand());
    }

    @Test
    @Transactional
    public void testShouldSaveCar() {

        // given
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/05/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();

        CarTO car = new CarTOBuilder().withCarType("SEDAN").withBrand("Audi").withColor("RED").withEngineCapacity(2.0)
                .withHorsepower(170).withMilleage(12500.0).withProductionYear(new Timestamp(time)).build();
        CarTO car1 = new CarTOBuilder().withCarType("COUPE").withBrand("Mercedes").withColor("Yellow").withEngineCapacity(1.8)
                .withHorsepower(120).withMilleage(1500.0).withProductionYear(new Timestamp(time)).build();
        CarTO car2 = new CarTOBuilder().withCarType("SUV").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();
        CarTO savedCar = carService.saveCar(car);
        CarTO savedCar1 = carService.saveCar(car1);
        CarTO savedCar2 = carService.saveCar(car2);

        // when
        carService.addCar(car);
        carService.addCar(car1);
        carService.addCar(car2);
        CarTO selectedCar = carService.findCarById(savedCar.getId());

        CarTO selectedCar1 = carService.findCarById(savedCar1.getId());

        CarTO selectedCar2 = carService.findCarById(savedCar2.getId());
        // then
        assertTrue(carService.addCar(car));
        assertEquals(savedCar.getBrand(), selectedCar.getBrand());
        assertEquals(savedCar.getCarType(), selectedCar.getCarType());
        assertEquals(savedCar1.getBrand(), selectedCar1.getBrand());
        assertEquals(savedCar1.getCarType(), selectedCar1.getCarType());
        assertEquals(savedCar2.getBrand(), selectedCar2.getBrand());
        assertEquals(savedCar2.getCarType(), selectedCar2.getCarType());
    }


    @Test
    @Transactional
    public void testShouldDeleteCar() {

        // given
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/05/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();

        CarTO car = new CarTOBuilder().withCarType("SEDAN").withBrand("Audi").withColor("RED").withEngineCapacity(2.0)
                .withHorsepower(170).withMilleage(12500.0).withProductionYear(new Timestamp(time)).build();
        CarTO car1 = new CarTOBuilder().withCarType("SEDAN").withBrand("Mercedes").withColor("Yellow").withEngineCapacity(1.8)
                .withHorsepower(120).withMilleage(1500.0).withProductionYear(new Timestamp(time)).build();
        CarTO car2 = new CarTOBuilder().withCarType("SEDAN").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        // when
        CarTO savedCar = carService.saveCar(car);
        CarTO savedCar1 = carService.saveCar(car1);
        CarTO savedCar2 = carService.saveCar(car2);

        carService.deleteCarById(savedCar1.getId());

        CarTO selectedCar = carService.findCarById(savedCar.getId());
        CarTO selectedCar1 = carService.findCarById(savedCar1.getId());
        // then
        assertTrue(carService.deleteCar(savedCar1));

        assertEquals(savedCar.getBrand(), selectedCar.getBrand());
        assertEquals(savedCar.getCarType(), selectedCar.getCarType());
        assertEquals(null, carService.findCarById(savedCar1.getId()));
    }

    @Test
    @Transactional
    public void testShouldEditCar() {

        // given
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/05/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        CarTO car2 = new CarTOBuilder().withCarType("SEDAN").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        // when
        CarTO savedCar2 = carService.saveCar(car2);

        CarTO selectedCar = carService.findCarById(savedCar2.getId());

        CarTO carToUpdate = new CarTOBuilder().withId(selectedCar.getId()).withCarType("SEDAN")
                .withBrand("Mazda").withColor("Black").withEngineCapacity(2.0)
                .withHorsepower(165).withMilleage(55500.0).withProductionYear(new Timestamp(time)).build();

       CarTO editedCar= carService.editCar(carToUpdate);
        selectedCar = carService.findCarById(editedCar.getId());
        // then


        assertEquals("Mazda", selectedCar.getBrand());
        assertEquals("Black", selectedCar.getColor());
        assertEquals(carToUpdate.getMilleage(), selectedCar.getMilleage(),1.0);
    }

    @Test
    @Transactional
    public void testShouldAddCarToEmployee() {

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

        EmployeeTO employeeTO = new EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
                .withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();


        CarTO car2 = new CarTOBuilder().withCarType("SEDAN").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        // when
        CarTO savedCar2 = carService.saveCar(car2);
        EmployeeTO savedEmployee=employeeService.saveEmployee(employeeTO);

        carService.addCarToEmployee(savedCar2,savedEmployee);

        CarTO selectedCar = carService.findCarById(savedCar2.getId());

        CarTO carToUpdate = new CarTOBuilder().withId(selectedCar.getId()).withCarType("SEDAN")
                .withBrand("Mazda").withColor("Black").withEngineCapacity(2.0)
                .withHorsepower(165).withMilleage(55500.0).withProductionYear(new Timestamp(time)).build();

        CarTO editedCar= carService.editCar(carToUpdate);
        selectedCar = carService.findCarById(editedCar.getId());
        // then


        assertEquals("Mazda", selectedCar.getBrand());
        assertEquals("Black", selectedCar.getColor());
        assertEquals(carToUpdate.getMilleage(), selectedCar.getMilleage(),1.0);
    }

    @Test
    @Transactional
    public void testShouldFindCarByType() {

        // given
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/05/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();

        CarTO car1 = new CarTOBuilder().withCarType("SEDAN").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        CarTO car2 = new CarTOBuilder().withCarType("SUV").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        CarTO car3 = new CarTOBuilder().withCarType("SEDAN").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        // when
        CarTO savedCar1 = carService.saveCar(car1);
        CarTO savedCar2 = carService.saveCar(car2);
        CarTO savedCar3 = carService.saveCar(car3);

        List<CarTO> selectedCarSet = carService.findCarByType(car1);
        // then


        assertEquals(2, selectedCarSet.size());
        assertEquals("SEDAN", selectedCarSet.iterator().next().getCarType());
    }


    @Test
    @Transactional
    public void testShouldFindCarByTypeAndBrand() {

        // given
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/05/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();

        CarTO car1 = new CarTOBuilder().withCarType("SEDAN").withBrand("Mazda").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        CarTO car2 = new CarTOBuilder().withCarType("COUPE").withBrand("Audi").withColor("Brown").withEngineCapacity(1.6)
                .withHorsepower(170).withMilleage(353456.0).withProductionYear(new Timestamp(time)).build();

        CarTO car3 = new CarTOBuilder().withCarType("SUV").withBrand("Mazda").withColor("Yellow").withEngineCapacity(1.6)
                .withHorsepower(160).withMilleage(53143.0).withProductionYear(new Timestamp(time)).build();

        CarTO car4 = new CarTOBuilder().withCarType("SUV").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(252).withMilleage(2200.0).withProductionYear(new Timestamp(time)).build();

        CarTO car5 = new CarTOBuilder().withCarType("SEDAN").withBrand("Mercedes").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(184).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        CarTO car6 = new CarTOBuilder().withCarType("SUV").withBrand("Mazda").withColor("Red").withEngineCapacity(1.6)
                .withHorsepower(145).withMilleage(1250.0).withProductionYear(new Timestamp(time)).build();

        // when
        CarTO savedCar1 = carService.saveCar(car1);
        CarTO savedCar2 = carService.saveCar(car2);
        CarTO savedCar3 = carService.saveCar(car3);
        CarTO savedCar4 = carService.saveCar(car4);
        CarTO savedCar5 = carService.saveCar(car5);
        CarTO savedCar6 = carService.saveCar(car6);

        List<CarTO> selectedCarSet = carService.findCarByTypeAndBrand(car3);
        // then

        assertEquals(2, selectedCarSet.size());
        assertEquals("SUV", selectedCarSet.iterator().next().getCarType());
        assertEquals("Mazda", selectedCarSet.iterator().next().getBrand());
    }


    @Test
    @Transactional
    public void testShouldFindCarByEmployee() {

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

        EmployeeTO employeeTO1 = new EmployeeTOBuilder().withName("Talar").withSurname("Sadalla")
                .withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

        EmployeeTO employeeTO2 = new EmployeeTOBuilder().withName("Marcin").withSurname("Wojtowicz")
                .withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();

        EmployeeTO employeeTO3 = new EmployeeTOBuilder().withName("Arek").withSurname("Mila")
                .withDateOfBirth(new Timestamp(employeeDateOfBirth)).build();


        CarTO car1 = new CarTOBuilder().withCarType("SEDAN").withBrand("Mazda").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(132).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        CarTO car2 = new CarTOBuilder().withCarType("COUPE").withBrand("Audi").withColor("Brown").withEngineCapacity(1.6)
                .withHorsepower(170).withMilleage(353456.0).withProductionYear(new Timestamp(time)).build();

        CarTO car3 = new CarTOBuilder().withCarType("SUV").withBrand("Mazda").withColor("Yellow").withEngineCapacity(1.6)
                .withHorsepower(160).withMilleage(53143.0).withProductionYear(new Timestamp(time)).build();

        CarTO car4 = new CarTOBuilder().withCarType("SUV").withBrand("Porsche").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(252).withMilleage(2200.0).withProductionYear(new Timestamp(time)).build();

        CarTO car5 = new CarTOBuilder().withCarType("SEDAN").withBrand("Mercedes").withColor("Blue").withEngineCapacity(1.6)
                .withHorsepower(184).withMilleage(100.0).withProductionYear(new Timestamp(time)).build();

        CarTO car6 = new CarTOBuilder().withCarType("SUV").withBrand("Mazda").withColor("Red").withEngineCapacity(1.6)
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

        List<CarTO> carList=carService.findCarByEmployee(savedEmployee1);
        List<CarTO> carList2=carService.findCarByEmployee(savedEmployee3);

        // then
        assertEquals(2, carList.size());
        assertEquals(0, carList2.size());
        assertEquals("Mazda",carList2.iterator().next().getBrand());
        assertEquals("SUV",carList2.iterator().next().getCarType());
    }



}
