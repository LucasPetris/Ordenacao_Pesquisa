package trampinho;

/* Criação da classe BubbleSort com a saída do seu respectivo metódo de ordenação */
public class BubbleSort {
	
	public int[] bubbleSort(int vetor[]) {
        long tempoinicial = System.currentTimeMillis();
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }
        
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de BubbleSort: " + tempototal + "ms");
        return vetor;
    }
}
