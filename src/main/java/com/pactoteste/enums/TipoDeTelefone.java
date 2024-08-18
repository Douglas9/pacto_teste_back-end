package com.pactoteste.enums;

public enum TipoDeTelefone {
	
    RESIDENCIAL("RESIDENCIAL"),
    CELULAR("CELULAR");

    private String descricao;

    TipoDeTelefone(String descricao) {
		this.descricao = descricao;
	}


    public String getDescricao() {
        return descricao;
    }

}
