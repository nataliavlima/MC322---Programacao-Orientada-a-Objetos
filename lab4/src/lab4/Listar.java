package lab4;

public enum Listar {
	LISTAR_CLIENTE("Listar cliente"),
	LISTAR_SINISTROS_SEG("Listar sinistros por seguradoras"),
	LISTAR_SINISTROS_CLI("Listar sinistros por clientes"),
	LISTAR_VEICULO_CLI("Listar veículo por clientes"),
	LISTAR_VEICULO_SEG("Listar veículo por seguradora"),
	VOLTAR("Voltar");
	
	public final String operacao;
	
	Listar(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
		return this.operacao;
	}
}
