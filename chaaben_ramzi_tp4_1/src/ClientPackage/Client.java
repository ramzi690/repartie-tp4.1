package ClientPackage;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	private static final int PORT =1234; // port du serveur
     private static byte[] receiveData = new byte[1024]; // Tampon pour les données reçues
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(); // creation d'une socket
			InetAddress inetAddress = InetAddress.getByName("localhost"); //cherche moi la machine localhsot
			//traitement
			Scanner scanner = new Scanner(System.in);
			System.out.println("ecrivez votre nom et prenom:");
			String msg=scanner.nextLine();
			byte[] sendData=msg.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,inetAddress,PORT); /* on met les données dans un packet et on specifie 
			l'@ de la machine et le port */
			socket.send(sendPacket); // envoit du datagram au serveur
			
			// reçoit du reponse
			
			DatagramPacket receivePacket= new DatagramPacket(receiveData,receiveData.length);
			socket.receive(receivePacket); // la reception du datagram envoyer par le serveur
			String reponse = new String(receivePacket.getData(),0,receivePacket.getLength());
			System.out.println(" reponse du serveur :"+reponse);
			socket.close();// fermeture du socket
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}