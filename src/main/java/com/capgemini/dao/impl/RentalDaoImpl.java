package com.capgemini.dao.impl;

import com.capgemini.dao.BookDao;
import com.capgemini.dao.RentalDao;
import com.capgemini.domain.BookEntity;
import com.capgemini.domain.RentalEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RentalDaoImpl extends AbstractDao<RentalEntity, Long> implements RentalDao {

}
