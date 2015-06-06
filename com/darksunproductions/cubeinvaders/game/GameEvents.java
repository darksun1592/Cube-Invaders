package com.darksunproductions.cubeinvaders.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEvents implements KeyListener{
	
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_A:
				Key.A = true;
				break;
			case KeyEvent.VK_S:
				Key.S = true;
				break;
			case KeyEvent.VK_D:
				Key.D = true;
				break;
			case KeyEvent.VK_W:
				Key.W = true;
				break;
			case KeyEvent.VK_SPACE:
				Key.SPACE = true;
				break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_A:
				Key.A = false;
				break;
			case KeyEvent.VK_S:
				Key.S = false;
				break;
			case KeyEvent.VK_D:
				Key.D = false;
				break;
			case KeyEvent.VK_W:
				Key.W = false;
				break;
			case KeyEvent.VK_SPACE:
				Key.SPACE = false;
				break;
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
}
