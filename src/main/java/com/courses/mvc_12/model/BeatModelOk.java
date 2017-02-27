package com.courses.mvc_12.model;

import com.courses.mvc_12.view.BeatObserver;
import com.courses.mvc_12.view.BpmObserver;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;


public class BeatModelOk implements MetaEventListener, BeatModelInterface{
    private int bpm;
    private Sequencer sequencer;

    private List<BpmObserver> bpmObservers = new ArrayList<>();
    private List<BeatObserver> beatObservers = new ArrayList<>();

    public BeatModelOk() {
        sequencer = createSequencer();
    }

    public void registerObserver(BpmObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeObserver(BpmObserver bpmObserver) {
        bpmObservers.remove(bpmObserver);
    }

    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    private void notifyBpmObservers() {
        for (BpmObserver observer : bpmObservers) {
            observer.updateBpm();
        }
    }

    private void notifyBeatObserver() {
        for (BeatObserver observer : beatObservers) {
            observer.updateBeat();
        }
    }

     @Override
    public void on() {
         sequencer.start();
         setBpm(90);
    }

    @Override
    public void off() {
        sequencer.stop();
        setBpm(0);
    }

    public void setBpm(int bpm) {
        int oldValue = this.bpm;
        this.bpm = bpm;
        sequencer.setTempoInBPM(bpm);
        if (oldValue == 0 && bpm != 0) {
            beatEvent();
        }
        if (bpm == 0) {
            sequencer.stop();
        }

        notifyBpmObservers();
    }

    public int getBpm() {
        return bpm;
    }

    private void beatEvent() {
        sequencer.start();
        notifyBeatObserver();
    }

    @Override
    public void meta(MetaMessage meta) {
        if (meta.getType() == 47) {
            sequencer.setTickPosition(0);
            sequencer.setTempoInBPM(getBpm());
            beatEvent();
        }
    }

    private Sequencer createSequencer() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);

            int[] trackList = {34, 34, 39, 0};

            Sequence sequence = new Sequence(Sequence.PPQ, 4);

            Track track = sequence.createTrack();
            for (int i = 0; i < trackList.length; i++) {
                int key = trackList[i];
                if (key != 0) {
                    track.add(makeEvent(144, 9, key, 100, i));
                    track.add(makeEvent(128, 9, key, 100, i + 1));
                }
            }
            track.add(makeEvent(192, 9, 1, 0, 4));

            sequencer.setSequence(sequence);
            return sequencer;
        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        ShortMessage a = new ShortMessage();
        try {
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }
}
