package com.example.demo.schedule;

import lombok.Data;

/**
 * todo
 * author：xuyy
 * date：2021/3/4  4:43 下午
 */
@Data

public class Cron {

    private String cron;


    public Cron(String cron) {
        this.cron = cron;
    }

}
