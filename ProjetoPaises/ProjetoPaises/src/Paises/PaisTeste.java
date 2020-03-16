package Paises;


import javax.swing.JOptionPane;

public class PaisTeste {

	public static void main(String[] args) {
		Pais pais = new Pais();
			
		while(true) {
		
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite o que você deseja fazer: \n "
					+ "1 - Cadastrar um país \n 2 - Buscar um pais \n 3 - Atualizar um pais \n 4 - Excluir um país \n "
					+ "5 - Buscar pelo maior numero de habitantes \n 6 - Buscar pela menor área \n 7 - Buscar 3 países \n 8 - Sair"));
			if (pergunta == 1) {
				String nome = JOptionPane.showInputDialog("Digite o nome do país");
				long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da população do país"));
				double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a área total do país"));
				
				pais.incluir(nome, populacao, area);
				JOptionPane.showMessageDialog(null, "País cadastrado com sucesso");
			}
			else if (pergunta == 2) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país: "));
				
				JOptionPane.showMessageDialog(null,pais.buscar(id));
			}
			else if (pergunta == 3) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país que você deseja atualizar: "));
				String nome = JOptionPane.showInputDialog("Digite o nome do país");
				long populacao = Long.parseLong(JOptionPane.showInputDialog("Digite o número da população do país"));
				double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a área total do país"));
				
				pais.atualizar(id, nome, populacao, area);
				JOptionPane.showMessageDialog(null, "País Atualizado!");
				JOptionPane.showMessageDialog(null,pais.buscar(id));
				
			}
			else if (pergunta == 4) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país que você deseja excluir: "));				
				pais.excluir(id);
				JOptionPane.showMessageDialog(null, "País Excluido!");
				
			}
			else if (pergunta == 5) {
				JOptionPane.showMessageDialog(null,pais.retornarMaiorHabitantes());
			}
			else if (pergunta == 6) {
				JOptionPane.showMessageDialog(null,pais.retornarMenorArea());
			}
			else if (pergunta == 7) {

				JOptionPane.showMessageDialog(null, pais.retornarTresPaises());
			}
			
			else if (pergunta == 8) {
				break;
			}
		}
			
	}

}
