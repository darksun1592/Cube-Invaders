package com.darksunproductions.cubeinvaders.entities;

import java.awt.Point;

public class Entity{
	
	Point pos;
	int width;
	int height;
	double velX;
	double velY;
	final String name;
	
	public Entity(Point pos, int width, int height, String name){
		this.pos = pos;
		this.width = width;
		this.height = height;
		this.name = name;
	}
	
	public double getVelX(){
		return velX;
	}
	
	public void setVelX(double x){
		velX = x;
	}
	
	public double getVelY(){
		return velY;
	}
	
	public void setVelY(double y){
		velY = y;
	}
	
	public String getName(){
		return name;
	}
	
	public int getX(){
		return pos.x;
	}
	
	public int getY(){
		return pos.y;
	}
	
	public void tp(Point p){
		pos = new Point(p);
	}
	
	public Point topLeft(){
		return pos;
	}
	
	public Point topRight(){
		return new Point(pos.x+width, pos.y);
	}
	
	public Point bottomLeft(){
		return new Point(pos.x, pos.y+height);
	}
	
	public Point bottomRight(){
		return new Point(pos.x+width, pos.y+height);
	}
	
}