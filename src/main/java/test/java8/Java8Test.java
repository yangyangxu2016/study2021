package test.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * todo
 * date：2021/4/1  10:29 上午
 *
 * @author xuyy
 */

public class Java8Test {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("dingdddddd");
            }
        });

        new Thread(() -> {
            System.out.println("doing");
        }).start();

        testRunnable(() -> {
            System.out.println("doing");
        });

        testSupper(() -> "OK");
        testConsumer((String a) -> {
            System.out.println(a);
        }, "abce");

        Thread.sleep(10000);
    }

    public static void testRunnable(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void testSupper(Supplier<Object> supplier) {
        Object t = supplier.get();
        System.out.println(t);
    }

    public static void testConsumer(Consumer<String> consumer, String data) {
        consumer.accept(data);
    }
}
