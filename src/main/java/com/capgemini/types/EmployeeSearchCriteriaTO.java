package com.capgemini.types;

public class EmployeeSearchCriteriaTO {

    private Long agencyId;
    private Long carId;
    private Long employeePositionId;

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getEmployeePositionId() {
        return employeePositionId;
    }

    public void setEmployeePositionId(Long employeePositionId) {
        this.employeePositionId = employeePositionId;
    }
}
