package net.groundgurus.level2.spring_data_rdbms_example.service;

import net.groundgurus.level2.spring_data_rdbms_example.dao.EmployeeDao;
import net.groundgurus.level2.spring_data_rdbms_example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  private final EmployeeDao employeeDao;

  public EmployeeService(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  public List<Employee> getAllEmployees() {
    return employeeDao.findAll();
  }

  public Employee getEmployeeById(int id) {
    return employeeDao.findById(id).orElse(null);
  }

  public void addEmployee(Employee employee) {
    employeeDao.save(employee);
  }

  public void deleteEmployee(long id) {
    Optional<Employee> employee = employeeDao.findById(id);
    employee.ifPresent(employeeDao::delete);
  }

  public void updateEmployee(long id, Employee employee) {
    var employeeOpt = employeeDao.findById(id);
    if (employeeOpt.isPresent()) {
      var emp = employeeOpt.get();
      emp.setFirstName(employee.getFirstName());
      emp.setLastName(employee.getLastName());
      employeeDao.save(emp);
    }
  }
}
