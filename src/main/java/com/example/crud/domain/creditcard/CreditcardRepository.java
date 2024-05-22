package com.example.crud.domain.creditcard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditcardRepository extends JpaRepository<Creditcard, String> {
    List<Creditcard> findAllByActiveTrue();
}