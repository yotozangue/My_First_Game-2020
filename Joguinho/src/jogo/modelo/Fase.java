package jogo.modelo;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Fase extends JPanel implements ActionListener {
	
	private Image fundo;
	private Player player;
	private Timer timer;
	private JLabel lblPontuacao;
	private int pontuacao = 0;
	private Random random = new Random();

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\background.jpg");
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		
		//addKeyListener(new TecladoAdapter());
		addMouseListener(new MouseAdapter());
		
		loadLabel();
		
		timer = new Timer(7, this);
		timer.start();
		
		timer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = random.nextInt(5) * (player.getX() < random.nextInt(500)? 1 : -1);
				int y = random.nextInt(5) * (player.getY() < random.nextInt(1000)? 1 : -1);
				player.mover(x, y);
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		//g.dispose();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		player.update();
		repaint();
	}

//	private class TecladoAdapter extends KeyAdapter {
//		
//		@Override
//		public void keyPressed(KeyEvent e) {
//			 player.keyPressed(e);
//		}
//		 
//		@Override
//		public void keyReleased(KeyEvent e) {
//			 player.keyReleased(e);
//		}
//	}
	
	private class MouseAdapter extends java.awt.event.MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {	
			int clickX = e.getX();
			int clickY = e.getY();
			int playerX = player.getX();
			int playerY = player.getY();
			
			int playerTamanhoX = player.getX() + player.getLargura();
			int playerTamanhoY = player.getY() + player.getAltura();
			
			if((clickX >= playerX && clickX <= playerTamanhoX) && 
					(clickY >= playerY && clickY <= playerTamanhoY)) {
				System.out.println("Player");
				pontuacao++;
				lblPontuacao.setText("Pontuacao: "+pontuacao);
				
			} else {
				System.out.println("Fundo");
			}
			
		}
	}
	
	private void loadLabel() {		
		lblPontuacao = new JLabel();
		lblPontuacao.setText("Pontuacao: 0");
		lblPontuacao.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPontuacao.setForeground(new Color(255, 255, 255));
		lblPontuacao.setLocation(450, 0);
		lblPontuacao.setSize(150, 50);
		add(lblPontuacao);
	}
}