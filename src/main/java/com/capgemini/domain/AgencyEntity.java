package com.capgemini.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AGENCY")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({OnCreateListener.class, OnUpdateListener.class})
public class AgencyEntity extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AGENCY_ID")
    private Long id;

    @Column(nullable = false, length = 150)
    private String contact;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity addressEntity;

    @OneToMany(targetEntity = RentalEntity.class, mappedBy = "startAgencyEntity", cascade = CascadeType.ALL)
    private Set<AgencyEntity> startAgencyEntitySet = new HashSet<>();

    @OneToMany(targetEntity = RentalEntity.class, mappedBy = "endAgencyEntity", cascade = CascadeType.ALL)
    private Set<AgencyEntity> endAgencyEntitySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Set<AgencyEntity> getStartAgencyEntitySet() {
        return startAgencyEntitySet;
    }

    public void setStartAgencyEntitySet(Set<AgencyEntity> startAgencyEntitySet) {
        this.startAgencyEntitySet = startAgencyEntitySet;
    }

    public Set<AgencyEntity> getEndAgencyEntitySet() {
        return endAgencyEntitySet;
    }

    public void setEndAgencyEntitySet(Set<AgencyEntity> endAgencyEntitySet) {
        this.endAgencyEntitySet = endAgencyEntitySet;
    }
}
