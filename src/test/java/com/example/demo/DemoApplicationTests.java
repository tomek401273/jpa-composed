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
        phone.setNumber("000");
        phoneDao.save(phone);
    }

    @Test
    public void test2() {
        List<Phone> phoneList = phoneDao.findAll();
        System.out.println(phoneList.size());
        System.out.println(phoneList.get(0).getNumber());
        System.out.println(phoneList.get(0).getEmployee().getId());
        System.out.println(phoneList.get(0).getEmployee().getName());
    }

    @Test
    public void test3() {
        Employee employee = new Employee();
        employee.setId(new EmployeeId(1L, 100L));
        employee.setName("Vlad Mihalcea");
        employeeDao.save(employee);
    }

}
