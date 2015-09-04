package com.courses;

public class Main {

//    Object lock = new Object();

    public static void main(String[] args) {
        Object lock = new Object();
        TestObject firstObject = new TestObject("first",lock);
        TestObject secondObject = new TestObject("second",lock);


        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                firstObject.synchronizedPrint();
            }
        };
        Thread threadFirst = new Thread(runnableA);
        threadFirst.start();
        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                secondObject.synchronizedPrint();
            }
        };
        Thread threadSecond = new Thread(runnableB);
        threadSecond.start();


    }

    public static class TestObject {
        private String name;
        private Object lock;

        public TestObject(String name, Object lock) {
            this.name = name;
            this.lock = lock;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getLock() {
            return lock;
        }

        public void setLock(Object lock) {
            this.lock = lock;
        }

        public void synchronizedPrint(){
            synchronized (lock) {
                System.out.println("entering name: " + name);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("exiting name: " + name);
            }
        }

    }
}