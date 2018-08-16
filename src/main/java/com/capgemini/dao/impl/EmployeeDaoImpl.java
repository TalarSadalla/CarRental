package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
                "select employee from EmployeeEntity employee where employee.id=:employeeId '%')", EmployeeEntity.class);
        query.setParameter("employeeId", employeeId);
        return query.getSingleResult();
    }

    @Override
    public void addEmployeeToAgency(EmployeeEntity employeeEntity, AgencyEntity agencyEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity e where employeeEntity.id =:id '%')", EmployeeEntity.class);
        query.setParameter("id", employeeEntity.getId());
        EmployeeEntity foundEmployee=query.getSingleResult();
        foundEmployee.setAgencyEntity(agencyEntity);
        update(foundEmployee);
    }

    @Override
    public EmployeeEntity removeEmployeeFromAgency(EmployeeEntity employeeEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity e where employeeEntity.id =:id '%')", EmployeeEntity.class);
        query.setParameter("id", employeeEntity.getId());
        EmployeeEntity foundEmployee=query.getSingleResult();
        foundEmployee.setAgencyEntity(null);
        update(foundEmployee);
        return foundEmployee;
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeFromOneAgency(AgencyEntity agencyEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where employee.agency_id =:agencyId '%')", EmployeeEntity.class);
        query.setParameter("agencyId", agencyEntity.getId());
        return query.getResultList();
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeFromOneAgencyForSpecificCar(CarEntity carEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where employee.carEntitySet=:carId '%')", EmployeeEntity.class);
        query.setParameter("carId", carEntity.getId());
        return query.getResultList();
    }

    @Override
    public void addCarToEmployee(CarEntity carEntity, EmployeeEntity employeeEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity e where employeeEntity.id =:id '%')", EmployeeEntity.class);
        query.setParameter("id", employeeEntity.getId());
        EmployeeEntity foundEmployee=query.getSingleResult();
        foundEmployee.getCarEntitySet().add(carEntity);
        update(foundEmployee);
    }

    @Override
    public List<CarEntity> findCarByEmployee(EmployeeEntity employeeEntity, CarEntity carEntity) {
        Query query = entityManager.createQuery(
                "select e.carEntitySet from EmployeeEntity e.carEntitySet ec where employeeEntity.id =:id '%' AND ec.id==:carId)", CarEntity.class);
        query.setParameter("id", employeeEntity.getId());
        query.setParameter("carId", carEntity.getId());
        return query.getResultList();
    }
}
