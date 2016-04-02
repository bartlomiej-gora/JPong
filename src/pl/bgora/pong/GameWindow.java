package pl.bgora.pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import pl.bgora.pong.objects.Ball;
import pl.bgora.pong.objects.Pong;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -6522027149956554121L;
	private GameThread gameThread;
	private boolean started;
	
	public GameWindow(){
		initComponents();
		gameThread = new GameThread(this);
		Thread t = new Thread(gameThread);
		t.start();
	}

	private void initComponents() {
		Dimension dim = new Dimension(800,600);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		setStarted(true);
		
	}
	
	/** 
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Pong red = gameThread.getRed();
		Pong blue = gameThread.getBlue();
		Ball ball = gameThread.getBall();
		
		Graphics buffer = null;
		Image tempImage = createImage(800, 600);
		buffer = tempImage.getGraphics();
		buffer.setColor(Color.black);
		buffer.drawString(gameThread.getRedCount() + ":" + gameThread.getBlueCount(), 400, 50);
		buffer.drawImage(red.getImage(), red.getX(), red.getY(), this);
		buffer.drawImage(blue.getImage(), blue.getX(), blue.getY(), this);
		buffer.fillOval(ball.getX(), ball.getY(), ball.getR(), ball.getR());
		buffer.setColor(Color.black);
		g2d.drawImage(tempImage, 0, 0, this);
		buffer.dispose();
		g.dispose();
	}

	/**
	 * Zwraca wartość pola started
	 * @return Wartość pola started
	 */
	public boolean isStarted() {
		return started;
	}

	/**
	 * Ustawia wartość pola started
	 * @param started Nowa wartość pola started 
	 */
	public void setStarted(boolean started) {
		this.started = started;
	}
}
