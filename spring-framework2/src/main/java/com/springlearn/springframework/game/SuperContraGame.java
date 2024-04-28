package com.springlearn.springframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")//This annotation may be used on a field or parameter as a qualifier for candidate 
//beans when auto wiring. It may also be used to annotate other custom annotations that can then in turn be used as qualifiers.
public class SuperContraGame implements GamingConsole{
	public void up() {
		System.out.println("up");
	}
	public void down() {
		System.out.println("sit down");
	}
	public void left() {
		System.out.println("go back");
	}
	public void right() {
		System.out.println("shoot a bullet");
	}
}
