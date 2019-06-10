package com.example.demo.first;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {

    @EmbeddedId
    private EmployeeId id;

    private String name;

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = Phone.class, mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneList;

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
