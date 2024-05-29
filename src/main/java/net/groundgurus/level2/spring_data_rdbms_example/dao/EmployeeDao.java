package net.groundgurus.level2.spring_data_rdbms_example.dao;

import net.groundgurus.level2.spring_data_rdbms_example.model.Employee;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface EmployeeDao extends ListCrudRepository<Employee, Integer> {
  Optional<Employee> findById(long id);
}
