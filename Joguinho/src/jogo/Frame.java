package jogo;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jogo.modelo.Fase;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel tela;
	
	public Frame() {
		setTitle("ALLAN FERREIRA DE LIMA 8ºD");
		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		init();
		
		setContentPane(tela);
		setVisible(true);
	}
	
	private void init() {
		tela = new Fase();
		tela.setLayout(null);
		tela.setBorder(null);
		tela.setVisible(true);
	}
}