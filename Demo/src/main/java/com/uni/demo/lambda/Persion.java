package com.uni.demo.lambda;

import lombok.Data;

@Data
public class Persion {

    private String id;

    public Persion(String id) {
        this.id = id;
    }


}
