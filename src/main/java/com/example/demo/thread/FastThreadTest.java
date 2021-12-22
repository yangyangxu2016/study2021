package com.example.demo.thread;

import com.sun.media.sound.SoftTuning;
import io.netty.util.concurrent.FastThreadLocal;

/**
 * todo
 * date：2021/12/20  11:35 上午
 *
 * @author xuyy
 */
public class FastThreadTest {

    public static void main(String[] args) {
        FastThreadLocal fastThreadLocal = new FastThreadLocal();
        fastThreadLocal.set("xuyy");
        System.out.println(fastThreadLocal.get());
        fastThreadLocal.remove();
        System.out.println(fastThreadLocal.get());
    }
}
