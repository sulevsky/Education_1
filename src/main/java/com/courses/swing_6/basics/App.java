package com.courses.swing_6.basics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	static JButton button;
	
	public static void changeIt(){
		button.setText("Changed");
	} 
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new JFrame();
				button = new JButton("Hello");
				button.addActionListener(new ButtonActionListener());
				frame.getContentPane().add(button);
				frame.setSize(300,300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}
