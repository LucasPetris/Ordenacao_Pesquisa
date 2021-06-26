package trampinho;

/* Criação da classe MergeSort com a saída do seu respectivo metódo de ordenação */
public class MergeSort {
	
	 public static int[] sort(int[] array) {
	       
	        if (array.length <= 1) {
	           
	            return array;
	        }
	        int meio = array.length / 2;
	        int[] dir = array.length % 2 == 0 ? new int[meio] : new int[meio + 1];
	        int[] esq = new int[meio];

	        int[] aux = new int[array.length];

	        for (int i = 0; i < meio; i++) {
	            esq[i] = array[i];
	        }

	        int auxIndex = 0;
	        for (int i = meio; i < array.length; i++) {
	            dir[auxIndex] = array[i];
	            auxIndex++;
	        }

	        esq = sort(esq);
	        dir = sort(dir);

	        aux = mergesort(esq, dir);

	        return aux;
	    }

	    static int[] mergesort(int[] esq, int[] dir) {
	        int[] aux = new int[esq.length + dir.length];

	        int indexDir = 0, indexEsq = 0, indexAux = 0;

	        while (indexEsq < esq.length || indexDir < dir.length) {
	            if (indexEsq < esq.length && indexDir < dir.length) {
	                if (esq[indexEsq] <= dir[indexDir]) {
	                    aux[indexAux] = esq[indexEsq];
	                    indexAux++;
	                    indexEsq++;
	                } else {
	                    aux[indexAux] = dir[indexDir];
	                    indexAux++;
	                    indexDir++;
	                }
	            } else if (indexEsq < esq.length) {
	                aux[indexAux] = esq[indexEsq];
	                indexAux++;
	                indexEsq++;
	            } else if (indexDir < dir.length) {
	                aux[indexAux] = dir[indexDir];
	                indexAux++;
	                indexDir++;
	            }
	        }
	        return aux;
	    }
	}
