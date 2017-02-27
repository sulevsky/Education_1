package com.courses.mvc_12;

import com.courses.mvc_12.control.BeatController;
import com.courses.mvc_12.control.ControllerInterface;
import com.courses.mvc_12.model.BeatModelOk;
import com.courses.mvc_12.model.BeatModelInterface;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public class App {
    public static void main(String[] args) {
        BeatModelInterface beatModel = new BeatModelOk();
        ControllerInterface controller = new BeatController(beatModel);

    }
}
