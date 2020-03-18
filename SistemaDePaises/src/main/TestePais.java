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
		
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite o que você deseja fazer: \n "
					+ "1 - Cadastrar um país \n 2 - Buscar um pais \n 3 - Atualizar um pais \n 4 - Excluir um país \n "
					+ "5 - Buscar pelo maior numero de habitantes \n 6 - Buscar pela menor área \n 7 - Buscar 3 países \n 8 - Sair"));
			if (pergunta == 1) {
				String nome = JOptionPane.showInputDialog("Digite o nome do país");
				long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da população do país"));
				double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a área total do país"));
				
				Pais to = new Pais(nome, populacao, area);
				paisService.criar(to);
				JOptionPane.showMessageDialog(null, "País cadastrado com sucesso");
			}
			else if (pergunta == 2) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país: "));
				
				JOptionPane.showMessageDialog(null,paisService.carregar(id));
			}
			else if (pergunta == 3) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país que você deseja atualizar: "));
				String nome = JOptionPane.showInputDialog("Digite o nome do país");
				long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da população do país"));
				double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a área total do país"));
				
				Pais to = new Pais(id, nome, populacao, area);
				
				paisService.atualizar(to);
				JOptionPane.showMessageDialog(null, "País Atualizado!");
				JOptionPane.showMessageDialog(null, paisService.carregar(id));
				
			}
			else if (pergunta == 4) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país que você deseja excluir: "));	
				Pais to = new Pais(id);
				
				paisService.excluir(to);
				JOptionPane.showMessageDialog(null, "País Excluido!");
				
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
