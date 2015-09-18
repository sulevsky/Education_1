package com.courses.mvc_12.simple_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        List<Quackable> flock = simulator.create();
        simulator.simulate(flock);
    }

    private List<Quackable> create() {
        List<Quackable> flock = new ArrayList<>();
        Quackable mDuck = new MallardDuck();
        Quackable rDuck = new RedheadDuck();
        flock.add(mDuck);
        flock.add(rDuck);
        return flock;
    }

    private void simulate(List<Quackable> flock) {
        for (Quackable quackable : flock) {
            quackable.quack();
        }
    }
}
