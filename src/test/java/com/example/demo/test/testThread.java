package com.example.demo.test;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 9:58 2019/1/24/024
 * @Modify By:
 **/
public class testThread extends Thread {
    private int count = 5;
    private String name;

    public testThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  count= " + count--);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        testThread mTh1=new testThread("A");
        testThread mTh2=new testThread("B");
        mTh1.start();
        mTh2.start();
    }
}
