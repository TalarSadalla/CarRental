package com.capgemini.types;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RentalTO {

    private Long id;
    private Timestamp beginDate;
    private Timestamp endDate;
    private ClientTO clientTO;
    private CarTO carTO;
    private AgencyTO startAgencyTO;
    private AgencyTO endAgencyTO;


    public RentalTO(Long id, Timestamp beginDate, Timestamp endDate, ClientTO clientTO, CarTO carTO, AgencyTO startAgencyTO, AgencyTO endAgencyTO) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.clientTO = clientTO;
        this.carTO = carTO;
        this.startAgencyTO = startAgencyTO;
        this.endAgencyTO = endAgencyTO;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public ClientTO getClientTO() {
        return clientTO;
    }

    public CarTO getCarTO() {
        return carTO;
    }

    public AgencyTO getStartAgencyTO() {
        return startAgencyTO;
    }

    public AgencyTO getEndAgencyTO() {
        return endAgencyTO;
    }

    public static RentalTOBuilder builder() {
        return new RentalTOBuilder();
    }

    public static class RentalTOBuilder {

        private Long id;
        private Timestamp beginDate;
        private Timestamp endDate;
        private ClientTO clientTO;
        private CarTO carTO;
        private AgencyTO startAgencyTO;
        private AgencyTO endAgencyTO;

        public RentalTOBuilder() {
            super();
        }

    public RentalTOBuilder withBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
        return this;
    }

    public RentalTOBuilder withEndDate(Timestamp endDate) {
        this.endDate = endDate;
        return this;
    }

    public RentalTOBuilder withDClientTO(ClientTO clientTO) {
        this.clientTO = clientTO;
        return this;
    }

    public RentalTOBuilder withCarTO(CarTO carTO) {
        this.carTO = carTO;
        return this;
    }

    public RentalTOBuilder withStartAgencyTO(AgencyTO startAgencyTO) {
        this.startAgencyTO = startAgencyTO;
        return this;
    }

     public RentalTOBuilder withEndAgencyTO(AgencyTO endAgencyTO) {
            this.endAgencyTO = endAgencyTO;
            return this;
        }

        public RentalTO build() {
        checkBeforeBuild(beginDate, endDate, clientTO, carTO, startAgencyTO, endAgencyTO);
        return new RentalTO(id, beginDate, endDate, clientTO, carTO, startAgencyTO, endAgencyTO);
    }

    private void checkBeforeBuild(Timestamp beginDate, Timestamp endDate, ClientTO clientTO, CarTO carTO, AgencyTO startAgencyTO, AgencyTO endAgencyTO) {
        if (beginDate == null || endDate == null || clientTO == null || carTO == null || startAgencyTO == null || endAgencyTO == null) {
            throw new RuntimeException("Incorrect employee to be added");
        }

    }
}

    @Override
    public String toString() {
        return "RentalTO{" +
                "id=" + id +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", clientTO=" + clientTO +
                ", carTO=" + carTO +
                ", startAgencyTO=" + startAgencyTO +
                ", endAgencyTO=" + endAgencyTO +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((clientTO == null) ? 0 : clientTO.hashCode());
        result = prime * result + ((carTO == null) ? 0 : carTO.hashCode());
        result = prime * result + ((startAgencyTO == null) ? 0 : startAgencyTO.hashCode());
        result = prime * result + ((endAgencyTO == null) ? 0 : endAgencyTO.hashCode());
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
        RentalTO other = (RentalTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (beginDate == null) {
            if (other.beginDate != null)
                return false;
        } else if (!beginDate.equals(other.beginDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (clientTO == null) {
            if (other.clientTO != null)
                return false;
        } else if (!clientTO.equals(other.clientTO))
            return false;
        if (carTO == null) {
            if (other.carTO != null)
                return false;
        } else if (!carTO.equals(other.carTO))
            return false;
        if (startAgencyTO == null) {
            if (other.startAgencyTO != null)
                return false;
        } else if (!startAgencyTO.equals(other.startAgencyTO))
            return false;
        if (endAgencyTO == null) {
            if (other.endAgencyTO != null)
                return false;
        } else if (!endAgencyTO.equals(other.endAgencyTO))
            return false;
        return true;
    }
}
