package com.example.crud.controllers;

import com.example.crud.domain.creditcard.Creditcard;
import com.example.crud.domain.creditcard.CreditcardRepository;
import com.example.crud.domain.creditcard.RequestCreditcard;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/creditcards")
public class CreditcardController {
    @Autowired
    private CreditcardRepository repository;
    @GetMapping
    public ResponseEntity getAllCreditcards(){
        var allCreditcards = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allCreditcards);
    }

    @PostMapping
    public ResponseEntity registerCreditcard(@RequestBody @Valid RequestCreditcard data){
        Creditcard newCreditcard = new Creditcard(data);
        repository.save(newCreditcard);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCreditcard(@RequestBody @Valid RequestCreditcard data){
        Optional<Creditcard> optionalCreditcard = repository.findById(data.id());
        if (optionalCreditcard.isPresent()) {
            Creditcard creditcard = optionalCreditcard.get();
            creditcard.setHolder(data.holder());
            creditcard.setNumber_creditcard(data.number_creditcard());
            creditcard.setExp_date(data.exp_date());
            creditcard.setCvv(data.cvv());
            return ResponseEntity.ok(creditcard);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCreditcard(@PathVariable String id){
        Optional<Creditcard> optionalCreditcard = repository.findById(id);
        if (optionalCreditcard.isPresent()) {
            Creditcard creditcard = optionalCreditcard.get();
            creditcard.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
