package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * todo
 * author：xuyy
 * date：2021/3/4  4:42 下午
 */
@Slf4j
@Service
public class CronMapper {

    public Cron selectByPrimaryKey() {

        AtomicReference<String> cron = new AtomicReference<>("");

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(10);
            log.info("random:{}", i1);
            if (i1 == 3) {
                cron.set("0/1 * * * * ?");
                break;
            }
            if (i1 == 8) {
                cron.set("0/5 * * * * ?");
                break;
            }
        }
        if (cron.get().equals("")) {
            cron.set("0/2 * * * * ?");
        }
        log.info("cron:{}", cron);
        return new Cron(cron.get());

    }
}
