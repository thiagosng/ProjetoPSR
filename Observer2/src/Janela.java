import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Janela {

	private static Frame tela = new Frame("Observador 2 - OMS");

	
	public  Label createContentPane () {
		
		//Texto de informa��o da janela
		Label texto = new Label("Aguardando informa��es sobre o n�mero de mortes por COVID-19...");
		texto.setAlignment(Label.CENTER);
		texto.setSize(texto.getPreferredSize());
		
		return texto;
	}
	
	public static void createGUI (boolean acao) {
		if(acao == true) {
			Janela texto = new Janela ();
			
			//Cria��o da janela principal
			tela.setVisible(true);
			tela.setSize(500,100);
			tela.add(texto.createContentPane());
			//Evento para encerrar a janela
			tela.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			//Centraliza a janela
			tela.setLocationRelativeTo(tela);
		}else {
			/*
			 * Quando o tipo booleano false � passado para este m�todo, a tela ser� ocultada. 
			 * Quando o m�todo for chamado com o tipo booleano true como par�metro, a tela ser� reconstru�da.
			 */
			tela.dispose();
		}
		
	}
	
	public static void centralizaJanela () {
		tela.setLocationRelativeTo(null);
	}
	
}
