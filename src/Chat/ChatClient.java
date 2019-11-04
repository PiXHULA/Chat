package Chat;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.security.Key;

public class ChatClient extends JFrame{
    JFrame frame = new JFrame();
    JPanel chatPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton connect = new JButton("Connect");
    JButton disconnect = new JButton("Disconnect");
    JButton close = new JButton ("Exit");
    JTextField chatField = new JTextField();
    JTextArea chatArea = new JTextArea();
    MulticastSocket so;
    ChatServer chatServer;

    public ChatClient() throws IOException {
        ChatServer chatServer = new ChatServer(chatArea);
        chatServer.start();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(chatPanel, BorderLayout.CENTER);
        chatPanel.setLayout(new BorderLayout());
        buttonPanel.add(connect);
        buttonPanel.add(disconnect);
        buttonPanel.add(close);
        close.addActionListener(e -> System.exit(0));

        chatPanel.add(chatArea, BorderLayout.CENTER);
        chatArea.setEditable(false);
        chatPanel.add(chatField,BorderLayout.SOUTH);
        frame.setVisible(true);

        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 55555;
        DatagramSocket socket = new DatagramSocket();
        chatField.addActionListener(e -> {
        String message = chatField.getText();

            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            try {
            socket.send(packet);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            chatField.setText("");
        });
    }

    public static void main(String[] args) throws IOException {
        ChatClient cc = new ChatClient();
    }
}
