package trampinho;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Arquivo arquivo = new Arquivo();
		
		/* Criando os objetos da classe Ordena��o e Busca Binaria */
		Ordenacao imprimir = new Ordenacao();
        Ordenacao ordenar = new Ordenacao();
        BuscaBinaria buscar = new BuscaBinaria();
        int[] arrayDesordenado = new int[24];
        int[] arrayOrdenado = new int[24];
        int[] array = new int [24];
        int chaveBinaria;
        char resposta;
      
        /* Passando um vetor com parametro de numeros desordenados e indicando uma variavel de endere�o do arquivo com os numeros */
        arrayDesordenado = arquivo.lerArquivo("inserir/endereco/arquivo");
        
        do {
        System.out.println("Escolha um M�todo de Ordena��o ou Pesquisa para fazer a leitura dos Numeros: " + "\n"
        + "[1] para Ordena��o BubbleSort" + "\n"
        + "[2] para Ordena��o InsertionSort" + "\n"
        + "[3] para Ordena��o MergeSort" + "\n"
        + "[4] para ordena��o QuickSort" + "\n"
        + "[5] para fazer uma Busca Bin�ria Recursiva");
        int digito = sc.nextInt();
        
        /* Endere�o de sa�da da ordena��o do novo arquivo gerado */
        arquivo.gravarArquivo("inserir/endereco/arquivo", arrayOrdenado);
        
        
        
        /* Escolha do tipo de metodo desejado, passando o parametro do vetor dos numeros desordenados e puxando o metodo de cada novo objeto 
         * criado
        */
        switch (digito) {
        case 1: 
        	arrayOrdenado = ordenar.bubbleSort(arrayDesordenado);
        	imprimir.imprimirVetor(arrayOrdenado);
        	break;
        case 2:
        	arrayOrdenado = ordenar.insertionSort(arrayDesordenado);
        	imprimir.imprimirVetor(arrayOrdenado);
        	break;
        case 3:
        	arrayOrdenado = ordenar.mergeSort(arrayDesordenado);
        	imprimir.imprimirVetor(arrayOrdenado);
        	break;
        case 4:
        	arrayOrdenado = ordenar.quickSort(arrayDesordenado);
        	imprimir.imprimirVetor(arrayOrdenado);
        	break;
        case 5:
        	for(int i = 0;i < 24; i++) {
        		array[i] = arrayOrdenado[i];
        	}
        	System.out.println("Digite o numero da Array que voc� quer buscar a sua posi��o: ");
        	chaveBinaria = sc.nextInt();
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			System.out.println("O numero " + chaveBinaria + " est� na posi��o: " + BuscaBinaria.busca(array, chaveBinaria));
			break;
		default:
			System.out.println("Saindo do programa...");
			break;
        }
        
		System.out.println("Voc� desejar realizar mais alguma Opera��o? [S] ou [N]");
		resposta = (char)System.in.read();
        } while (resposta == 'S');
    }
}