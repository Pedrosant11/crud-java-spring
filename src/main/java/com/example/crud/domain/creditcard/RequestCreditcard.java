package com.example.crud.domain.creditcard;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCreditcard(
        String id,

        @NotBlank
        String holder,
        @NotNull
        String number_creditcard,

        @NotNull
        String exp_date,

        @NotNull
        String cvv



) {
}
