package com.example.demo;

import com.example.demo.first.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    PhoneDao phoneDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void contextLoads() {

        Employee employee = new Employee();
        employee.setId(new EmployeeId(1L, 100L));
        employee.setName("Vlad Mihalcea");
        Phone phone = new Phone();
        phone.setEmployee(employee);
        phone.setNumber("0001");
        phoneDao.save(phone);
    }

    @Test
    public void test2() {
        List<Phone> phoneList = phoneDao.findAll();
        System.out.println(phoneList.size());

        phoneList.forEach(phone -> System.out.println(phone.toString()));


    }

    @Test
    public void test3() {
        Employee employee = new Employee();
        employee.setId(new EmployeeId(1L, 100L));
        employee.setName("Vlad Mihalcea");
        employeeDao.save(employee);
    }

    @Test
    public void test4() {
        List<Employee> employees = employeeDao.findAll();
        System.out.println(employees.size());
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println("employee.phone.size: "+employee.getPhoneList().size());
            employee.getPhoneList().forEach(phone -> {
                System.out.println(phone.toString());
            });
        });
    }

}
