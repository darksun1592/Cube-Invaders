package com.darksunproductions.cubeinvaders.game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {
	
	LinkedList<Drawable> entities;
	
	public Controller(){
		entities = new LinkedList<Drawable>();
	}
	
	public void update(){
		for(int i = 0; i < entities.size(); i++)
			entities.get(i).update();
	}
	
	public void render(Graphics g){
		for(int i = 0; i < entities.size(); i++)
			entities.get(i).render(g);
	}
	
	public void add(Drawable d){
		entities.add(d);
	}
	
	public void remove(Drawable d){
		entities.remove(d);
	}
	
	public void remove(int i){
		entities.remove(i);
	}
	
	public int size(){
		return entities.size();
	}
	
}