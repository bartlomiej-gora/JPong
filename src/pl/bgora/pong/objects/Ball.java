package pl.bgora.pong.objects;

import java.awt.Rectangle;


public class Ball{

	private int x;
	private int y;
	private int dx;
	private int dy;
	private int r;
	
	public Ball(){
		setR(30);
	}
	
	public void move(){
		x+=dx;
		y+=dy;
	}


	/**
	 * Zwraca wartość pola x
	 * @return Wartość pola x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Ustawia wartość pola x
	 * @param x Nowa wartość pola x 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Zwraca wartość pola y
	 * @return Wartość pola y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Ustawia wartość pola y
	 * @param y Nowa wartość pola y 
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Zwraca wartość pola dx
	 * @return Wartość pola dx
	 */
	public int getDx() {
		return dx;
	}

	/**
	 * Ustawia wartość pola dx
	 * @param dx Nowa wartość pola dx 
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}

	/**
	 * Zwraca wartość pola dy
	 * @return Wartość pola dy
	 */
	public int getDy() {
		return dy;
	}

	/**
	 * Ustawia wartość pola dy
	 * @param dy Nowa wartość pola dy 
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, r, r);
	}

	/**
	 * Zwraca wartość pola r
	 * @return Wartość pola r
	 */
	public int getR() {
		return r;
	}

	/**
	 * Ustawia wartość pola r
	 * @param r Nowa wartość pola r 
	 */
	public void setR(int r) {
		this.r = r;
	}
}
