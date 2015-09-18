package com.courses.mvc_12.control;

import com.courses.mvc_12.model.BeatModelInterface;
import com.courses.mvc_12.view.DJView;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public class BeatController implements ControllerInterface {
    private BeatModelInterface beatModel;
    private DJView djView;

    public BeatController(BeatModelInterface beatModel) {
        this.beatModel = beatModel;
        this.djView = new DJView(this, beatModel);
        djView.createView();
        djView.createControls();
        djView.disableStopMenuItem();
        djView.enableStartMenuItem();
    }

    @Override
    public void start() {
        beatModel.on();
        djView.disableStartMenuItem();
        djView.enableStopMenuItem();
    }

    @Override
    public void stop() {
        beatModel.off();
        djView.enableStartMenuItem();
        djView.disableStopMenuItem();
    }

    @Override
    public void setBpm(int bpm) {
        beatModel.setBpm(bpm);
    }

    @Override
    public void increaseBpm() {
        int bpm = beatModel.getBpm();
        beatModel.setBpm(bpm+1);
    }

    @Override
    public void decreaseBpm() {
        int bpm = beatModel.getBpm();
        beatModel.setBpm(bpm-1);

    }
}
