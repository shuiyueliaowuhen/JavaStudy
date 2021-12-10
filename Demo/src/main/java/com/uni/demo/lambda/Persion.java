package com.uni.demo.lambda;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Persion {

    private String id;

    private BigDecimal amount;

    public Persion(String id) {
        this.id = id;
    }

    public Persion(BigDecimal amount) {
        this.amount = amount;
    }
}
