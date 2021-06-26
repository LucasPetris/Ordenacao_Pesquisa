package trampinho;

/* Criação da Classe de Busca Binaria com seu respectivo metodo */
public class BuscaBinaria {
	
	public static int busca(int[] array, int chave) {
		return buscaBinariaRecursiva(array, 0, array.length - 1, chave);
	}

	public static int buscaBinariaRecursiva(int[] array, int menor, int maior,
			int chave) {
		int media = (maior + menor) / 2;
		int valorMeio = array[media];

		if (menor > maior)
			return -1;
		else if(valorMeio == chave) 
			return media;
		else if (valorMeio < chave)
			return buscaBinariaRecursiva(array, media+1, maior, chave);
		else
			return buscaBinariaRecursiva(array, menor, media-1, chave);
	}
}
