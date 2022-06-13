import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String size = scan.nextLine();
		char[][] mapa;
		int filas, columnas;
		try {
			filas = Integer.valueOf(size.split(" ")[0]);
			columnas = Integer.valueOf(size.split(" ")[1]);
			mapa = new char[filas][columnas];
			for (int i = 0; i < filas; i++) {
				mapa[i] = scan.nextLine().toCharArray();
				if(mapa[i].length!=columnas) throw new Exception();
			}
			
			caracteresValidos(mapa);
			interiorValido(mapa);
			caracteresExterior(mapa);
			bordes(mapa);
			robots(mapa);
			cajasHuecos(mapa);

			for (int i = 0; i < mapa.length; i++) {
				for (int j = 0; j < mapa[i].length; j++) {
					System.out.print(mapa[i][j]+" ");
				}
				System.out.println();
			}
			Sokoban soko = new Sokoban();
			soko.creacion(mapa, filas, columnas);
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Entrada mal formada.");
		}

	}

	private static void cajasHuecos(char[][] mapa) throws Exception {
		int cosas=0, sitios=0;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(mapa[i][j]=='#') cosas++;
				if(mapa[i][j]=='!' || mapa[i][j]=='+') sitios++;
			}
		}
		if(cosas!=sitios) throw new Exception();
	}

	private static void robots(char[][] mapa) throws Exception {
		boolean robot=false;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(mapa[i][j]=='@') {
					if(robot==false) robot = true;
					else throw new Exception();
				}
			}
		}
		if(robot==false) throw new Exception();
	}

	private static void bordes(char[][] mapa) throws Exception {	
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(mapa[i][j]!='0' && mapa[i][j]!=' ') {
					if(i>0 && mapa[i-1][j]==' ' || i<mapa.length-1 && mapa[i+1][j]==' ') throw new Exception();
				}
			}
		}
	}

	private static void caracteresExterior(char[][] mapa) throws Exception {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(mapa[i][j]!='0' && mapa[i][j]!=' ') {
					if(j==0 || j==mapa[i].length-1 || i==0 || i==mapa.length-1) throw new Exception();
					if(j>0 && mapa[i][j-1]==' ' || j<mapa[i].length && mapa[i][j+1]==' ') throw new Exception();
				}
			}
		}
	}

	private static void interiorValido(char[][] mapa) throws Exception {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(j>0 && j<mapa[i].length-1 && (mapa[i][j]=='0' || mapa[i][j]==' ') && 
						(mapa[i][j-1]!='0' && mapa[i][j-1]!=' ') && 
						(mapa[i][j+1]!='0' && mapa[i][j+1]!=' ')) throw new Exception();
			}
		}
	}

	private static void caracteresValidos(char[][] mapa) throws Exception {
		int contador=0;
		for (int i = 0; i < mapa.length; i++) {
			contador = 0;
			for (int j = 0; j < mapa[i].length; j++) {
				if(mapa[i][j]==' ') contador++;
				if(mapa[i][j]!=' ' && mapa[i][j]!='0' && mapa[i][j]!='1' &&
				   mapa[i][j]!='-' && mapa[i][j]!='@' && mapa[i][j]!='+' &&
				   mapa[i][j]!='#' && mapa[i][j]!='!' && mapa[i][j]!='*') throw new Exception();
			}
			if(contador==mapa[0].length) throw new Exception();
		}
		
	}
}