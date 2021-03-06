package com.capgemini.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;


@Entity
@Table(name = "CAR")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@EntityListeners({OnCreateListener.class , OnUpdateListener.class})
//extends AbstractEntity
public class CarEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String carType;

    @Column(nullable = false, length = 50)
    private String brand;

    @Column(nullable = false, length = 50)
    private Timestamp productionYear;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false, length = 5)
    private double engineCapacity;

    @Column(nullable = false, length = 4)
    private int horsepower;

    @Column(nullable = false, length = 11)
    private double milleage;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "AGENCY_ID")
    private AgencyEntity agencyEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CAR_CARER",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private Set<EmployeeEntity> EmployeeEntitySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Timestamp getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Timestamp productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getMilleage() {
        return milleage;
    }

    public void setMilleage(double milleage) {
        this.milleage = milleage;
    }

    public AgencyEntity getAgencyEntity() {
        return agencyEntity;
    }

    public void setAgencyEntity(AgencyEntity agencyEntity) {
        this.agencyEntity = agencyEntity;
    }

    public Set<EmployeeEntity> getEmployeeEntitySet() {
        return EmployeeEntitySet;
    }

    public void setEmployeeEntitySet(Set<EmployeeEntity> employeeEntitySet) {
        EmployeeEntitySet = employeeEntitySet;
    }
}
