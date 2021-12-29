package com.example.demo.thread;

import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo
 * date：2021/12/29  7:26 下午
 *
 * @author xuyy
 */
public class Semaphor  extends AbstractQueuedSynchronizer {


    public Semaphor(int permits){
        setState(permits);
    }

    @Override
    public int tryAcquireShared(int arg) {
        int state = getState();
        if (state == 0) {
            return -1;
        }
        int left = state - 1;

        if (compareAndSetState(state, left)) {
            return left;
        }
        return -1;
    }


    protected boolean tryReleaseShared(int arg) {
        int state = getState();
        int left = state + 1;
        return compareAndSetState(state,left);

    }


    public static void main(String[] args) {
        Semaphor semaphor = new Semaphor(2);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                semaphor.acquireShared(0);
                System.out.println("go");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("完了");
                semaphor.releaseShared(0);
            }).start();
        }

    }
}
