package br.dev.simon.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ServerInfoResponse {

	private Long ramTotal;

	private Long ramLivre;

	private Long ramUsada;

	private Double discoTotal;

	private Double discoLivre;

	private Double discoUsado;

	@JsonInclude(Include.NON_EMPTY)
	private String mensagem;

	public Long getRamTotal() {
		return ramTotal;
	}

	public void setRamTotal(Long ramTotal) {
		this.ramTotal = ramTotal;
	}

	public Long getRamLivre() {
		return ramLivre;
	}

	public void setRamLivre(Long ramLivre) {
		this.ramLivre = ramLivre;
	}

	public Long getRamUsada() {
		return ramUsada;
	}

	public void setRamUsada(Long ramUsada) {
		this.ramUsada = ramUsada;
	}

	public Double getDiscoTotal() {
		return discoTotal;
	}

	public void setDiscoTotal(Double discoTotal) {
		this.discoTotal = discoTotal;
	}

	public Double getDiscoLivre() {
		return discoLivre;
	}

	public void setDiscoLivre(Double discoLivre) {
		this.discoLivre = discoLivre;
	}

	public Double getDiscoUsado() {
		return discoUsado;
	}

	public void setDiscoUsado(Double discoUsado) {
		this.discoUsado = discoUsado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
