package br.com.basis;

public class Desafio {

	public static void main(String[] args) {
		System.out.println(verificarBalanc("((1+1)*2) + (10+2) + (((2-1)-1)*1)"));
		System.out.println(verificarBalanc("O Fulano (aquele que fez aniversário hoje) perguntou por você."));
		System.out.println(verificarBalanc("&:)"));
		System.out.println(verificarBalanc("#:)"));
	}

	/**
	 * Método recursivo utilizado para para verificar o balanceamento 
	 * dos parêntesis em uma string de entrada
	 * @param stringParam
	 * @return
	 */
	public static Boolean verificarBalanc(String stringParam) {
		int esquerda = 0;
		int direita = 0;
		StringBuilder stringParamBuilder = new StringBuilder(stringParam);

		// verifica se string esta vazia
		if (stringParam.isEmpty())
			return true;

		// procura parentese abrindo
		esquerda = stringParamBuilder.indexOf("(");
		
		// procura parentese fechando
		direita = stringParamBuilder.indexOf(")");

		// verifica se acabou os parenteses
		if (esquerda == -1 && direita == -1)
			return true;

		// verifica existe apenas um parentese
		if ((esquerda == -1 && direita != -1) || (esquerda != -1 && direita == -1))
			return false;

		//exclui o parentese abrindo
		stringParamBuilder.deleteCharAt(esquerda);
		//recupera novo index do parentese fechando
		direita = stringParamBuilder.lastIndexOf(")");
		//exclui o parentese abrindo
		stringParamBuilder.deleteCharAt(direita);

		return verificarBalanc(stringParamBuilder.toString());
	}

}
