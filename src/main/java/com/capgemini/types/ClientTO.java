package com.capgemini.types;


import com.capgemini.domain.ClientEntity;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ClientTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Timestamp dateOfBirth;
    private String creditCardNumber;
    private String phoneNumber;
    private AddressTO addressTO;
    private Set<ClientTO> clientTOSet = new HashSet<>();

    public ClientTO(Long id, String name, String surname, String email, Timestamp dateOfBirth, String creditCardNumber, String phoneNumber, AddressTO addressTO, Set<ClientTO> clientTOSet) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.creditCardNumber = creditCardNumber;
        this.phoneNumber = phoneNumber;
        this.addressTO = addressTO;
        this.clientTOSet=clientTOSet;
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

    public String getEmail() {
        return email;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public AddressTO getAddressTO() {
        return addressTO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<ClientTO> getClientTOSet() {
        return clientTOSet;
    }

    public static ClientTOBuilder builder() {
        return new ClientTOBuilder();
    }

    public static class ClientTOBuilder {

        private Long id;
        private String name;
        private String surname;
        private String email;
        private Timestamp dateOfBirth;
        private String creditCardNumber;
        private String phoneNumber;
        private AddressTO addressTO;
        private Set<ClientTO> clientTOSet = new HashSet<>();

        public ClientTOBuilder() {
            super();
        }

        public ClientTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ClientTOBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ClientTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ClientTOBuilder withDateOfBirth(Timestamp dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public ClientTOBuilder withCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
            return this;
        }

        public ClientTOBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ClientTOBuilder withAddressTO(AddressTO addressTO) {
            this.addressTO = addressTO;
            return this;
        }

        public ClientTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ClientTOBuilder withClientTO(Set<ClientTO> clientTOSet) {
            this.clientTOSet.addAll(clientTOSet);
            return this;
        }

        public ClientTO build() {
            checkBeforeBuild(name, surname, email, dateOfBirth, creditCardNumber, phoneNumber, addressTO,clientTOSet);
            return new ClientTO(id, name, surname, email, dateOfBirth, creditCardNumber, phoneNumber, addressTO,clientTOSet);
        }

        private void checkBeforeBuild(String name, String surname, String email, Timestamp dateOfBirth, String creditCardNumber, String phoneNumber, AddressTO addressTO,Set<ClientTO> clientTOSet) {
            if (CollectionUtils.isEmpty(clientTOSet)|| name == null || name.isEmpty() || surname == null || surname.isEmpty() || email == null || email.isEmpty() || dateOfBirth == null || creditCardNumber == null || creditCardNumber.isEmpty() || phoneNumber == null || phoneNumber.isEmpty() || addressTO == null) {
                throw new RuntimeException("Incorrect client to be added");
            }

        }
    }

    @Override
    public String toString() {
        return "ClientTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressTO=" + addressTO +
                ", clientTOSet=" + clientTOSet +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((creditCardNumber == null) ? 0 : creditCardNumber.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((addressTO == null) ? 0 : addressTO.hashCode());
        result = prime * result + ((clientTOSet == null) ? 0 : clientTOSet.hashCode());
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
        ClientTO other = (ClientTO) obj;
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
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (creditCardNumber == null) {
            if (other.creditCardNumber != null)
                return false;
        } else if (!creditCardNumber.equals(other.creditCardNumber))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (addressTO == null) {
            if (other.addressTO != null)
                return false;
        } else if (!addressTO.equals(other.addressTO))
            return false;
        if (clientTOSet == null) {
            if (other.clientTOSet != null)
                return false;
        } else if (!clientTOSet.equals(other.clientTOSet))
            return false;
        return true;
    }
}
