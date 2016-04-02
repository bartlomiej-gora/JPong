package pl.bgora.pong;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import pl.bgora.pong.action.PongListener;
import pl.bgora.pong.objects.Ball;
import pl.bgora.pong.objects.Pong;

public class GameThread implements Runnable{

	private GameWindow window;
	private Pong red;
	private Pong blue;
	private Ball ball;
	
	private final int WIN_COUNT = 10;
	private int redCount;
	private int blueCount;
	private boolean inGame;
	
	private int leftCorner = 10;
	private int rightCorner;
	private int top = 10;
	private int bottom;
	private int monitorCenterX;
	private int monitorCenterY;
	
	public GameThread(GameWindow gameWindow) {
		this.window = gameWindow;
		rightCorner = window.getBounds().width;
		bottom = window.getBounds().height;
		red = new Pong(Pong.RED);
		blue = new Pong(Pong.BLUE);
		ball = new Ball();
		inGame = true;
		//TODO: Dodać to do ustawień
		red.setUpKey(KeyEvent.VK_Q);
		red.setDownKey(KeyEvent.VK_Z);
		blue.setUpKey(KeyEvent.VK_UP);
		blue.setDownKey(KeyEvent.VK_DOWN);
		window.addKeyListener(new PongListener(red, top, bottom));
		window.addKeyListener(new PongListener(blue, top, bottom));
	}

	@Override
	public void run() {
		
		
		monitorCenterX = rightCorner/2;
		monitorCenterY = bottom /2;
		red.setY(monitorCenterY - red.getBounds().height/2);
		red.setX(leftCorner);
		blue.setY(monitorCenterY - blue.getBounds().height/2);
		blue.setX(rightCorner-25);
		ball.setX(monitorCenterX);
		ball.setY(monitorCenterY);
		
		Random rand = new Random();
		if(rand.nextBoolean()){
			ball.setDx(1);
		}else{
			ball.setDx(-1);
		}
		
		while(inGame){
			ball.move();
			blue.move();
			red.move();
			checkCollisions();
			try {
				Thread.currentThread().sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			window.repaint();
		}
		if(redCount == WIN_COUNT){
			JOptionPane.showMessageDialog(window, "Czerowny zawodnik wygrał!", "Gratulacje", JOptionPane.INFORMATION_MESSAGE);
		}else if(blueCount == WIN_COUNT){
			JOptionPane.showMessageDialog(window, "Niebieski zawodnik wygrał!", "Gratulacje", JOptionPane.INFORMATION_MESSAGE);
		}
		System.exit(0);
	}

	private void checkCollisions() {
		Rectangle ballRectangle = ball.getBounds();
		Rectangle redRectangle = red.getBounds();
		Rectangle blueRectangle = blue.getBounds();
		if(ballRectangle.intersects(redRectangle)){
			if(red.getDy() > 0){
				ball.setDy(1);
			}else if(red.getDy() < 0){
				ball.setDy(-1);
			}
			ball.setDx(1);
		}else if(ballRectangle.intersects(blueRectangle)){
			if(blue.getDy() > 0){
				ball.setDy(1);
			}else if(blue.getDy() < 0){
				ball.setDy(-1);
			}
			ball.setDx(-1);
		}else if(ball.getY() == top + ball.getR()){
			ball.setDy(1);
		}else if(ball.getY() == bottom - ball.getR()){
			ball.setDy(-1);
		}else if (blueRectangle.intersectsLine(0, 0, rightCorner, 0) || blueRectangle.intersectsLine(0, bottom, rightCorner, bottom)){
			blue.setDy(0);
		}else if (redRectangle.intersectsLine(0, 0, rightCorner, 0) || redRectangle.intersectsLine(0, bottom, rightCorner, bottom)){
			red.setDy(0);
		}else if(ball.getBounds().intersectsLine(rightCorner, top, rightCorner, bottom)){
			addRedPoint();
		}else if(ball.getBounds().intersectsLine(leftCorner, top, leftCorner, bottom)){
			addBluePoint();
		}
	}

	private void addBluePoint() {
		blueCount++;
		if(blueCount==WIN_COUNT){
			inGame = false;
		}
		ball.setX(monitorCenterX);
		ball.setY(monitorCenterY);
		ball.setDx(-1);
		ball.setDy(0);
	}

	private void addRedPoint() {
		redCount++;
		if(redCount==WIN_COUNT){
			inGame = false;
		}
		ball.setX(monitorCenterX);
		ball.setY(monitorCenterY);
		ball.setDx(1);
		ball.setDy(0);
	}

	/**
	 * Zwraca wartość pola red
	 * @return Wartość pola red
	 */
	public Pong getRed() {
		return red;
	}

	/**
	 * Zwraca wartość pola blue
	 * @return Wartość pola blue
	 */
	public Pong getBlue() {
		return blue;
	}

	/**
	 * Zwraca wartość pola ball
	 * @return Wartość pola ball
	 */
	public Ball getBall() {
		return ball;
	}

	/**
	 * Zwraca wartość pola redCount
	 * @return Wartość pola redCount
	 */
	public int getRedCount() {
		return redCount;
	}

	/**
	 * Ustawia wartość pola redCount
	 * @param redCount Nowa wartość pola redCount 
	 */
	public void setRedCount(int redCount) {
		this.redCount = redCount;
	}

	/**
	 * Zwraca wartość pola blueCount
	 * @return Wartość pola blueCount
	 */
	public int getBlueCount() {
		return blueCount;
	}

	/**
	 * Ustawia wartość pola blueCount
	 * @param blueCount Nowa wartość pola blueCount 
	 */
	public void setBlueCount(int blueCount) {
		this.blueCount = blueCount;
	}

}
