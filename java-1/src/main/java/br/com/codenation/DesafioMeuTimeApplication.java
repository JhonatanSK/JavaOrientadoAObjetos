package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	List<Jogador> jogadores = new ArrayList<Jogador>();
	List<Time> times = new ArrayList<Time>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(verificarSeTimeExiste(id))  throw new IdentificadorUtilizadoException();
		try{
			Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			times.add(time);
		}catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(verificarSeExisteJogador(id))  throw new IdentificadorUtilizadoException();
		if(!verificarSeTimeExiste(idTime))  throw new TimeNaoEncontradoException();

		try{
			Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
			jogadores.add(jogador);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public void definirCapitao(Long idJogador) {
		verificarSeExisteJogador(idJogador);
		try{
			Long idTimeJogador = buscarIdTimePorJogador(idJogador);
			for(Jogador jogador: jogadores) {
				if (jogador.getIdTime() == idTimeJogador) {
					if (jogador.isCapitao() && jogador.getId() != idJogador) jogador.setCapitao(false);
					else if (!jogador.isCapitao() && jogador.getId() == idJogador) jogador.setCapitao(true);
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		try{
			verificarSeTimeExiste(idTime);
			for(Jogador jogador : jogadores){
				if(jogador.isCapitao() && jogador.getIdTime() == idTime) return jogador.getId();
			}

		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return 0L;
	}

	public String buscarNomeJogador(Long idJogador) {
		if(!verificarSeExisteJogador(idJogador)) throw new JogadorNaoEncontradoException();
		try{
			for(Jogador jogador : jogadores){
				if(jogador.getId() == idJogador) return jogador.getNome();
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return "";
	}

	public String buscarNomeTime(Long idTime) {
		if(!verificarSeTimeExiste(idTime)) throw new TimeNaoEncontradoException();
		try {
			for (Time time : times) {
				if (time.getId() == idTime) return time.getNome();
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return "";
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!verificarSeTimeExiste(idTime)) throw new TimeNaoEncontradoException();
		List<Long> jogadoresDoTime = new ArrayList<Long>();
		try {
			for (Jogador jogador : jogadores) {
				if (jogador.getIdTime() == idTime) jogadoresDoTime.add(jogador.getId());
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return jogadoresDoTime;

	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(!verificarSeTimeExiste(idTime)) throw new TimeNaoEncontradoException();
		Long idJogador = null;

		try {
			int maior = 0;
			int atual;
			for (Jogador jogador : jogadores) {
				if (jogador.getIdTime() == idTime) {
					atual = jogador.getNivelHabilidade();
					if (atual > maior) {
						maior = atual;
						idJogador = jogador.getId();
					}
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return idJogador;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if(!verificarSeTimeExiste(idTime)) throw new TimeNaoEncontradoException();
		Long idJogador = null;

		try {
			LocalDate maior = LocalDate.MAX;
			LocalDate atual;
			for (Jogador jogador : jogadores) {
				if (jogador.getIdTime() == idTime) {
					atual = jogador.getDataNascimento();
					if (atual.isBefore(maior)) {
						maior = atual;
						idJogador = jogador.getId();
					}
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return idJogador;
	}

	public List<Long> buscarTimes() {
		List <Long> idTimes = new ArrayList<Long>();
		if(times.size() > 0){
			for(Time time : times){
				idTimes.add(time.getId());
			}
		}
		return idTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(!verificarSeTimeExiste(idTime)) throw new TimeNaoEncontradoException();
		Long idJogador = null;

		try {
			BigDecimal maior = BigDecimal.ZERO;
			BigDecimal atual;
			for (Jogador jogador : jogadores) {
				if (jogador.getIdTime() == idTime) {
					atual = jogador.getSalario();
					if (atual.doubleValue() > maior.doubleValue()) {
						maior = atual;
						idJogador = jogador.getId();
					}
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return idJogador;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(!verificarSeExisteJogador(idJogador)) throw new JogadorNaoEncontradoException();
		try{
			for(Jogador jogador : jogadores){
				if(jogador.getId() == idJogador) return jogador.getSalario();
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}

		return BigDecimal.ZERO;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<Long>();
		try{
			Integer atual = 0;
			Integer anterior = 0;
			Long id = 0L;
			for(int i = 0; i < top; i++) {
				atual = 0;
				anterior = 0;
				id = 0L;
				for (Jogador jogador : jogadores) {
					atual = jogador.getNivelHabilidade();
					if ((atual > anterior) && (!topJogadores.contains(jogador.getId()))) {
						anterior = atual;
						id = jogador.getId();
					}
				}
				topJogadores.add(id);
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return topJogadores;
	}

	public boolean verificarSeExisteJogador(Long id) {
		if(jogadores.size() > 0){
			for (Jogador j : jogadores) {
				if (j.getId() == id) return true;
			}
		}
		return false;
	}

	public boolean verificarSeTimeExiste(Long id) {
		for(Time t : times) {
			if(t.getId() == id) return true;
		}
		return false;
	}

	public Long buscarIdTimePorJogador(long idJogador){
		for(Jogador jogador: jogadores){
			if(jogador.getId() == idJogador) return jogador.getIdTime();
		}
		return 0L;
	}

}
