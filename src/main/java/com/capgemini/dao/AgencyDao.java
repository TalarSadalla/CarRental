package com.capgemini.dao;

import com.capgemini.domain.AgencyEntity;

public interface AgencyDao extends Dao<AgencyEntity, Long> {

    AgencyEntity addAgency(AgencyEntity agencyEntity);

    AgencyEntity editAgency(AgencyEntity agencyEntity);

    void deleteAgency(Long agencyId);

    void deleteAgency(AgencyEntity agencyEntity);

}
