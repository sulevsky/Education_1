package com.courses.concurrency_100.accidentialcorruption_11;

/**
 * Created by VSulevskiy on 26.08.2015.
 */
public class DirtyRead {
    private String firstName;
    private String lastName;

    public String getNames() {
        return lastName + ", " + firstName;
    }

    public void setNames(String fName, String lName) {
        print("Entering set names");
        this.firstName = fName;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.lastName = lName;

        print("leaving setNames() " + lastName + ", " + firstName);
    }

    private static void print(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + message);
    }

    public static void main(String[] args) {
        DirtyRead dirtyRead = new DirtyRead();
        dirtyRead.setNames("George", "Washington");

        Runnable runnableFirst = new Runnable() {
            @Override
            public void run() {
                dirtyRead.setNames("Abe", "Lincoln");
            }
        };
        Thread threadAbe = new Thread(runnableFirst);
        threadAbe.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable reader = new Runnable() {
            @Override
            public void run() {
                print("getNames()= "+ dirtyRead.getNames());
            }
        };
        Thread threadReader = new Thread(reader,"reader");
        threadReader.start();
    }
}
