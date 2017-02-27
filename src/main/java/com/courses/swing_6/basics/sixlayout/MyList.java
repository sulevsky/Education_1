package com.courses.swing_6.basics.sixlayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class MyList implements ListSelectionListener{
    JList list;
    JFrame frame;
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.go();
    }

    private void go() {
        frame = new JFrame();

        String[] listEntries= {"red","green","blue"};
        list = new JList(listEntries);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frame.getContentPane().add(BorderLayout.NORTH, scrollPane);

        list.setVisibleRowCount(2);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!list.getValueIsAdjusting()){
            String selection = (String)list.getSelectedValue();
            switch (selection){
                case "red":
                    frame.getContentPane().setBackground(Color.RED);
                    break;
                case "green":
                    frame.getContentPane().setBackground(Color.GREEN);
                    break;
                case "blue":
                    frame.getContentPane().setBackground(Color.BLUE);
                    break;
                default:
                    frame.getContentPane().setBackground(Color.GRAY);


            }
        }
    }
}
