package com.example.demo.thread;


/**
 * todo
 * date：2021/4/26  6:33 下午
 *
 * @author xuyy
 */
public class ThreeThreadCicly implements Runnable {
        private Object curr;
        private Object next;
        private int max;
        private String word;

    public ThreeThreadCicly(Object curr, Object next, int max, String word) {
        this.curr = curr;
        this.next = next;
        this.max = max;
        this.word = word;
    }

    @Override
        public void run() {
            for (int i = 0; i < max; i++) {
                synchronized (curr) {
                    synchronized (next) {
                        System.out.println(word);
                        //通知下一个
                        next.notify();

                    }
                    //当前释放锁
                    try {
                        curr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

            synchronized (next) {
                next.notify();
                System.out.println("执行完毕");
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        new Thread(new ThreeThreadCicly(a,b,100,"a")).start();
        Thread.sleep(1000);
        new Thread(new ThreeThreadCicly(b,c,100,"b")).start();
        Thread.sleep(1000);
        new Thread(new ThreeThreadCicly(c,a,100,"c")).start();


    }
}
