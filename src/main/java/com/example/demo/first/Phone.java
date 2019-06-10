package com.example.demo.first;

import javax.persistence.*;

@Entity(name = "Phone")
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "`number`")
    private String number;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "company_id"),
            @JoinColumn(
                    name = "employee_number")
    })
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", employee=" + employee.getId().getCompanyId()+" "+ employee.getId().getEmployeeNumber()+ " "+ employee.getName() +
                '}';
    }
}

