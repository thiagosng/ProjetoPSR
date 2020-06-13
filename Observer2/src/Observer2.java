import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Observer2 {
	DatagramSocket AtualizacaoSocket;
	
	public void AcompanhaCovid () {
		try {
			AtualizacaoSocket = new DatagramSocket(666); // Cria um soquete escutando na porta 666.
			byte[] receiveData;
			String dado = null;
			//Criação da tela
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					Janela.createGUI(true);
					Janela.centralizaJanela();
				}
			});
			
			while (true) {
				receiveData = new byte [120];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				AtualizacaoSocket.receive(receivePacket);
				
				dado = new String (receivePacket.getData());
				//Quando um pacote é recebido esse if irá exibir a mensagem que foi enviada pelo pacote.
				if (dado != null) {
					//Verifica se a string recebida é um número ou uma mensagem de alerta
					if (dado.matches(".*\\d.*")) {
						double temp = Double.parseDouble(dado);
						System.gc();
						if (temp >= 0 && temp <= 1) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nOrientações da OMS : Lave as mãos com água e sabão ou higienizador à base de álcool para matar vírus que podem estar nas suas mãos. ","Orientações da OMS (Observador 2 - OMS)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 1 && temp <= 46) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil :  "+temp+"\nOrientações da OMS : Mantenha pelo menos 1 metro de distância entre você e qualquer pessoa que esteja tossindo ou espirrando.","Orientações da OMS (Observador 2 - OMS)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp >= 47 && temp < 135) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nOrientações da OMS : Evite tocar nos olhos, nariz e boca. As mãos tocam muitas superfícies e podem ser infectadas por vírus.","Orientações da OMS (Observador 2 - OMS)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 135 && temp < 1222) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrientações da OMS : Certifique-se de que você e as pessoas ao seu redor seguem uma boa higiene respiratória.","Orientações da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if(temp>1222 && temp < 2576){
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrientações da OMS : Fique em casa se não se sentir bem. Se você tiver febre, tosse e dificuldade em respirar, procure atendimento médico. ","Orientações da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if(temp >2576 && temp < 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrientações da OMS : Pessoas doentes devem adiar ou evitar viajar para as áreas afetadas por coronavírus.","Orientações da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if (temp >= 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrientações da OMS : Os viajantes que retornam das áreas afetadas devem monitorar seus sintomas por 14 dias e seguir os protocolos nacionais dos países receptores; e se ocorrerem sintomas, devem entrar em contato com um médico e informar sobre o histórico de viagem e os sintomas.","Orientações da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}
					}else {
						//Exibe a mensagem de alerta
						Janela.createGUI(false);//Oculta a janela
						JOptionPane.showMessageDialog(null, dado,"Orientações da OMS (Observador 2 - Recomendações)", JOptionPane.WARNING_MESSAGE);
						Janela.createGUI(true);//Recria a janela
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
