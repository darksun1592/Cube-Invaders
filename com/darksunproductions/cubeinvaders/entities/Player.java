package com.darksunproductions.cubeinvaders.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.darksunproductions.cubeinvaders.game.Drawable;
import com.darksunproductions.cubeinvaders.game.Key;

public class Player extends Entity implements Drawable{

	public Player(Point pos, int width, int height, String name){
		super(pos, width, height, name);
	}
	
	public void update(){
		if(Key.A)
			velX = -5.0;
		if(Key.D)
			velX = 5.0;
		if(Key.S)
			velY = 5.0;
		if(Key.W)
			velY = -5.0;
		
		tp(new Point((int)(getX() + velX), (int)(getY() + velY)));
		
		if(velX > 0)
			velX-=0.1;
		if(velX < 0)
			velX+=0.1;
		if(velY > 0)
			velY-=0.1;
		if(velY < 0)
			velY+=0.1;
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(getX(), getY(), width, height);
	}
	
}