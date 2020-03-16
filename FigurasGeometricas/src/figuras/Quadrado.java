package figuras;

public class Quadrado extends Poligono implements Diagonal{

	public Quadrado(int base, int altura) {
		super(base, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		return getBase() * getAltura();	
	}

	@Override
	public double calculaDiagonal() {
		return Math.sqrt((Math.pow(getBase(), 2)+Math.pow(getAltura(), 2)));		
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 0;
	}

}
