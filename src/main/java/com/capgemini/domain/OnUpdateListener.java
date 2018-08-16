package com.capgemini.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.sql.Timestamp;
import java.util.Date;

public class OnUpdateListener {

    @PreUpdate
    protected void onUpdate(AbstractEntity abstractEntity) {
        Date updateDate= new Date();
        abstractEntity.setUpdated(new Timestamp(updateDate.getTime()));
    }

}
