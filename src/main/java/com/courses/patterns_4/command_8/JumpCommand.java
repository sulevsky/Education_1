package com.courses.patterns_4.command_8;

public class JumpCommand implements Command {
	@Override
	public void execute(GameActor actor) {
		actor.jump();
	}
}
