package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDialog extends JDialog {

    private JTable table1;
    private JButton OkButton;

    public static void main(String[] args) {
        MessageDialog messageDialog = new MessageDialog();
        messageDialog.setVisible(true);
    }

    public MessageDialog() {

        table1 = new JTable();
        OkButton = new JButton("OK");

        JPanel jPanel = new JPanel();
        setTitle("Message");
        setBounds(100,100, 500,600);
        getContentPane().setLayout(new BorderLayout());

        JButton OkButton = new JButton("OK");
        OkButton.setBounds(350, 500, 80, 20);
        jPanel.add(OkButton);

        getContentPane().add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(null);

        table1 = new JTable();
        table1.setBounds(75, 50, 400, 400);
        jPanel.add(table1);

        OkButton.addActionListener(e -> {
            dispose();
        });


    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table1), BorderLayout.CENTER);
        String[] columnNames = {"Id", "Name", "number"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table1 = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table1);
        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);

            }
        });
        return panel;

    }

}
