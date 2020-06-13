import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class Janela implements ActionListener {

	private static Frame tela = new Frame("Coronavirus");
	
	private StatusCovid e1 = new StatusCovid();
	
	private String temperatura = new String();
	
	private TextField campoDeEscrita = new TextField ();
	
	protected void createTelaDeTemperatura() {
		//Esconde a tela principal
		tela.dispose();
		
		Frame telaTemperatura = new Frame ("Número de mortes");
		//Configura o frame.
		telaTemperatura.setVisible(true);
		telaTemperatura.setSize(450, 200);
		telaTemperatura.setLayout( new GridLayout (3,1));
		
		
		
		
		Label l1 = new Label("Digite abaixo o número de mortes(Apenas números separados por '.') : ",Label.CENTER);
		
		Button b1 = new Button("Enviar dados");
		
		telaTemperatura.add(l1);
		telaTemperatura.add(campoDeEscrita,TextField.CENTER_ALIGNMENT);
		telaTemperatura.add(b1,Button.CENTER_ALIGNMENT);
		//Posiciona o frame no centro da tela.
		telaTemperatura.setLocationRelativeTo(null);
		
		telaTemperatura.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				temperatura = campoDeEscrita.getText().toString();//Passa o input do textfield para uma string
				if (temperatura.matches("^-?[0-9]*[.]{0,1}[0-9]*$")) { //Verifica se o input conteve apenas os caracteres entre 0 e 9, . e - 
					e1.AtualizarTemperatura(Float.parseFloat(temperatura));
					telaTemperatura.dispose();
					JOptionPane.showMessageDialog(null, "Numero de mortes enviado com sucesso!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
					tela.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, digite apenas números ou números separados por '.' ","ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	public static void createGUI () {
			
			Janela texto = new Janela ();
			
			Button b1 = new Button("Enviar o número de mortes");
			Button b2 = new Button("Alertas da Pandemia");
			
			Label l1 = new Label("Por favor, selecione uma das opções abaixo:", Label.CENTER);
			
			//Criação da janela principal
			tela.setVisible(true);
			tela.setSize(450,200);
			tela.setLayout(new GridLayout (3,1));
			
			
			
			//Evento para encerrar a janela
			tela.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			//Centraliza a janela
			tela.setLocationRelativeTo(null);
			//Adiciona componentes ao frame.
			tela.add(l1);
			tela.add(b1,Button.CENTER_ALIGNMENT);
			tela.add(b2,Button.CENTER_ALIGNMENT);
			
			//Adiciona funções para os botões b1 e b2.
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					texto.createTelaDeTemperatura();
				}
			});
			
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					texto.createTelaDeCatastrofe();
				}
			});
			
		
	}

	protected void createTelaDeCatastrofe() {
		//Esconde a tela principal
				tela.dispose();
				System.gc();
				
				Frame telaCatastrofe = new Frame ("Número de mortes por COVID-19");
				//Configuração do Frame
				telaCatastrofe.setVisible(true);
				telaCatastrofe.setSize(400, 300);
				telaCatastrofe.setLayout( new GridLayout (7,1));
				
				Button b1 = new Button("Alerta de Isolamento Social");
				Button b2 = new Button("Alerta de Quarentena");
				Button b3 = new Button("Alerta de Lockdown");
				
				//Adiciona os 3 botões no frame.
				telaCatastrofe.add(b1,Button.CENTER_ALIGNMENT);
				telaCatastrofe.add(b2,Button.CENTER_ALIGNMENT);
				telaCatastrofe.add(b3,Button.CENTER_ALIGNMENT);
				
				/*adiciona uma função para cada botão adicionado*/
				b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						e1.AlertaCatastrofe("Isolamento Social");
						telaCatastrofe.dispose();
						JOptionPane.showMessageDialog(null, "Alerta enviado com sucesso!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
						tela.setVisible(true);
					}
				});
				
				b2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						e1.AlertaCatastrofe("Quarentena");
						telaCatastrofe.dispose();
						JOptionPane.showMessageDialog(null, "Alerta enviado com sucesso!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
						tela.setVisible(true);
					}
				});
				
				b3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						e1.AlertaCatastrofe("Lockdown");
						telaCatastrofe.dispose();
						JOptionPane.showMessageDialog(null, "Alerta enviado com sucesso!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
						tela.setVisible(true);
					}
				});
				
				
				
				//Evento para encerrar a janela
				telaCatastrofe.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				
				//Centraliza a janela
				telaCatastrofe.setLocationRelativeTo(null);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
