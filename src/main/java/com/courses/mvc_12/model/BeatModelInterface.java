package com.courses.mvc_12.model;

import com.courses.mvc_12.view.BeatObserver;
import com.courses.mvc_12.view.BpmObserver;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public interface BeatModelInterface {
    //controller methods
    void on();
    void off();
    void setBpm(int bpm);

    //update info
    //for controller and view
    int getBpm();
    void registerObserver(BeatObserver observer);
    void removeObserver(BeatObserver observer);

    void registerObserver(BpmObserver bpmObserver);
    void removeObserver(BpmObserver bpmObserver);
}
