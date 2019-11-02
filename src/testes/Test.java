package testes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import manipulacao.ManipuladorDeDados;
import selection.Selection;

public class Test {
	
	public static void main (String[] args) throws IOException {
		int TOTALREPETICOES =2; // QUANTIDADE DE VEZES QUE O ALGORITMO IR� REPETIR AS ORDENA��ES
		int TOTALAMOSTRAS = 5; // QUANTIDADE DE AMOSTRAS POR ORDENA��O
		
		
		long [][] armazenarDados = new long [TOTALREPETICOES][TOTALAMOSTRAS];	
		int quantidadeElementos = 10000;
		String resultado = "Amostras.txt";
		File pasta = new File (resultado); 
		pasta.createNewFile();
		PrintWriter pw = new PrintWriter (resultado);
		
		for (int repeticoes=0; repeticoes<TOTALREPETICOES; repeticoes++) { //INICIO PRIMEIRO FOR
			
			
				
			for (int amostras=0;  amostras<TOTALAMOSTRAS; amostras++) { //INICIO SEGUNDO FOR
				//int quantidadeElementos = 10000; //QUANTIDADE DE ELEMENTOS QUE O ARQUIVO TER� INICIALMENTE
				String nomeArquivo = "Dados" + amostras + ".txt"; //Nome do Arquivo que ser� armazenado os dados
					
				Selection conjunto = new Selection ((quantidadeElementos*(amostras+1)),nomeArquivo);
					
				long tempoInicial =  System.currentTimeMillis();// PEGA O TEMPO INICIAL
								
				Integer [] vetorOrdenado = conjunto.ordenacaoSelection(); //OBTENDO O VALOR ORDENADO
					
				long tempoFinal =  (System.currentTimeMillis() - tempoInicial); //PEGA O TEMPO FINAL
							
				
				armazenarDados[repeticoes][amostras] = tempoFinal;
				pw.println ((quantidadeElementos*(amostras+1))+";" + tempoFinal);
				
				String nomeArqOrdenado = "Resultado" + (amostras+1) + ".txt"; // CRIA��O DO ARQUIVO ORDENADO
					
				ManipuladorDeDados.escreverResultadoEmArquivo(vetorOrdenado.length, 
						nomeArqOrdenado, vetorOrdenado); // ESCREVENDO O RESULTADO DA ORDENA��O NO ARQUIVO
					
			} // FIM FOR 2			
		} // FIM do processo de ordena��o SELECTION
					
		
			ManipuladorDeDados.calcularMedias(armazenarDados, TOTALREPETICOES, TOTALAMOSTRAS, quantidadeElementos);
			// Chamada do m�todo para Calcular as M�dias
			pw.close();
	} // FIM MAIN
		
} // FIM classe TESTE

