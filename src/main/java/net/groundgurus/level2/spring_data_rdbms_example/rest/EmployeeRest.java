package net.groundgurus.level2.spring_data_rdbms_example.rest;

import net.groundgurus.level2.spring_data_rdbms_example.model.Employee;
import net.groundgurus.level2.spring_data_rdbms_example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRest {
  private final EmployeeService employeeService;

  public EmployeeRest(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public List<Employee> getEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("{id}")
  public Employee getEmployee(@PathVariable int id) {
    return employeeService.getEmployeeById(id);
  }

  @PostMapping
  public void addEmployee(@RequestBody Employee employee) {
    employeeService.addEmployee(employee);
  }

  @DeleteMapping("{id}")
  public void deleteEmployee(@PathVariable long id) {
    employeeService.deleteEmployee(id);
  }

  @PutMapping("{id}")
  public void updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
    employeeService.updateEmployee(id, employee);
  }
}
