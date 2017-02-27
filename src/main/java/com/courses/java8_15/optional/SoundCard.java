package com.courses.java8_15.optional;

/**
 * Created by VSulevskiy on 28.09.2015.
 */
public class SoundCard {
    private Usb usb;

    public SoundCard(Usb usb) {
        this.usb = usb;
    }

    public Usb getUsb() {
        return usb;
    }

    public void setUsb(Usb usb) {
        this.usb = usb;
    }
}
