package com.courses.java8_15.optional.implemented;

import java.util.Optional;

/**
 * Created by VSulevskiy on 28.09.2015.
 */
public class Computer {
    private Optional<SoundCard> soundCard;

    public Computer(SoundCard soundCard) {
        this.soundCard = Optional.ofNullable(soundCard);
    }

    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = Optional.ofNullable(soundCard);
    }
}
