package figuras;

import java.util.ArrayList;

public class Geometria {
	public static void main (String [] args) {
		ArrayList<Figura> figuras = new ArrayList<>();
		figuras.add(new Trapezio(1,2));
		figuras.add(new Circulo());
		figuras.add(new Triangulo(1,2));
		figuras.add(new Losango(3,2));
		figuras.add(new Quadrado(3,2));
		figuras.add(new Retangulo(1,2));
				
	}
}
