package com.example.crud.domain.creditcard;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="creditcard")
@Entity(name="creditcard")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Creditcard {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String holder;

    private String number_creditcard;

    private String exp_date;

    private String cvv;

    private Boolean active;

    public Creditcard(RequestCreditcard requestCreditcard){
        this.holder = requestCreditcard.holder();
        this.number_creditcard = requestCreditcard.number_creditcard();
        this.exp_date = requestCreditcard.exp_date();
        this.cvv = requestCreditcard.cvv();
        this.active = true;
    }
}
