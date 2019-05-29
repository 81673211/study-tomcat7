package com.fred.sync;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/21 15:39
 */
public class ThreadDemo implements Runnable {

    @Override
    public void run() {
        synchronized (A.class) {
            new B().method();
        }
    }

    public static void main(String[] args) {

        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        new Thread(demo).start();

    }

    private class A {
        public void method() {
            System.out.println("i am a.method");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class B {
        public void method() {
            System.out.println("i am b.method");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

