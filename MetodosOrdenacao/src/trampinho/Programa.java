package trampinho;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Arquivo arquivo = new Arquivo();
		
		/* Criando os objetos da classe Ordenação e Busca Binaria */
		Ordenacao imprimir = new Ordenacao();
        Ordenacao ordenar = new Ordenacao();
        BuscaBinaria buscar = new BuscaBinaria();
        int[] arrayDesordenado = new int[24];
        int[] arrayOrdenado = new int[24];
        int[] array = new int [24];
        int chaveBinaria;
        char resposta;
      
        /* Passando um vetor com parametro de numeros desordenados e indicando uma variavel de endereço do arquivo com os numeros */
        arrayDesordenado = arquivo.lerArquivo("inserir/endereco/arquivo");
        
        do {
        System.out.println("Escolha um Método de Ordenação ou Pesquisa para fazer a leitura dos Numeros: " + "\n"
        + "[1] para Ordenação BubbleSort" + "\n"
        + "[2] para Ordenação InsertionSort" + "\n"
        + "[3] para Ordenação MergeSort" + "\n"
        + "[4] para ordenação QuickSort" + "\n"
        + "[5] para fazer uma Busca Binária Recursiva");
        int digito = sc.nextInt();
        
        /* Endereço de saída da ordenação do novo arquivo gerado */
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
        	System.out.println("Digite o numero da Array que você quer buscar a sua posição: ");
        	chaveBinaria = sc.nextInt();
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			System.out.println("O numero " + chaveBinaria + " está na posição: " + BuscaBinaria.busca(array, chaveBinaria));
			break;
		default:
			System.out.println("Saindo do programa...");
			break;
        }
        
		System.out.println("Você desejar realizar mais alguma Operação? [S] ou [N]");
		resposta = (char)System.in.read();
        } while (resposta == 'S');
    }
}