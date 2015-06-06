package com.darksunproductions.cubeinvaders.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.darksunproductions.cubeinvaders.entities.Player;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private boolean running = false;
	
	private Thread thread;
	private JFrame frame = new JFrame("Cube Invaders");
	public Controller c = new Controller();
	
	public Game(){
		frame.add(this);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addKeyListener(new GameEvents());
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastReset = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long currentTime;
		double UPDATE = 1000000000/60;
		int frames = 0;
		int updates = 0;
		
		while(running){
			currentTime = System.nanoTime();
			
			if(currentTime - lastUpdate >= UPDATE){
				updates++;
				lastUpdate += UPDATE;
				tick();
			}
			
			if(currentTime - lastReset >= 1000000000){
				frame.setTitle("Cube Invaders | FPS: " + frames + " | Updates: " + updates);
				lastReset += 1000000000;
				frames = 0;
				updates = 0;
			}
			
			frames++;
			render();
			
			try {
				Thread.sleep(3);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void tick(){
		c.update();
	}
	
	public void render(){
		if(getBufferStrategy() == null){
			createBufferStrategy(3);
		}
		BufferStrategy bs = getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		////////////////////////////////////////
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		////////////////////////////////////////
		
		c.render(g);
		
		////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		Game game = new Game();
		
		game.c.add(new Player(new Point(200, 200), 25, 25, "Player"));
		
		game.start();
	}
	
}

















