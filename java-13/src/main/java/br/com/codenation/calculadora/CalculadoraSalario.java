package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double baseSalary) {
		if(baseSalary < 1039.0) return 0;
		double salary = calcularInss(baseSalary);
		salary = calculateIrrf(salary);

		return Math.round(salary);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double baseSalary) {
		if (baseSalary > 0.0 && baseSalary <= 1500.0) return baseSalary * 0.92;
		else if (baseSalary > 1500.0 && baseSalary <= 4000.0) return baseSalary * 0.91;
		else if (baseSalary > 4000.0) return baseSalary * 0.89;

		return 0.0;
	}

	private double calculateIrrf(double salary){
		if(salary > 0.0 && salary <= 3000.0) return salary;
		else if(salary > 3000.0 && salary <= 6000.0) return salary * 0.925;
		else if(salary > 6000.0) return salary * 0.85;

		return 0.0;
	}

}
