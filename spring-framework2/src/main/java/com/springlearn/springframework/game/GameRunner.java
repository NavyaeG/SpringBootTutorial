package com.springlearn.springframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	//Tightly Coupled
//	SuperContraGame game;
//	
//	public GameRunner(SuperContraGame game) {//right now the Gamerunner class is tightly coupled to the supercontra game, we need to change
//		//it to make sure it doesnt only support mario game
//		this.game=game;
//	}
	
	
	//Loosely Coupled
	GamingConsole game;
	
	public GameRunner(@Qualifier("SuperContraGameQualifier")GamingConsole game) {//passing the qualifier that needs to be autowired
		this.game=game;
	}
	
	public void run() {
		System.out.println("Running: "+game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
