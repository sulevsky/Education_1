package com.courses.mvc_12.model;

import com.courses.mvc_12.view.BeatObserver;
import com.courses.mvc_12.view.BpmObserver;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public class BeatModelDraft implements BeatModelInterface, MetaEventListener {
    private Sequencer sequencer;
    private List<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    private List<BpmObserver> bpmObservers = new ArrayList<BpmObserver>();
    private int bpm;

    private Sequence sequence;
    private Track track;


    public BeatModelDraft() {
        bpm = 90;
    }

    @Override
    public void on() {
//        sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
        sequencer.start();
        setBpm(90);
    }

    @Override
    public void off() {
        setBpm(0);
        sequencer.stop();
    }

    @Override
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

    @Override
    public int getBpm() {
        return bpm;
    }

    public void beatEvent() {

        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    @Override
    public void registerObserver(BpmObserver bpmObserver) {
        bpmObservers.add(bpmObserver);
    }

    @Override
    public void removeObserver(BpmObserver bpmObserver) {
        bpmObservers.remove(bpmObserver);
    }

    private void notifyBeatObservers() {
        for (BeatObserver beatObserver : beatObservers) {
            beatObserver.updateBeat();
        }
    }

    private void notifyBpmObservers() {
        for (BpmObserver bpmObserver : bpmObservers) {
            bpmObserver.updateBpm();
        }

    }

    @Override
    public void meta(MetaMessage message) {
        System.out.println(message.getType());
        if (message.getType() == 47) {
            sequencer.start();
            setBpm(getBpm());
            beatEvent();
        }
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBpm());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    private void buildTrackAndStart() {
        int[] trackList = {35, 0, 46, 0};
        sequence.deleteTrack(null);
        track = sequence.createTrack();
        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));

        try {
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    private void makeTracks(int[] trackList) {
        int i = 0;
        for (int key : trackList) {
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
            i++;
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        ShortMessage shortMessage = new ShortMessage();
        try {
            shortMessage.setMessage(comd, chan, one, two);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return new MidiEvent(shortMessage, tick);
    }
}
