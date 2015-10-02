package com.courses.java8_15.optional;

/**
 * Created by VSulevskiy on 28.09.2015.
 */
public class Computer {
    private SoundCard soundCard;

    public Computer(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }
}
