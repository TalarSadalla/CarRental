package com.capgemini.types;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class CarTO {

    private Long id;
    private String carType;
    private String brand;
    private Timestamp productionYear;
    private String color;
    private double engineCapacity;
    private int horsepower;
    private double milleage;
    private AgencyTO agencyTO;
    private Set<CarTO> carTOSet = new HashSet<>();
    private Set<EmployeeTO> employeeTOSet = new HashSet<>();

    public CarTO(Long id, String carType, String brand, Timestamp productionYear, String color, double engineCapacity, int horsepower, double milleage, AgencyTO agencyTO, Set<CarTO> carTOSet, Set<EmployeeTO> employeeTOSet) {
        this.id = id;
        this.carType = carType;
        this.brand = brand;
        this.productionYear = productionYear;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.horsepower = horsepower;
        this.milleage = milleage;
        this.agencyTO = agencyTO;
        this.carTOSet = carTOSet;
        this.employeeTOSet = employeeTOSet;
    }

    public Long getId() {
        return id;
    }

    public String getCarType() {
        return carType;
    }

    public String getBrand() {
        return brand;
    }

    public Timestamp getProductionYear() {
        return productionYear;
    }

    public String getColor() {
        return color;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public double getMilleage() {
        return milleage;
    }

    public AgencyTO getAgencyTO() {
        return agencyTO;
    }

    public Set<CarTO> getCarTOSet() {
        return carTOSet;
    }

    public Set<EmployeeTO> getEmployeeTOSet() {
        return employeeTOSet;
    }

    public static CarTOBuilder builder() {
        return new CarTOBuilder();
    }

    public static class CarTOBuilder {

        private Long id;
        private String carType;
        private String brand;
        private Timestamp productionYear;
        private String color;
        private double engineCapacity;
        private int horsepower;
        private double milleage;
        private AgencyTO agencyTO;
        private Set<CarTO> carTOSet = new HashSet<>();
        private Set<EmployeeTO> employeeTOSet = new HashSet<>();

        public CarTOBuilder() {
            super();
        }

        public CarTOBuilder withAgencyTO(AgencyTO agencyTO) {
            this.agencyTO = agencyTO;
            return this;
        }

        public CarTOBuilder withCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public CarTOBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarTOBuilder withProductionYear(Timestamp productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public CarTOBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarTOBuilder withEngineCapacity(double engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public CarTOBuilder withHorsepower(int horsepower) {
            this.horsepower = horsepower;
            return this;
        }

        public CarTOBuilder withMilleage(Double milleage) {
            this.milleage = milleage;
            return this;
        }

        public CarTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CarTOBuilder withCarTO(Set<CarTO> CarSet) {
            this.carTOSet.addAll(CarSet);
            return this;
        }

        public CarTOBuilder withEmployeeTO(Set<EmployeeTO> employeeSet) {
            this.employeeTOSet.addAll(employeeSet);
            return this;
        }

        public CarTO build() {
            checkBeforeBuild(carType, brand, productionYear, color, engineCapacity, horsepower, milleage, agencyTO, carTOSet, employeeTOSet);
            return new CarTO(id, carType, brand, productionYear, color, engineCapacity, horsepower, milleage, agencyTO, carTOSet, employeeTOSet);
        }

        private void checkBeforeBuild(String carType, String brand, Timestamp productionYear, String color, double engineCapacity, int horsepower, double milleage, AgencyTO agencyTO,Set<CarTO> carSet,Set<EmployeeTO> employeeSet) {
            if (CollectionUtils.isEmpty(carSet) || CollectionUtils.isEmpty(employeeSet) || carType == null || carType.isEmpty() || brand == null || brand.isEmpty() || productionYear == null || color == null || color.isEmpty() || engineCapacity < 0 || engineCapacity > 30 || horsepower < 0 || horsepower > 3000 || milleage < 0 || agencyTO == null) {
                throw new RuntimeException("Incorrect car to be created");
            }

        }
    }

    @Override
    public String toString() {
        return "CarTO{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", color='" + color + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", horsepower=" + horsepower +
                ", milleage=" + milleage +
                ", agencyTO=" + agencyTO +
                ", carTOSet=" + carTOSet +
                ", EmployeeTOSet=" + employeeTOSet +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((carType == null) ? 0 : carType.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((productionYear == null) ? 0 : productionYear.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((engineCapacity < 0 || engineCapacity > 30) ? 0 : Double.hashCode(engineCapacity));
        result = prime * result + ((horsepower < 0 || horsepower > 3000) ? 0 : Integer.hashCode(horsepower));
        result = prime * result + ((milleage < 0) ? 0 : Double.hashCode(milleage));
        result = prime * result + ((agencyTO == null) ? 0 : agencyTO.hashCode());
        result = prime * result + ((carTOSet == null) ? 0 :  carTOSet.hashCode());
        result = prime * result + ((employeeTOSet == null) ? 0 :  employeeTOSet.hashCode());
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
        CarTO other = (CarTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (carType == null) {
            if (other.carType != null)
                return false;
        } else if (!carType.equals(other.carType))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (productionYear == null) {
            if (other.productionYear != null)
                return false;
        } else if (!productionYear.equals(other.productionYear))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (engineCapacity < 0 || engineCapacity > 30) {
            if (other.engineCapacity > 0 || other.engineCapacity < 30)
                return false;
        } else if (engineCapacity != (other.engineCapacity))
            return false;
        if (horsepower < 0 || horsepower > 3000) {
            if (other.horsepower > 0 || other.horsepower < 3000)
                return false;
        } else if (horsepower != (other.horsepower))
            return false;
        if (milleage < 0) {
            if (other.horsepower > 0)
                return false;
        } else if (milleage != (other.milleage))
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
        if (employeeTOSet == null) {
            if (other.employeeTOSet != null)
                return false;
        } else if (!employeeTOSet.equals(other.employeeTOSet))
            return false;
        return true;
    }
}
