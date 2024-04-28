package com.springlearn.springframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary//if multiple candidates are found, we are telling spring to use mario as primary
public class MarioGame implements GamingConsole {
	public void up() {
		System.out.println("jump");
	}
	public void down() {
		System.out.println("go into a hole");
	}
	public void left() {
		System.out.println("go back");
	}
	public void right() {
		System.out.println("accelerate");
	}
}
