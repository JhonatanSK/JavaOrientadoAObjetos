package main;

import javax.swing.JOptionPane;

import service.PaisService;
import model.Pais;

public class TestePais {

	public static void main(String[] args) {
		
		iniciarPrograma();
	}
	
	public static void iniciarPrograma() {
		PaisService paisService = new PaisService();
		
		while(true) {
		
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite o que voc� deseja fazer: \n "
					+ "1 - Cadastrar um pa�s \n 2 - Buscar um pais \n 3 - Atualizar um pais \n 4 - Excluir um pa�s \n "
					+ "5 - Buscar pelo maior numero de habitantes \n 6 - Buscar pela menor �rea \n 7 - Buscar 3 pa�ses \n 8 - Sair"));
			if (pergunta == 1) {
				String nome = JOptionPane.showInputDialog("Digite o nome do pa�s");
				long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o n�mero da popula��o do pa�s"));
				double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a �rea total do pa�s"));
				
				Pais to = new Pais(nome, populacao, area);
				paisService.criar(to);
				JOptionPane.showMessageDialog(null, "Pa�s cadastrado com sucesso");
			}
			else if (pergunta == 2) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do pa�s: "));
				
				JOptionPane.showMessageDialog(null,paisService.carregar(id));
			}
			else if (pergunta == 3) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do pa�s que voc� deseja atualizar: "));
				String nome = JOptionPane.showInputDialog("Digite o nome do pa�s");
				long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o n�mero da popula��o do pa�s"));
				double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a �rea total do pa�s"));
				
				Pais to = new Pais(id, nome, populacao, area);
				
				paisService.atualizar(to);
				JOptionPane.showMessageDialog(null, "Pa�s Atualizado!");
				JOptionPane.showMessageDialog(null, paisService.carregar(id));
				
			}
			else if (pergunta == 4) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do pa�s que voc� deseja excluir: "));	
				Pais to = new Pais(id);
				
				paisService.excluir(to);
				JOptionPane.showMessageDialog(null, "Pa�s Excluido!");
				
			}
			else if (pergunta == 5) {
				JOptionPane.showMessageDialog(null,paisService.retornarMaiorHabitantes());
			}
			else if (pergunta == 6) {
				JOptionPane.showMessageDialog(null,paisService.retornarMenorArea());
			}
			else if (pergunta == 7) {

				JOptionPane.showMessageDialog(null, paisService.retornarTresPaises());
			}
			
			else if (pergunta == 8) {
				break;
			}
		}
	}
}
