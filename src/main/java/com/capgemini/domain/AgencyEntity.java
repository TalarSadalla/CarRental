package com.capgemini.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AGENCY")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@EntityListeners({OnCreateListener.class , OnUpdateListener.class})
//extends AbstractEntity
public class AgencyEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AGENCY_ID")
    private Long id;

    @Column(nullable = false, length = 150)
    private String contact;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity addressEntity;


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

}
