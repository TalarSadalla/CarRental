package com.capgemini.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@EntityListeners({OnCreateListener.class , OnUpdateListener.class})
//extends AbstractEntity
public class EmployeeEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(nullable = false)
    private Timestamp dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ADDRESS_ID")
    private AddressEntity addressEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AGENCY_ID")
    private AgencyEntity agencyEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="JOB_TITLE_ID")
    private EmployeePositionEntity employeePositionEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name ="CAR_CARER",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id")}
    )
    private Set<CarEntity> carEntitySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public EmployeePositionEntity getEmployeePositionEntity() {
        return employeePositionEntity;
    }

    public void setEmployeePositionEntity(EmployeePositionEntity employeePositionEntity) {
        this.employeePositionEntity = employeePositionEntity;
    }

    public AgencyEntity getAgencyEntity() {
        return agencyEntity;
    }

    public void setAgencyEntity(AgencyEntity agencyEntity) {
        this.agencyEntity = agencyEntity;
    }

    public Set<CarEntity> getCarEntitySet() {
        return carEntitySet;
    }

    public void setCarEntitySet(Set<CarEntity> carEntitySet) {
        this.carEntitySet = carEntitySet;
    }
}
