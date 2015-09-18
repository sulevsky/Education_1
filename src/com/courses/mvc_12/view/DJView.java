package com.courses.mvc_12.view;

import com.courses.mvc_12.control.ControllerInterface;
import com.courses.mvc_12.model.BeatModelInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by VSulevskiy on 18.09.2015.
 */
public class DJView implements ActionListener, BeatObserver, BpmObserver {
    private BeatModelInterface beatModel;
    private ControllerInterface controller;

    private JFrame viewFrame;
    private JPanel viewPanel;
    private BeatBar beatBar;
    private JLabel bpmOutPutLabel;

    private JFrame controlFrame;
    private JPanel controlPanel;

    private JLabel bpmLabel;
    private JTextField bpmTextField;
    private JButton setBpmButton;
    private JButton increaseBpmButton;
    private JButton decreaseBpmButton;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem startMenuItem;
    private JMenuItem stopMenuItem;

    public DJView(ControllerInterface controller, BeatModelInterface beatModel) {
        this.controller = controller;
        this.beatModel = beatModel;
        beatModel.registerObserver((BeatObserver) this);
        beatModel.registerObserver((BpmObserver) this);
    }

    public void createView() {
        //Swing
        viewPanel = new JPanel(new GridLayout(1,2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        viewFrame.setSize(100, 80);
        bpmOutPutLabel = new JLabel("offline",SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);

        JPanel bpmPanel = new JPanel(new GridLayout(2,1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutPutLabel);

        viewPanel.add(bpmPanel);

        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }


    public void createControls(){
//        Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        controlFrame.setSize(100, 80);

        controlPanel = new JPanel(new GridLayout(1,2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJControl");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(e -> controller.start());

        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem);
        stopMenuItem.addActionListener(e -> controller.stop());

        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(e -> System.exit(0));
        menu.add(exit);
        menuBar.add(menu);

        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:",SwingConstants.RIGHT);
        setBpmButton = new JButton("Set");
        setBpmButton.setSize(10,40);

        increaseBpmButton = new JButton(">>");
        decreaseBpmButton = new JButton("<<");
        setBpmButton.addActionListener(this);
        increaseBpmButton.addActionListener(this);
        decreaseBpmButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.add(decreaseBpmButton);
        buttonPanel.add(increaseBpmButton);

        JPanel enterPanel = new JPanel(new GridLayout(1,2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);

        JPanel insideControlPanel = new JPanel(new GridLayout(3,1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBpmButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);

        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bpmOutPutLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        controlFrame.getRootPane().setDefaultButton(setBpmButton);
        controlFrame.getContentPane().add(controlPanel,BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);


    }

    public void updateBpm() {
        int bpm = beatModel.getBpm();
        if (bpm == 0) {
            bpmOutPutLabel.setText("Offline");
        } else {
            bpmOutPutLabel.setText("Current bpm: " + beatModel.getBpm());
        }
    }
    public void updateBeat(){
        beatBar.setValue(100);
    }
    public void enableStartMenuItem(){
        startMenuItem.setEnabled(true);
    }
    public void disableStartMenuItem(){
        startMenuItem.setEnabled(false);
    }

    public void enableStopMenuItem(){
        stopMenuItem.setEnabled(true);
    }
    public void disableStopMenuItem(){
        stopMenuItem.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()== setBpmButton){
            int bpm = Integer.parseInt(bpmTextField.getText());
            controller.setBpm(bpm);
        }else if(event.getSource() == increaseBpmButton){
            controller.increaseBpm();
        }else if(event.getSource() == decreaseBpmButton){
            controller.decreaseBpm();
        }
    }

}
