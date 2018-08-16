package com.capgemini.dao.impl;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.BookDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.BookEntity;
import com.capgemini.types.AgencyTO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AgencyDaoImpl extends AbstractDao<AgencyEntity, Long> implements AgencyDao {

    @Override
    public AgencyEntity addAgency(AgencyEntity agencyEntity) {
       save(agencyEntity);
       return agencyEntity;
    }

    @Override
    public AgencyEntity editAgency(AgencyEntity agencyEntity) {
        update(agencyEntity);
        return agencyEntity;
    }

    @Override
    public void deleteAgency(Long agencyId) {
        delete(agencyId);
    }

    @Override
    public void deleteAgency(AgencyEntity agencyEntity) {
        delete(agencyEntity);
    }
}
