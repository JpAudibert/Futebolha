package futebolha;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    private DatagramSocket socket = null;
    private DatagramPacket packet = null;
    private InetAddress address = null;
    private int porta = 1342;

    public void sendMessage(String message) {
        try {
            byte[] buffer = message.getBytes();

            this.packet = new DatagramPacket(buffer, buffer.length, address, porta);
            this.socket.send(this.packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scanMovement() {
        try {
            this.socket = new DatagramSocket();
            address = InetAddress.getByName("10.0.0.174");

            System.out.println("Escolha um jogador e movimento (W, A, S, D)");
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()){
                String player = scanner.next();
                String movement = scanner.next();

                if (!player.equals("") && !movement.equals("")) {
                    StringBuilder play = new StringBuilder();
                    play.append("play(");
                    play.append(player);
                    play.append(",");
                    play.append(movement);
                    play.append(");");

                    sendMessage(play.toString());
                }

                Thread.sleep(500);
            }
            
            this.socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
