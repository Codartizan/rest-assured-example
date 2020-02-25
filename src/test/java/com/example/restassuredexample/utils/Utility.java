package com.example.restassuredexample.utils;

import com.example.restassuredexample.pojo.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/** Description: Created by timshi Date: 2020/02/25 Time: 8:07 pm */
@Component
public class Utility {

  // Dummy constructor for spring scanning
  @PostConstruct
  public void init() {}

  public Employee buildEmployee() {
    Employee emp = new Employee();
    emp.setAge("32");
    emp.setName("Kevin Hart");
    emp.setSalary("585950");

    return emp;
  }
}
