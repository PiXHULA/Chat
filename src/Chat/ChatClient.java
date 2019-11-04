package Chat;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
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
    JScrollPane scrollPane = new JScrollPane(chatArea);
    MulticastSocket so;
    ChatServer chatServer;
    InetAddress toAdr;
    InetAddress local = InetAddress.getLocalHost();
    int toPort = 55555;
    DatagramSocket socket = new DatagramSocket();

    public ChatClient() throws IOException {
        ChatServer chatServer = new ChatServer(chatArea);
        chatServer.start();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(chatPanel, BorderLayout.CENTER);
        chatPanel.setLayout(new BorderLayout());
        buttonPanel.add(connect);
        connect.addActionListener(e -> {
            chatArea.append("Connected" + "\n");
            try {
                socket = new DatagramSocket();
                toAdr = InetAddress.getByName("172.20.202.126");
            } catch (UnknownHostException | SocketException ex) {
                ex.printStackTrace();
            }
        });
        disconnect.addActionListener(e -> {
            socket.close();
            socket.disconnect();
            chatArea.append("Disconnected" + "\n");
        });
        buttonPanel.add(disconnect);
        buttonPanel.add(close);
        close.addActionListener(e -> System.exit(0));

        chatPanel.add(chatArea, BorderLayout.CENTER);
        chatArea.setEditable(false);
        chatPanel.add(chatField,BorderLayout.SOUTH);
        frame.setVisible(true);


        chatField.addActionListener(e -> {
            String message = chatField.getText();
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            DatagramPacket packet2 = new DatagramPacket(data, data.length, local, toPort);

            try {
            socket.send(packet);
            socket.send(packet2);

            } catch (IOException ex) {
                ex.printStackTrace();
            }catch (NullPointerException eee){
                chatArea.append(message + " wasn't delivered.\n");
                chatArea.append("Please make sure you're connected\n");
            }
            chatField.setText("");
        });
    }

    public static void main(String[] args) throws IOException {
            ChatClient cc = new ChatClient();
    }
}
