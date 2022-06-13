
public class Movimiento {
	private char[][] mapa;
	private char direccion;

	public Movimiento(char[][] copia, char direccion) {
		this.mapa = copia;
		this.direccion = direccion;
	}
	
	public char getDireccion() {
		return direccion;
	}
	
	public void imprimeFila(int i) {
		for (int j = 0; j < mapa[i].length; j++) {
			System.out.print(mapa[i][j]);
		}
		System.out.print(" ");
	}

}
