import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {

		JButton jugarBoton = new JButton("Jugar");
		getContentPane().add(jugarBoton, BorderLayout.CENTER);
		jugarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaJugar vent = new VentanaJugar();
				vent.iniciarJuego();
			}
		});

		JButton nuevoMapaBoton = new JButton("Nuevo Mapa");
		getContentPane().add(nuevoMapaBoton, BorderLayout.EAST);
		nuevoMapaBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaNuevoMapa mapa = new VentanaNuevoMapa();
				mapa.iniciar();
			}
		});
	}
	
}
