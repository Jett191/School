package com.homework1.service;

import com.homework1.Entity.Employee;
import java.util.List;

public class EmployeeService {
  List<Employee> findAll();
  int addEmployee(Employee employee);
  List<Employee> findByDeptId(Integer deptId);
}
