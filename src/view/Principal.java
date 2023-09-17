package view;

import javax.swing.JOptionPane;

import controller.HistoricoController;
import model.PilhaString;

public class Principal {

	public static void main(String[] args) {
		PilhaString historico = new PilhaString();
		HistoricoController hist = new HistoricoController();
		
		int menu;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n1 - Inserir novo endereço de site"
					+ "\n2 - Remover o último endereço do histórico \n3 - Remover o último endereco da pilha \n9 - para finalizar"));
			switch (menu) {
			case 1:
				String endereco = JOptionPane.showInputDialog("Insira o endereco do site para armazenar no historico: ");
				hist.inserirEndereco(historico, endereco);
				break;
			
			case 2:
				hist.removerEndereco(historico);
				break;
			case 3:
				hist.consultarEndereco(historico);
				break;
			case 9:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Numero invalido!");
				break;
			}
		} while (menu != 9);
	}

}
