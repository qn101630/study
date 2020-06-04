package com.qn.sync;

public class SyncTest {
    public static void main(String[] args) {
        sync();
        System.out.println("不会等你了");
    }

    public static void sync(){
        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(3000);
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("我不等你了");
        return;
    }
}
