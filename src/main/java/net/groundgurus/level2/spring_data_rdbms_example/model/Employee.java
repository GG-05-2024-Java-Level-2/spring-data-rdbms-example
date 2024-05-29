package net.groundgurus.level2.spring_data_rdbms_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue
  private long id;
  private String firstName;
  private String lastName;
}
