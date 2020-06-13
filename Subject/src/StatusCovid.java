import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class StatusCovid {
	
	public void AtualizarTemperatura (double temperatura) {
		DatagramPacket Observer1, Observer2;
		DatagramSocket TemperaturaSocket = null;
		InetAddress ip = null;
		//Conversão de Double para String
		String RespostaTemperatura = String.valueOf(temperatura);
		byte[] sendData = RespostaTemperatura.getBytes();
		try {
			TemperaturaSocket = new DatagramSocket();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Envia os dados para os dois observers, um escutando em cada porta
		Observer1 = new DatagramPacket(sendData, sendData.length, ip , 777);
		Observer2 = new DatagramPacket(sendData, sendData.length, ip, 666);
		
		try {
			TemperaturaSocket.send(Observer1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			TemperaturaSocket.send(Observer2);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		TemperaturaSocket.close();
	}
	
	public void AlertaCatastrofe (String catastrofe) {
		DatagramPacket Observer1, Observer2;
		DatagramSocket CatastrofeSocket = null;
		InetAddress ip = null;
		String RespostaCatastofre = "ALERTA! "+catastrofe+" em sua região! Por favor, fique em casa!" ;
		byte[] sendData = RespostaCatastofre.getBytes();
		try {
			CatastrofeSocket = new DatagramSocket();
		}catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Envia os dados para os dois observers, um escutando em cada porta
		Observer1 = new DatagramPacket(sendData, sendData.length, ip , 777);
		Observer2 = new DatagramPacket(sendData, sendData.length, ip, 666);
		try {
			CatastrofeSocket.send(Observer1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			CatastrofeSocket.send(Observer2);
		}catch (IOException e) {
			e.printStackTrace();
		}
		CatastrofeSocket.close();
	}
	

}
