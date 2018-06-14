package com.test.mysql.demo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.mysql.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value ="select * from employees where emp_no = ?1", nativeQuery = true)
    Employee getEmployee(int id);

    Page<Employee> findAll(Pageable pageRequest);

}
