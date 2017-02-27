package com.courses.mvc_12.control;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public interface ControllerInterface {
    void start();

    void stop();

    void setBpm(int bpm);

    void increaseBpm();


    void decreaseBpm();
}
