package com.example.demo.test;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 10:00 2019/1/24/024
 * @Modify By:
 **/
public class testRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            synchronized(testRunnable.class){count++;
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count);}
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    interface testR{
        int count=0;
    }

    public static void main(String[] args) {
        testRunnable mTh = new testRunnable();
        new Thread(mTh, "C").start();//同一个mTh，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
        new Thread(mTh, "D").start();
        new Thread(mTh, "E").start();
    }
}
