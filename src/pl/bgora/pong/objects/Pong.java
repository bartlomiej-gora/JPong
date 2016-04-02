package pl.bgora.pong.objects;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pong {

	public static final int RED = 0;
	public static final int BLUE = 2;
	
	private int type;
	private Image image;
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	
	private int upKey;
	private int downKey;
	
	public Pong(int type){
		this.type = type;
		ImageIcon ii = null;
		if(type==RED){
			ii = new ImageIcon(this.getClass().getResource("pong_red.png"));
			image = ii.getImage();
		}else if(type==BLUE){
			ii = new ImageIcon(this.getClass().getResource("pong_blue.png"));
			image = ii.getImage();
		}
	}
	
	public void move(){
		x += dx;
		y += dy;
	}

	/**
	 * Zwraca wartość pola type
	 * @return Wartość pola type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Ustawia wartość pola type
	 * @param type Nowa wartość pola type 
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Zwraca wartość pola image
	 * @return Wartość pola image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Ustawia wartość pola image
	 * @param image Nowa wartość pola image 
	 */
	public void setImage(Image image) {
		this.image = image;
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

	/**
	 * Zwraca wartość pola upKey
	 * @return Wartość pola upKey
	 */
	public int getUpKey() {
		return upKey;
	}

	/**
	 * Ustawia wartość pola upKey
	 * @param upKey Nowa wartość pola upKey 
	 */
	public void setUpKey(int upKey) {
		this.upKey = upKey;
	}

	/**
	 * Zwraca wartość pola downKey
	 * @return Wartość pola downKey
	 */
	public int getDownKey() {
		return downKey;
	}

	/**
	 * Ustawia wartość pola downKey
	 * @param downKey Nowa wartość pola downKey 
	 */
	public void setDownKey(int downKey) {
		this.downKey = downKey;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, getImage().getWidth(null), getImage().getHeight(null));
	}
	
}
