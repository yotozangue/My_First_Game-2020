package jogo.modelo;

import java.awt.Image;
//import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
	
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int largura;
	private int altura;
 
	public Player(){
		this.x = 100;
		this.y = 100;
	}

	public void load(){
		ImageIcon referencia = new ImageIcon("res\\Player.png");
		referencia.setImage(referencia.getImage()
				.getScaledInstance(32, 51, Image.SCALE_FAST));
		imagem = referencia.getImage();
		setAltura(imagem.getHeight(null));
		setLargura(imagem.getWidth(null));
	}

	public void update(){
		x += dx;
		y += dy;
	}
	
	public void mover(int x, int y) {
		dx = x;
		dy = y;
	}

//	public void keyPressed(KeyEvent tecla) {
//		int codigo = tecla.getKeyCode();
//	
//		if (codigo == KeyEvent.VK_UP){
//			dy = -3;
//		}
//		if (codigo == KeyEvent.VK_DOWN){
//			dy = 3;
//		}
//		if (codigo == KeyEvent.VK_LEFT){
//			dx = -3;
//		}
//		if (codigo == KeyEvent.VK_RIGHT){
//			dx = 3;
//		}
//	}
	
//	public void keyReleased(KeyEvent tecla) {
//		int codigo = tecla.getKeyCode();
//	   
//		if (codigo == KeyEvent.VK_UP){
//			dy =0;
//		}
//		
//		if (codigo == KeyEvent.VK_DOWN){
//			dy =0;
//		}
//		
//		if (codigo == KeyEvent.VK_LEFT){
//			dx = 0;
//		}
//		
//		if (codigo == KeyEvent.VK_RIGHT){
//			dx = 0;
//		}
//	}
  
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}