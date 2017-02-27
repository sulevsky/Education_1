package com.courses.patterns_4.command_8;


public class InputHandler {
	private Command buttonX;
	private Command buttonY;
	private Command buttonA;
	private Command buttonB;
	public Command handleInput(Button b){
		if(b==Button.X){
			return buttonX;
		}
		if(b==Button.Y){
			return buttonY;
		}
		if(b==Button.A){
			return buttonA;
		}
		if(b==Button.B){
			return buttonB;
		}
		return null;
	}
	
}
