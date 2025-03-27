package org.example.HeadFirstJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go() {

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(10);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        frame.setSize(400, 500);
        frame.setVisible(true);

    }

    private void setUpNetworking() {
        try{
            /**
             * The socket is made and the PrintWriter is called
             */
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");

        } catch (Exception e) {
            throw new RuntimeException(e);}
    }

    public class SendButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try{
                System.out.println(outgoing.getText());
                writer.println(outgoing.getText());
                writer.flush();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            outgoing.setText("");
            outgoing.requestFocus();


        }
    }
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

}
