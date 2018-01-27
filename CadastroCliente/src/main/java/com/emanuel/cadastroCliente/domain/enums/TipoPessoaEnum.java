package com.emanuel.cadastroCliente.domain.enums;

public enum TipoPessoaEnum {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoPessoaEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPessoaEnum toEnum(Integer cod){
		if(cod == null){
			return null;
		}
		for(TipoPessoaEnum tipo : TipoPessoaEnum.values()){
			if(cod.equals(tipo.getCod())){
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + cod);
	}

}
