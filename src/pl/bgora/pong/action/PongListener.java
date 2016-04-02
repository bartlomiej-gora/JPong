/**
 * 
 */
package pl.bgora.pong.action;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pl.bgora.pong.objects.Pong;

/**
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 * 
 */
public class PongListener extends KeyAdapter {

	private Pong pong;
	private int top;
	private int bottom;

	public PongListener(Pong pong, int top, int bottom) {
		this.pong = pong;
		this.top = top;
		this.bottom = bottom;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == pong.getUpKey()) {
			if (pong.getY() > top) {
				pong.setDy(-1);
			}
		}
		if (e.getKeyCode() == pong.getDownKey()) {
			if (pong.getBounds().height + pong.getY() < bottom) {
				pong.setDy(1);
			}
		}
	};

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == pong.getUpKey()) {
			pong.setDy(0);
		}
		if (e.getKeyCode() == pong.getDownKey()) {
			pong.setDy(0);
		}
	}
}
