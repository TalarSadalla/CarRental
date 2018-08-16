package com.capgemini.types;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.RentalEntity;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class AddressTO {

    private Long id;
    private String city;
    private String street;
    private String postCode;

    public AddressTO(Long id, String city, String street, String postCode) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public static AddressTOBuilder builder() {
        return new AddressTOBuilder();
    }

    public static class AddressTOBuilder {

        private Long id;
        private String city;
        private String street;
        private String postCode;

        public AddressTOBuilder() {
            super();
        }


        public AddressTOBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressTOBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressTOBuilder withPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public AddressTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }


        public AddressTO build() {
            checkBeforeBuild(city, street, postCode);
            return new AddressTO(id, city, street, postCode);
        }

        private void checkBeforeBuild(String city, String street, String postCode) {
            if (city == null || city.isEmpty() || street == null || street.isEmpty() || postCode == null || postCode.isEmpty()) {
                throw new RuntimeException("Incorrect address to be created");
            }
        }
    }

    @Override
    public String toString() {
        return "AddressTO{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());

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
        AddressTO other = (AddressTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        if (postCode == null) {
            if (other.postCode != null)
                return false;
        } else if (!postCode.equals(other.postCode))
            return false;
        return true;
    }
}
