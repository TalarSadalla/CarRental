package com.capgemini.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "RENTAL")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({OnCreateListener.class, OnUpdateListener.class})
public class RentalEntity extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Timestamp beginDate;

    @Column(nullable = false)
    private Timestamp endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID",nullable = false)
    private ClientEntity clientEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "CAR_ID",nullable = false)
    private CarEntity carEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "START_AGENCY_ID",nullable = false)
    private AgencyEntity startAgencyEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "END_AGENCY_ID",nullable = false)
    private AgencyEntity endAgencyEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    public AgencyEntity getStartAgencyEntity() {
        return startAgencyEntity;
    }

    public void setStartAgencyEntity(AgencyEntity startAngencyEntity) {
        this.startAgencyEntity = startAngencyEntity;
    }

    public AgencyEntity getEndAgencyEntity() {
        return endAgencyEntity;
    }

    public void setEndAgencyEntity(AgencyEntity endAngencyEntity) {
        this.endAgencyEntity = endAngencyEntity;
    }
}
