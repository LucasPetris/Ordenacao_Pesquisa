package trampinho;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


/* Cria um Objeto Arquivo e insere o arquivo txt com numeros para lançar num array */
public class Arquivo {
	public int[] lerArquivo(String endereco) throws FileNotFoundException, IOException {

        File arquivo = new File(endereco);

        int[] array = new int[24];
       
        String dadosdatabase = null;
        
        FileReader filereader = new FileReader(arquivo);
        
        BufferedReader bufferreader = new BufferedReader(filereader);
        
        while (bufferreader.ready()) {

           dadosdatabase = bufferreader.readLine();
 
        }
       
        int counter = 0;

        StringTokenizer databasetoken = new StringTokenizer(dadosdatabase, ";");

        while (databasetoken.hasMoreTokens()) {
            array[counter] = Integer.parseInt(databasetoken.nextToken());
            counter++;
        }

        bufferreader.close();
        filereader.close();

        return array;
    }

	
	/* Saída do arquivo ordenado, cria um novo arquivo com os numeros ordenados e com sua gravação */
    public void gravarArquivo(String endereco, int[] array) throws IOException {

        File arquivo = new File(endereco);

        try {

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(endereco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int counter = 0; counter < (array.length - 1); counter++) {
                bw.write(array[counter]+";");
                //bw.newLine();
            }
            
            bw.close();
            fw.close();

            /* se o arquivo não for achado ou está incorreta o endereço o catch entrega a mensagem de arquivo invalido */
        } catch (IOException ex) {
        	System.out.println("Erro na leitura do Arquivo, tente novamente!!!");
        }
    }
}

