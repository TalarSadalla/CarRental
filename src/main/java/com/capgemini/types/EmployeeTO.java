package com.capgemini.types;

import com.capgemini.domain.CarEntity;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeTO {

    private Long id;
    private String name;
    private String surname;
    private Timestamp dateOfBirth;
    private AddressTO addressTO;
    private EmployeePositionTO employeePositionTO;
    private AgencyTO agencyTO;
    private Set<CarTO> carTOSet = new HashSet<>();

    public EmployeeTO(Long id, String name, String surname, Timestamp dateOfBirth, AddressTO addressTO, EmployeePositionTO employeePositionTO, AgencyTO agencyTO, Set<CarTO> carTOSet) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.addressTO = addressTO;
        this.employeePositionTO = employeePositionTO;
        this.agencyTO = agencyTO;
        this.carTOSet = carTOSet;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public AddressTO getAddressTO() {
        return addressTO;
    }

    public EmployeePositionTO getEmployeePositionTO() {
        return employeePositionTO;
    }

    public AgencyTO getAgencyTO() {
        return agencyTO;
    }

    public Set<CarTO> getCarTOSet() {
        return carTOSet;
    }

    public static EmployeeTOBuilder builder() {
        return new EmployeeTOBuilder();
    }

    public static class EmployeeTOBuilder {

        private Long id;
        private String name;
        private String surname;
        private Timestamp dateOfBirth;
        private AddressTO addressTO;
        private EmployeePositionTO employeePositionTO;
        private AgencyTO agencyTO;
        private Set<CarTO> carTOSet = new HashSet<>();


        public EmployeeTOBuilder() {
            super();
        }

        public EmployeeTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeTOBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public EmployeeTOBuilder withDateOfBirth(Timestamp dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public EmployeeTOBuilder withAddressTO(AddressTO addressTO) {
            this.addressTO = addressTO;
            return this;
        }

        public EmployeeTOBuilder withEmployeePositionTO(EmployeePositionTO employeePositionTO) {
            this.employeePositionTO = employeePositionTO;
            return this;
        }

        public EmployeeTOBuilder withAgencyTO(AgencyTO agencyTO) {
            this.agencyTO = agencyTO;
            return this;
        }

        public EmployeeTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeTOBuilder withCarSet(Set<CarTO> carTOSet) {
            this.carTOSet.addAll(carTOSet);
            return this;
        }

        public EmployeeTO build() {
            checkBeforeBuild(name, surname, dateOfBirth, addressTO, employeePositionTO, agencyTO, carTOSet);
            return new EmployeeTO(id, name, surname, dateOfBirth, addressTO, employeePositionTO, agencyTO, carTOSet);
        }

        private void checkBeforeBuild(String name, String surname, Timestamp dateOfBirth, AddressTO addressTO, EmployeePositionTO employeePositionTO, AgencyTO agencyTO, Set<CarTO> carTOSet) {
            if (CollectionUtils.isEmpty(carTOSet) || name == null || name.isEmpty() || surname == null || surname.isEmpty() || dateOfBirth == null || addressTO == null || employeePositionTO == null || agencyTO == null) {
                throw new RuntimeException("Incorrect employee to be added");
            }

        }
    }

    @Override
    public String toString() {
        return "EmployeeTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", addressTO=" + addressTO +
                ", employeePositionTO=" + employeePositionTO +
                ", agencyTO=" + agencyTO +
                ", carTOSet=" + carTOSet +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((addressTO == null) ? 0 : addressTO.hashCode());
        result = prime * result + ((employeePositionTO == null) ? 0 : employeePositionTO.hashCode());
        result = prime * result + ((agencyTO == null) ? 0 : agencyTO.hashCode());
        result = prime * result + ((carTOSet == null) ? 0 : carTOSet.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeeTO other = (EmployeeTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (addressTO == null) {
            if (other.addressTO != null)
                return false;
        } else if (!addressTO.equals(other.addressTO))
            return false;
        if (employeePositionTO == null) {
            if (other.employeePositionTO != null)
                return false;
        } else if (!employeePositionTO.equals(other.employeePositionTO))
            return false;
        if (agencyTO == null) {
            if (other.agencyTO != null)
                return false;
        } else if (!agencyTO.equals(other.agencyTO))
            return false;
        if (carTOSet == null) {
            if (other.carTOSet != null)
                return false;
        } else if (!carTOSet.equals(other.carTOSet))
            return false;
        return true;
    }
}
