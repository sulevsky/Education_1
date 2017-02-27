package com.courses.java8_15.optional;

/**
 * Created by VSulevskiy on 28.09.2015.
 */
public class App {
    public static void main(String[] args) {
        Usb usb = new Usb("3.0");
        SoundCard soundCard = new SoundCard(usb);
        Computer genericComputer = new Computer(soundCard);
        printUsbVersion(genericComputer);

        Computer raspberryPiComputer = new Computer(null);
        printUsbVersion(raspberryPiComputer);

    }

    //1
//    public static void printUsbVersion(Computer computer){
//        String version = computer.getSoundCard().getUsb().getVersion();
//        System.out.println("Computer USB version: " + version);
//    }
//2
    public static void printUsbVersion(Computer computer) {
        String version = "UNKNOWN";
        if (computer != null) {
            SoundCard soundCard = computer.getSoundCard();
            if (soundCard != null) {
                Usb usb = soundCard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        System.out.println("Computer USB version: " + version);
    }

}
