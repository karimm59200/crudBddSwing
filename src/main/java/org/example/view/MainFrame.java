package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JDialog {

    private JButton buttonInsert;

    private JButton buttonUpdate;
    private JButton buttonDelete;


    private JButton buttonSelect;

    private JPanel mainPanel;

    private JFrame frame;

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    public MainFrame() {

        buttonInsert = new JButton("Insert");
        buttonUpdate = new JButton("Update");
        buttonDelete = new JButton("Delete");
        buttonSelect = new JButton("Select");

        mainPanel = new JPanel();
        setTitle("Main Menu");
        setBounds(100,100, 400,200);
        getContentPane().setLayout(new BorderLayout());

        JButton buttonInsert = new JButton("Insert");
        buttonInsert.setBounds(250, 20, 80, 20);
        mainPanel.add(buttonInsert);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(150, 20, 80, 20);
        mainPanel.add(buttonUpdate);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(50, 20, 80, 20);
        mainPanel.add(buttonDelete);

        JButton buttonSelect = new JButton("Select");
        buttonSelect.setBounds(150, 100, 80, 20);
        mainPanel.add(buttonSelect);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);

        buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertDialog insertDialog = new InsertDialog();
                insertDialog.setVisible(true);
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDialog updateDialog = new UpdateDialog();
                updateDialog.setVisible(true);
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog();
                deleteDialog.setVisible(true);
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDialog updateDialog = new UpdateDialog();
                updateDialog.setVisible(true);
            }
        });

        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageDialog messageDialog = new MessageDialog();

            }
        });

//        buttonSelect.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SelectDialog selectDialog = new SelectDialog();
//                selectDialog.setVisible(true);
//            }
//        });
    }


}
