package com.springlearn.springframework.game;

import org.springframework.stereotype.Component;

@Component//tells spring this is a component, such classes are considered as candidates for auto detection when using
//annotation based configuration and class path scanning
public class PacmanGame implements GamingConsole {
	public void up() {
		System.out.println("up");
	}
	public void down() {
		System.out.println("down");
	}
	public void left() {
		System.out.println("left");
	}
	public void right() {
		System.out.println("right");
	}
}
