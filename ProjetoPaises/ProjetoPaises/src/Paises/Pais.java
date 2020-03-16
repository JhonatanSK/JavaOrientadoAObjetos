package Paises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	public Pais() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}
	
	
	// CRUDS
	
	public void incluir(String nome, long populacao, double area) {
		String sqlInsert = "INSERT INTO paises(nome, populacao, area) values (?,?,?)";
	
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);
			stm.execute();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(int id, String nome, long populacao, double area) {
		String sqlUpdate = "UPDATE paises SET nome = ?, populacao = ?, area = ? where id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);	
			stm.setInt(4, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM paises where id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	public ArrayList buscar(int id) {
		ArrayList retorno = new ArrayList();
		String sqlInsert = "SELECT nome, populacao, area FROM paises WHERE paises.id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					retorno.add(rs.getString("nome"));
					retorno.add(rs.getLong("populacao"));
					retorno.add(rs.getDouble("area"));
				}
				else {
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return retorno;
				
	}
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	public ArrayList retornarMaiorHabitantes() {
		ArrayList retorno = new ArrayList();
		String sqlInsert = "Select id, nome, populacao, area FROM paises order by populacao desc limit 1";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					retorno.add(rs.getInt("id"));
					retorno.add(rs.getString("nome"));
					retorno.add(rs.getLong("populacao"));
					retorno.add(rs.getDouble("area"));
				}
				else {
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return retorno;
				
	}
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	public ArrayList retornarMenorArea() {
		ArrayList retorno = new ArrayList();
		String sqlInsert = "Select id, nome, populacao, area FROM paises order by area asc limit 1";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					retorno.add(rs.getInt("id"));
					retorno.add(rs.getString("nome"));
					retorno.add(rs.getLong("populacao"));
					retorno.add(rs.getDouble("area"));
				}
				else {
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return retorno;
				
	}
	
	//método que retorna um vetor de 3 países.
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList retornarTresPaises() {
		ArrayList paises = new ArrayList();
		Pais pais = new Pais();
		
		for(int i = 0; i < 3; i++) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do país: "));
			paises.add(pais.buscar(id));
		}
		
		return paises;
	}
	
}



