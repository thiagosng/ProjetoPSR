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
			//Cria��o da tela
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
				//Quando um pacote � recebido esse if ir� exibir a mensagem que foi enviada pelo pacote.
				if (dado != null) {
					//Verifica se a string recebida � um n�mero ou uma mensagem de alerta
					if (dado.matches(".*\\d.*")) {
						double temp = Double.parseDouble(dado);
						System.gc();
						if (temp >= 0 && temp <= 1) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nOrienta��es da OMS : Lave as m�os com �gua e sab�o ou higienizador � base de �lcool para matar v�rus que podem estar nas suas m�os. ","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 1 && temp <= 46) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil :  "+temp+"\nOrienta��es da OMS : Mantenha pelo menos 1 metro de dist�ncia entre voc� e qualquer pessoa que esteja tossindo ou espirrando.","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp >= 47 && temp < 135) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nOrienta��es da OMS : Evite tocar nos olhos, nariz e boca. As m�os tocam muitas superf�cies e podem ser infectadas por v�rus.","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 135 && temp < 1222) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrienta��es da OMS : Certifique-se de que voc� e as pessoas ao seu redor seguem uma boa higiene respirat�ria.","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if(temp>1222 && temp < 2576){
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrienta��es da OMS : Fique em casa se n�o se sentir bem. Se voc� tiver febre, tosse e dificuldade em respirar, procure atendimento m�dico. ","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if(temp >2576 && temp < 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrienta��es da OMS : Pessoas doentes devem adiar ou evitar viajar para as �reas afetadas por coronav�rus.","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if (temp >= 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nOrienta��es da OMS : Os viajantes que retornam das �reas afetadas devem monitorar seus sintomas por 14 dias e seguir os protocolos nacionais dos pa�ses receptores; e se ocorrerem sintomas, devem entrar em contato com um m�dico e informar sobre o hist�rico de viagem e os sintomas.","Orienta��es da OMS (Observador 2 - OMS)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}
					}else {
						//Exibe a mensagem de alerta
						Janela.createGUI(false);//Oculta a janela
						JOptionPane.showMessageDialog(null, dado,"Orienta��es da OMS (Observador 2 - Recomenda��es)", JOptionPane.WARNING_MESSAGE);
						Janela.createGUI(true);//Recria a janela
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
