package Övning2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {
    public static void main(String[] args) throws IOException {
        Receiver r1 = new Receiver();
        Thread t1 = new Thread((Runnable) r1);
        t1.start();
    }

    public Receiver() {
        int minPort = 55555;
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(minPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[256];
        while (true) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Meddelande från " +
                    packet.getAddress().getHostAddress());
            String message = new String(packet.getData(),
                    0, packet.getLength());
            System.out.println(message);
        }
    }
}

