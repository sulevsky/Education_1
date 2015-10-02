package com.courses.java8_15.optional.implemented;

import java.util.Optional;

/**
 * Created by VSulevskiy on 28.09.2015.
 */
public class SoundCard {
    private Optional<Usb> usb;

    public SoundCard(Usb usb) {
        this.usb = Optional.ofNullable(usb);
    }

    public Optional<Usb> getUsb() {
        return usb;
    }

    public void setUsb(Usb usb) {
        this.usb = Optional.ofNullable(usb);
    }
}
