package com.example.demo.first;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeId implements Serializable {

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "employee_number")
    private Long employeeNumber;

    public EmployeeId() {
    }

    public EmployeeId(Long companyId, Long employeeId) {
        this.companyId = companyId;
        this.employeeNumber = employeeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeId)) return false;
        EmployeeId that = (EmployeeId) o;
        return Objects.equals(getCompanyId(), that.getCompanyId()) &&
                Objects.equals(getEmployeeNumber(), that.getEmployeeNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyId(), getEmployeeNumber());
    }
}

