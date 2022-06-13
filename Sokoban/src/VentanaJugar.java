import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javafx.scene.media.AudioClip;

import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.Color;

public class VentanaJugar extends JFrame {

	private JMenuBar barra;
	private JMenu deshacer;
	private JMenu rehacer;

	private JMenu ayuda;
	private JMenuItem verAyuda;

	public VentanaJugar() {
		menu();
		iniciarJuego();
	}

	public static void main(String[] args) {
		VentanaJugar ventana = new VentanaJugar();
	}
	
	public void iniciarJuego() {
		setTitle("Tetris Original");
		setBounds(100, 100, 960, 872);
		getContentPane().setLayout(null);
		setBackground(Color.GRAY);
		
		Button iniciarJuego = new Button("Arrancamos");
		iniciarJuego.setBounds(750, 55, 70, 22);
		iniciarJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AudioClip audio = new AudioClip("");

			//	Tetris juego = new Tetris;						Hacer esa clase ya otro dia
			}
		});
		getContentPane().add(iniciarJuego);
	}

	private void menu() {
		barra = new JMenuBar();
		deshacer = new JMenu("Deshacer");
		rehacer = new JMenu("Rehacer");
		ayuda = new JMenu("Ayuda");
		verAyuda = new JMenuItem();
		ayuda.add(verAyuda);
		setJMenuBar(barra);
		barra.add(deshacer);
		barra.add(rehacer);
		barra.add(ayuda);
		setActionListener();
	}

	private void setActionListener() {

		verAyuda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "");
			}
		});
		
		rehacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		deshacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
