package com.capgemini.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.sql.Timestamp;
import java.util.Date;

public class OnCreateListener {

    @PrePersist
    protected void onCreate(AbstractEntity abstractEntity) {
        Date creationDate= new Date();
        abstractEntity.setCreated(new Timestamp(creationDate.getTime()));
    }

}
