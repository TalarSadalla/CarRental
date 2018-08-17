package com.capgemini.types;

import com.capgemini.domain.AddressEntity;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class AgencyTO {

    private Long id;
    private String contact;
    private AddressTO addressTO;
    private Set<AgencyTO> startAgencyTOSet;
    private Set<AgencyTO> endAgencyTOSet;

    public AgencyTO(Long id, String contact, AddressTO addressTO, Set<AgencyTO> startAgencyTOSet, Set<AgencyTO> endAgencyTOSet) {
        this.id = id;
        this.addressTO = addressTO;
        this.contact = contact;
        this.startAgencyTOSet = startAgencyTOSet;
        this.endAgencyTOSet = endAgencyTOSet;
    }

    public Long getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public AddressTO getAddressTO() {
        return addressTO;
    }

    public Set<AgencyTO> getStartAgencyTOSet() {
        return startAgencyTOSet;
    }

    public Set<AgencyTO> getEndAgencyTOSet() {
        return endAgencyTOSet;
    }

    public static AgencyTOBuilder builder() {
        return new AgencyTOBuilder();
    }

    public static class AgencyTOBuilder {

        private Long id;
        private String contact;
        private AddressTO addressTO;
        private Set<AgencyTO> startAgencyTOSet = new HashSet<>();
        private Set<AgencyTO> endAgencyTOSet = new HashSet<>();

        public AgencyTOBuilder() {
            super();
        }

        public AgencyTOBuilder withAddressId(AddressTO addressTO) {
            this.addressTO = addressTO;
            return this;
        }

        public AgencyTOBuilder withContact(String contact) {
            this.contact = contact;
            return this;
        }

        public AgencyTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AgencyTOBuilder withStartAgencyTO(Set<AgencyTO> startAgencySet) {
            this.startAgencyTOSet.addAll(startAgencySet);
            return this;
        }

        public AgencyTOBuilder withEndAgencyTO(Set<AgencyTO> endAgencySet) {
            this.endAgencyTOSet.addAll(endAgencySet);
            return this;
        }

        public AgencyTO build() {
            checkBeforeBuild(contact);
            return new AgencyTO(id,contact, addressTO, startAgencyTOSet, endAgencyTOSet);
        }

        private void checkBeforeBuild(String contact) {
            if (contact == null || contact.isEmpty()) {
                throw new RuntimeException("Incorrect agency to be created");
            }
        }
    }

    @Override
    public String toString() {
        return "AgencyTO{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", addressTO=" + addressTO +
                ", startAgencyTOSet=" + startAgencyTOSet +
                ", endAgencyTOSet=" + endAgencyTOSet +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((addressTO == null) ? 0 : addressTO.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result + ((startAgencyTOSet == null) ? 0 : startAgencyTOSet.hashCode());
        result = prime * result + ((endAgencyTOSet == null) ? 0 : endAgencyTOSet.hashCode());
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
        AgencyTO other = (AgencyTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (addressTO == null) {
            if (other.addressTO != null)
                return false;
        } else if (!addressTO.equals(other.addressTO))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        if (startAgencyTOSet == null) {
            if (other.startAgencyTOSet != null)
                return false;
        } else if (!startAgencyTOSet.equals(other.startAgencyTOSet))
            return false;
        if (endAgencyTOSet == null) {
            if (other.endAgencyTOSet != null)
                return false;
        } else if (!endAgencyTOSet.equals(other.endAgencyTOSet))
            return false;
        return true;
    }
}
