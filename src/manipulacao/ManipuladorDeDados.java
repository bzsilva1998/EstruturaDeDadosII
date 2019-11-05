package manipulacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManipuladorDeDados {
	
	public static List <Integer> leitorDeDados(String nomeArquivo) { // ESTE M�TODO FAZ A LEITURA
		//DE UM ARQUIVO E COLOCA OS ELEMENTOS EM UMA LISTA
		
	List <Integer> conjuntoElementos = new ArrayList <>();
		
		try {
			BufferedReader lerArq = new BufferedReader (new FileReader(nomeArquivo));
			String linha = lerArq.readLine();
							
			while (linha != null) {	
				conjuntoElementos.add(Integer.parseInt(linha));
				linha = lerArq.readLine();	
			} //fim While
			
			lerArq.close();
		} catch (IOException e) {
			System.err.printf ("N�o foi poss�vel abrir o arquivo: %s\n", e.getMessage());
		} //fim Catch
	
		return conjuntoElementos;
	} //FIM LEITOR DE DADOS
	
	public static void escreverResultadoEmArquivo (int qtdElementos, String nomeArquivo, Integer [] vetor ) throws IOException {
		// M�todo que ir� escrever elementos em um arquivo TXT j� criado
		
		BufferedWriter buff = new BufferedWriter (new FileWriter(nomeArquivo)); 

			for (int i=0; i<qtdElementos; i++) {
				buff.append(vetor[i] + "\n");
			}
		buff.close();
	}
	
	public static void gerarNumerosAleatorios (int qtdElementos, String nomeArquivo) throws IOException {
		// M�todo que ir� criar um arquivo com a quantidade de elementos 
		// passada como par�metro
		
		BufferedWriter buff = new BufferedWriter (new FileWriter(nomeArquivo));
		//wri = new FileWriter (nomeArquivo);
		Random gerador = new Random();
		for (int i=1; i<=qtdElementos; i++) {
			buff.append(gerador.nextInt()+"\n");
		}
		buff.close();
	} // Fim do M�todo GerarNumerosAleatorios
	
	public static void calcularMedias (long [][] matriz, int linha, int coluna, int qtdElementos) throws IOException {
		int vet[] = new int [coluna];
		BufferedWriter buff = new BufferedWriter (new FileWriter ("medias.txt"));
		for (int k=0; k<coluna; k++)
		{		
			for (int i=0; i<linha; i++) {
				for (int j=0; j<coluna; j++) {
					if (k==j) {
						vet[k] += matriz[i][j]; // Soma o numero de tempo e coloca num espa�o
					}
				}
			} 
		} 
		//buff.append("Medias obtidas ap�s coleta de amostras:\n"); //Essa frase vai ser tirada depois
		for (int x=0; x<coluna; x++) {
			vet[x] = vet[x]/linha;
			buff.append(qtdElementos +": " + (vet[x]*0.0001) +"\n");
			qtdElementos += 10000;
		} // Calcula a m�dia
		
		buff.close();
	} // Fim CalcularMedias
} //Fim Class ManipuladorDeDados
