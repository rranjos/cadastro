package br.com.otima.cadastro.strategy;

public enum StrategyName {

	ImportCSV("ImportCSV"), ImportTXT("ImportTXT"), ImportJSON("ImportJSON");

	private final String nome;

	StrategyName(String nome) {
		this.nome = nome;
	}
	
	

}
