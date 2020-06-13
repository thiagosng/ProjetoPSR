import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Observer1 {
	DatagramSocket AtualizacaoSocket;
		
	public void AcompanhaCovid () {
		try {
			AtualizacaoSocket = new DatagramSocket(777);// Cria um soquete escutando na porta 777.
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
				if(dado != null) {
					//Verifica se a string recebida é um número ou uma mensagem de alerta
					if (dado.matches(".*\\d.*")) {
						double temp = Double.parseDouble(dado);
						System.gc();
						if (temp >= 0 && temp <= 1) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nBolsonaro : Ainda que o problema possa de agravar,não há motivo para pânico ","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 1 && temp <= 46) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil :  "+temp+"\nBolsonaro : Algumas poucas autoridades estaduais e municipais devem abandonar o conceito de terra arrasada, a proibição de transportes, o fechamento de comércio e o confinamento em massa.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp >= 47 && temp < 135) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nBolsonaro : Pelo meu histórico de atleta, caso fosse contaminado pelo vírus, não precisaria me preocupar ,nada sentiria\n ou seria, quando muito, acometido de uma GRIPEZINHA ou RESFRIADINHO.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 135 && temp < 1222) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : Essa é uma realidade, o vírus tá aí. Vamos ter que enfrentá-lo, mas enfrentar como homem, porra, não como um moleque. Vamos enfrentar o vírus com a realidade. É a vida. Todos nós iremos morrer um dia.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if(temp>1222 && temp < 2576){
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : Parece que está começando a ir embora essa questão do vírus, mas está chegando e batendo forte a questão do desemprego.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if(temp >2576 && temp < 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : Ô, ô, ô, cara. Quem fala de... eu não sou coveiro, tá?","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if (temp >= 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : E daí? Lamento. Quer que eu faça o quê? Eu sou Messias, mas não faço milagre","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}
					}else {
						//Exibe a mensagem de alerta
						Janela.createGUI(false);//Oculta a janela
						JOptionPane.showMessageDialog(null, dado,"Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
						Janela.createGUI(true);//Recria a janela
					}
						
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
