package com.example.demo.first;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDao extends JpaRepository<Phone, String> {
}
