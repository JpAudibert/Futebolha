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

    public DatagramSocket getSocket() {
        return socket;
    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    public DatagramPacket getPacket() {
        return packet;
    }

    public void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void sendMessage(String message) {
        try {
            byte[] buffer = message.getBytes();

            this.setPacket(new DatagramPacket(buffer, buffer.length, address, porta));
            this.socket.send(getPacket());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scanMovement() {
        try {
            this.setSocket(new DatagramSocket());
            address = InetAddress.getByName("177.44.248.11");

            System.out.println("Escolha um movimento (W, A, S, D)");
            Scanner scanner = new Scanner(System.in);

//            while (scanner.hasNextLine()) {
            String player = scanner.next();
            String movement = scanner.next();

            if (!player.equals("") && !movement.equals("")) {
                StringBuilder play = new StringBuilder();
                play.append("movePlayer(");
                play.append(player);
                play.append(",");
                play.append(movement);
                play.append(");");

                sendMessage(play.toString());
                System.out.println("Jogada executada: " + play.toString());
            }

            Thread.sleep(500);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
