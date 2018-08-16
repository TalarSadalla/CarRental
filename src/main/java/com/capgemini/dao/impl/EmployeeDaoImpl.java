package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {


    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
        save(employeeEntity);
        return employeeEntity;
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
    public void deleteEmployee(EmployeeEntity employeeEntity) {
    delete(employeeEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long employeeId) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where upper(employee.id) like concat(upper(:employeeId), '%')", EmployeeEntity.class);
        query.setParameter("employeeId", employeeId);
        return query.getSingleResult();
    }

    @Override
    public EmployeeEntity addEmployeeToAgency(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public void removeEmployeeFromAgency(Long employeeId) {

    }

    @Override
    public void removeEmployeeFromAgency(EmployeeEntity employeeEntity) {

    }

    @Override
    public List<EmployeeEntity> findAllEmployeeFromOneAgencyForSpecificCar(CarEntity carEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where upper(employee.agency_id) like concat(upper(:employeeId), '%')", EmployeeEntity.class);
        query.setParameter("employeeId", carEntity);
        return query.getResultList();
    }
}
