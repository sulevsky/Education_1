package com.courses.swing_6.jlabel_8;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by VSulevskiy on 03.08.2015.
 */
public class App {
    public static void main(String[] args) {
//        JFrame myFrame = new MyFrame();
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        JLabel labelText = new JLabel("Hello guys");
//        panel.add(labelText, BorderLayout.NORTH);
//        JLabel labelImage =
//                new JLabel("Hello guys",
//                        new ImageIcon("resourses\\dropped.jpg"), SwingConstants.LEFT);
//        panel.add(labelImage, BorderLayout.SOUTH);
//        myFrame.setContentPane(panel);
//        myFrame.setVisible(true);

        List list = new ArrayList();

        try {
            System.out.println("Before ex");
            list.add(-1, "f");
            System.out.println("Ex thrown ");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Exception cought");
//            throw new IndexOutOfBoundsException("hello");
        }finally{
            System.out.println("Finally");

        }
        System.out.println("End");

    }
}
