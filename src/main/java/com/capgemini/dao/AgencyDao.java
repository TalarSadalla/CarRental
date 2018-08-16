package com.capgemini.dao;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.BookEntity;
import com.capgemini.domain.EmployeeEntity;

import java.util.List;

public interface AgencyDao extends Dao<AgencyEntity, Long> {

    AgencyEntity addAgency(AgencyEntity agencyEntity);

    AgencyEntity editAgency(AgencyEntity agencyEntity);

    void deleteAgency(Long agencyId);

    void deleteAgency(AgencyEntity agencyEntity);

}
