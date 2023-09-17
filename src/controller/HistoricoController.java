package controller;

import javax.swing.JOptionPane;

import model.PilhaString;

public class HistoricoController {
	
	//Adciona um novo endereço no histórico
	public void inserirEndereco(PilhaString historico, String endereco) {
		 
		endereco = endereco.toLowerCase();	//Faz com que os caracteres da string fiquem minúsculos
		
		//Armazena o endereço repartido em um vetor
		String validar_http[] = endereco.split("://");	//A repartição é feita onde houver '//' na string
		
		//Verifica se o site possui o protocolo de comunicação, e se está no local correto
//		String http = validar_http[0];
		if (!validar_http[0].contains("http") || !validar_http[0].equals("https")) {
			JOptionPane.showMessageDialog(null, "O endereco do site não contem o protocolo de comunicacao (http://)!");
			
		} else {
			//Armazena parte do endereço já repartido em outro vetor
			String validar_www[] = validar_http[1].split(".");	//A repartição é feita onde houver '.' na string
			
			//Verifica se o site tem  'www' e se está no local correto do endereço	
			if (!validar_www[0].equals("www")) {
				JOptionPane.showMessageDialog(null, "O endereco do site precisa ter referancia à rede mundial de computadores(www)!");
				
			} else {
				historico.push(endereco);	//Adiciona o endereço ao histórico
				System.out.println("Site salvo no histórico");
		}
		}
	}
	//Exclui o último endereço registrado no histórico
	public void removerEndereco(PilhaString historico) {
		if (historico.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O historico esta vazio!");
		} else {
			try {
				historico.pop();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("O último site visitado foi removido do histórico");
			if (historico.isEmpty()) {
				System.err.println("O último endereço foi removido do histórico!");
			}
		}
	}
	//Consulta o último endereço registrado no histórico
	public void consultarEndereco(PilhaString historico) {
		if (historico.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O historico esta vazio!");
		} else {	//Se o histórico não estiver vazio
			try {
				System.out.println(historico.top());	//Mostra o último site visitado 
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (historico.size() == 1) {	//Verifica se é o último endereço da pilha
				System.err.println("Este é o único endereço do histórico!");
			}
		}
	}
}
