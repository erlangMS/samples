package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Opcao;

@Stateless
public class PerguntaService {
	
	public Pergunta findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.findById(id);
	}

	public List<Pergunta> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Pergunta update(Pergunta pergunta){
		pergunta.validar();
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.update(pergunta);
	}

	public Pergunta insert(Pergunta pergunta) {
		pergunta.validar();
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.insert(pergunta);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.delete(id);
	}

	public Opcao registraRespostaParaPergunta(int idPergunta, Opcao resposta) {
		Pergunta pergunta = findById(idPergunta);
		return pergunta.registraResposta(resposta);
	}

	public void removeRespostaDaPergunta(int idPergunta, int idResposta) {
		QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.delete(Opcao.class, idResposta);
	}

	public List<Opcao> listaRespostaDaPergunta(int idPergunta) {
		Pergunta pergunta = findById(idPergunta);
		return pergunta.getRespostas();
	}
	
}
