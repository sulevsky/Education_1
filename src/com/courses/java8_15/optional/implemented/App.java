package com.courses.java8_15.optional.implemented;

import java.util.Optional;

/**
 * Created by VSulevskiy on 28.09.2015.
 */
public class App {
    public static void main(String[] args) {
        Usb usb = new Usb("3.0");
        SoundCard soundCard = new SoundCard(usb);
        Computer genericComputer = new Computer(soundCard);
        printUsbVersion(Optional.of(genericComputer));

        Computer raspberryPiComputer = new Computer(null);
        printUsbVersion(Optional.of(raspberryPiComputer));

        //other examples
        SoundCard card = new SoundCard(null);
        printSoundCard(card);
        printSoundCardReworked(Optional.ofNullable(card));
        card = null;
        printSoundCard(card);
        printSoundCardReworked(Optional.ofNullable(card));



    }

    //3
    public static void printUsbVersion(Optional<Computer> computer) {
        String version = computer.flatMap(Computer::getSoundCard).flatMap(SoundCard::getUsb).map(Usb::getVersion).orElse("UNKNOWN");
        System.out.println("Computer USB version: " + version);
    }


    //4
    private static void printSoundCard(SoundCard card) {
        if (card != null) {
            System.out.println(card);
        }
    }

    private static void printSoundCardReworked(Optional<SoundCard> card) {
        if(card.isPresent()){
            System.out.println(card.get());//throws NoSuchElementException
        }
    }
    private static void printSoundCardReworked2(Optional<SoundCard> card) {
        card.ifPresent(System.out::println);
    }
}
