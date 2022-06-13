import java.util.ArrayList;

public class Sokoban {
	private ArrayList<ArrayList<Movimiento>> arbol = new ArrayList<>();

	public void creacion(char[][] mapa, int filas, int columnas) {
		int[] pos= busca(mapa, filas, columnas);
		int f = pos[0], c = pos[1];
		arbol(mapa, filas, columnas, f, c);
	}

	private int[] busca(char[][] mapa, int filas, int columnas) {
		int pos[] = new int[2];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if(mapa[i][j]=='@' || mapa[i][j]=='+') {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}

	private void arbol(char[][] mapa, int filas, int columnas, int f, int c) {
		ArrayList<Movimiento> nodo = new ArrayList<>();
		boolean[] dir = puede(mapa, f, c);
		System.out.println(dir[0] + " "  + dir[1] + " "+ dir[2] + " "+ dir[3] + " "+ f  +" " + c);
		for (int d = 0; d < 4; d++) {
			char[][] copia = new char[filas][columnas];
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					copia[i][j] = mapa[i][j];
				}
			}
			if(dir[d]) {
				
				char direccion = desplaza(copia, f, c, d);
				Movimiento m = new Movimiento(copia, direccion);
				nodo.add(m);
			}
		}
		
		for (int i = 0; i <filas; i++) {			
			for (int j = 0; j < nodo.size(); j++) {
				nodo.get(j).imprimeFila(i);
			}
			System.out.println();
		}
		
		arbol.add(nodo);
		
	}

	private boolean[] puede(char[][] mapa, int f, int c) {
		boolean[] direcciones = {false, false, false, false};
		//direccion derecha
		if(mapa[f][c+1]=='-' || mapa[f][c+1]=='!' || 
				(mapa[f][c+1]=='#' && (mapa[f][c+2]=='-' || mapa[f][c+2]=='!'))) direcciones[0]=true;
		//direccion izquierda
		if(mapa[f][c-1]=='-' || mapa[f][c-1]=='!' || 
				(mapa[f][c-1]=='#' && (mapa[f][c-2]=='-' || mapa[f][c-2]=='!'))) direcciones[1]=true;
		//direccion arriba
		if(mapa[f-1][c]=='-' || mapa[f-1][c]=='!' || 
				(mapa[f-1][c]=='#' && (mapa[f-2][c]=='-' || mapa[f-2][c]=='!'))) direcciones[2]=true;
		//direccion abajo
		if(mapa[f+1][c]=='-' || mapa[f+1][c]=='!' || 
				(mapa[f+1][c]=='#' && (mapa[f+2][c]=='-' || mapa[f+2][c]=='!'))) direcciones[3]=true;
		return direcciones;
	}

	private char desplaza(char[][] copia, int f, int c, int dir){
		switch(dir) {
		case 0://derecha
			return desplazamiento(copia, f, c, f, c+1, f, c+2, "d");
		case 1://izquierda
			return desplazamiento(copia, f, c, f, c-1, f, c-2, "i");
		case 2://arriba
			return desplazamiento(copia, f, c, f-1, c, f-2, c, "a");
		case 3://abajo
			return desplazamiento(copia, f, c, f+1, c, f+2, c, "b");
		}
		return ' ';
	}


	private char desplazamiento(char[][] copia, int f, int c, int f2, int c2, int f3, int c3, String direccion) {
		if(copia[f2][c2]=='#'){
			direccion = direccion.toUpperCase();
			if(copia[f3][c3]=='-') copia[f3][c3]='#';
			else copia[f3][c3]='*';
			
			if(copia[f2][c2]=='#') copia[f2][c2]='-';
			else copia[f2][c2]='!';
		} 
		
		if(copia[f2][c2]=='!')  copia[f2][c2]='+';
		else copia[f2][c2]='@';
		
		if(copia[f][c]=='@') copia[f][c]='-';
		else copia[f][c]='!';
		return direccion.charAt(0);
	}
}
