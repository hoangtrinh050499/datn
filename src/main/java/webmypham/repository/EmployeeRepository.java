package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webmypham.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
