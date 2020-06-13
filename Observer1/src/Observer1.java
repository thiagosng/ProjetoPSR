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
				if(dado != null) {
					//Verifica se a string recebida � um n�mero ou uma mensagem de alerta
					if (dado.matches(".*\\d.*")) {
						double temp = Double.parseDouble(dado);
						System.gc();
						if (temp >= 0 && temp <= 1) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nBolsonaro : Ainda que o problema possa de agravar,n�o h� motivo para p�nico ","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 1 && temp <= 46) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil :  "+temp+"\nBolsonaro : Algumas poucas autoridades estaduais e municipais devem abandonar o conceito de terra arrasada, a proibi��o de transportes, o fechamento de com�rcio e o confinamento em massa.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp >= 47 && temp < 135) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+temp+"\nBolsonaro : Pelo meu hist�rico de atleta, caso fosse contaminado pelo v�rus, n�o precisaria me preocupar ,nada sentiria\n ou seria, quando muito, acometido de uma GRIPEZINHA ou RESFRIADINHO.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.INFORMATION_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if (temp > 135 && temp < 1222) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : Essa � uma realidade, o v�rus t� a�. Vamos ter que enfrent�-lo, mas enfrentar como homem, porra, n�o como um moleque. Vamos enfrentar o v�rus com a realidade. � a vida. Todos n�s iremos morrer um dia.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						}else if(temp>1222 && temp < 2576){
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : Parece que est� come�ando a ir embora essa quest�o do v�rus, mas est� chegando e batendo forte a quest�o do desemprego.","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if(temp >2576 && temp < 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : �, �, �, cara. Quem fala de... eu n�o sou coveiro, t�?","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
							Janela.createGUI(true);//Recria a janela
						} else if (temp >= 5017) {
							Janela.createGUI(false);//Oculta a janela
							JOptionPane.showMessageDialog(null, "Numero de mortes por covid no Brasil : "+ temp+ "\nBolsonaro : E da�? Lamento. Quer que eu fa�a o qu�? Eu sou Messias, mas n�o fa�o milagre","Frases do Presidente (Observador 1 - Brasil)", JOptionPane.WARNING_MESSAGE);
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
