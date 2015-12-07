package br.unb.sigra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;

@Entity
@Table(name="Aluno")
public class Aluno  implements Serializable {
	private static final long serialVersionUID = -3550966618742264684L;

	@Id
    @Column(name = "codigoPessoa", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "bloqueado", nullable = false, insertable = true, updatable = true)
	private Boolean bloqueado = false;
	@Column(name = "nome", nullable = false, insertable = true, updatable = true, unique = true)
	private String nome;
	@Column(name = "cpf", nullable = false, insertable = true, updatable = true, unique = true)
	private String cpf;
	
	@Column(name = "senha", nullable = false, insertable = true, updatable = true)
	private String senha;

	public Integer getId() {
		return id;
	}
	public void setId(Integer codigoPessoa) {
		this.id = codigoPessoa;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void validar(){
		EmsValidationException erro = new EmsValidationException();

		if(!EmsUtil.isFieldStrValid(getNome())){
			erro.addError("Informe o nome do aluno.");
		}
		
		if(!EmsUtil.isFieldStrValid(getCpf())){
			erro.addError("Informe o cpf do aluno.");
		}

		if(!EmsUtil.isFieldStrValid(getSenha())){
			erro.addError("Informe a senha do aluno.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
	}
}
