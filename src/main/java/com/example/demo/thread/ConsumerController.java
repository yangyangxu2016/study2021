package com.example.demo.thread;


import com.example.demo.algorithm.LFUCache;
import jodd.util.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * todo
 * date：2021/12/18  12:04 下午
 *
 * @author xuyy
 */
@RestController
@RequestMapping("threadpoolmixuse")
@Slf4j
public class ConsumerController {

    private static ThreadPoolExecutor threadPoll = new ThreadPoolExecutor(
            2, 2, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().withNameFormat("XUYY-%D").get(),
            new ThreadPoolExecutor.CallerRunsPolicy());





    public int wrong() throws ExecutionException, InterruptedException {
        return threadPoll.submit(callTask()).get();
    }

    private Callable<Integer> callTask() {
        return ()->{
            TimeUnit.MICROSECONDS.sleep(10);
            return 1;
        };

    }

    public static void main(String[] args) {
        String collect = IntStream.rangeClosed(1, 1_0000).mapToObj(x -> "a").collect(Collectors.joining(""));
        System.out.println(collect);
    }
}
