package trampinho;

/* Cria��o da classe Insertion Sort com a sa�da do seu respectivo met�do de ordena��o */
public class InsertionSort {
	
	public int[] insertionSort(int[] vetor) {
        long tempoinicial = System.currentTimeMillis();
        for (int i = 0; i < vetor.length; i++) {
            int atual = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] >= atual) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = atual;;
        }
        
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de InsertionSort: " + tempototal + "ms");
        return vetor;
    }
}
