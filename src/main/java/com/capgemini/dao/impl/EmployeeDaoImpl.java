package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.types.EmployeeSearchCriteriaTO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

    @Override
    public void addEmployee(EmployeeEntity employeeEntity) {
        save(employeeEntity);
    }

    @Override
    public EmployeeEntity editEmployee(EmployeeEntity employeeEntity) {
        update(employeeEntity);
        return employeeEntity;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        delete(employeeId);
    }

    @Override
    public EmployeeEntity deleteEmployee(EmployeeEntity employeeEntity) {
        delete(employeeEntity);
        return employeeEntity;
    }

    @Override
    public EmployeeEntity findEmployeeById(Long employeeId) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select e from EmployeeEntity e where e.id=:employeeId", EmployeeEntity.class);
        query.setParameter("employeeId", employeeId);
        return query.getSingleResult();
    }

    @Override
    public void addEmployeeToAgency(EmployeeEntity employeeEntity, AgencyEntity agencyEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select e from EmployeeEntity e where e.id =:id", EmployeeEntity.class);
        query.setParameter("id", employeeEntity.getId());
        EmployeeEntity foundEmployee = query.getSingleResult();
        foundEmployee.setAgencyEntity(agencyEntity);
        update(foundEmployee);
    }

    @Override
    public EmployeeEntity removeEmployeeFromAgency(EmployeeEntity employeeEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select e from EmployeeEntity e where e.id =:id", EmployeeEntity.class);
        query.setParameter("id", employeeEntity.getId());
        EmployeeEntity foundEmployee = query.getSingleResult();
        foundEmployee.setAgencyEntity(null);
        update(foundEmployee);
        return foundEmployee;
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeFromOneAgency(Long agencyId) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select e from EmployeeEntity e where e.agencyEntity =:agencyId", EmployeeEntity.class);
        query.setParameter("agencyId", agencyId);
        return query.getResultList();
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeFromOneAgencyForSpecificCar(AgencyEntity agencyEntity, CarEntity carEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select e from EmployeeEntity e where e.carEntitySet.id=:carId AND e.agencyEntity =:agencyId", EmployeeEntity.class);
        query.setParameter("carId", carEntity.getId());
        query.setParameter("agencyId", agencyEntity.getId());
        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarByEmployee(EmployeeEntity employeeEntity) {
        Query query = entityManager.createQuery(
                "SELECT e.carEntitySet FROM EmployeeEntity e where e.id =:id");
        query.setParameter("id", employeeEntity.getId());
        return query.getResultList();
    }

    @Override
    public List<EmployeeEntity> findEmployeesBySearchCriteria(EmployeeSearchCriteriaTO employeeSearchCriteriaTO,String queryAsString) {
        EmployeePositionEntity position = null;
        if (employeeSearchCriteriaTO.getEmployeePositionId() != null) {
            position = entityManager.getReference(EmployeePositionEntity.class, employeeSearchCriteriaTO.getEmployeePositionId());
        }
        CarEntity car = null;
        if (employeeSearchCriteriaTO.getCarId() != null) {
            car = entityManager.getReference(CarEntity.class, employeeSearchCriteriaTO.getCarId());
        }
        AgencyEntity agency = null;
        if (employeeSearchCriteriaTO.getAgencyId() != null) {
            agency = entityManager.getReference(AgencyEntity.class, employeeSearchCriteriaTO.getAgencyId());
        }
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(queryAsString, EmployeeEntity.class);
        if (position != null) {
            query.setParameter("employeePosition", position);
        }
        if (car != null) {
            query.setParameter("car", car);
        }
        if (agency != null) {
            query.setParameter("agency", agency);
        }
        return query.getResultList();

    }
}
