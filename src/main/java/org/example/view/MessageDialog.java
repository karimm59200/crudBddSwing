package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MessageDialog extends JDialog {

    private JPanel mainPanel;

    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JTable table;
    private JButton okButton;

    private JFrame frame;

    public static void main(String[] args) {
        new MessageDialog();
    }

    public MessageDialog() {

        frame = new JFrame("Message");
        frame.setBounds(500,100,600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        tablePanel = new JPanel(new BorderLayout()); // Crée un panneau avec un layout BorderLayout

        createTablePanel();

        ImageIcon icon = new ImageIcon("src/main/resources/images/contact-book.png");
        icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        mainPanel.add(new JLabel(icon), BorderLayout.WEST); // Ajoute une image à gauche

        tablePanel.setBounds(   500, 100, 450,450);
        mainPanel.add(tablePanel, BorderLayout.CENTER); // Ajoute le panneau avec la JTable au centre

        buttonPanel = new JPanel(new BorderLayout()); // Crée un panneau avec un layout BorderLayout
        okButton.setSize(80,50);
        buttonPanel.add(okButton, BorderLayout.CENTER); // Ajoute le bouton "Détails" en bas

       // mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Ajoute le bouton "Détails" en bas

        frame.add(mainPanel);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        }

    private void createTablePanel() {


        String[] columnNames = {"id", "name", "number"}; // Noms des colonnes du tableau
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // Crée un modèle de tableau par défaut avec les noms de colonnes
        table = new JTable(tableModel); // Crée une JTable avec le modèle de tableau
        JScrollPane scrollPane = new JScrollPane(table); // Ajoute une barre de défilement à la JTable

        okButton = new JButton("OK"); // Crée un bouton "Détails"

        ContactDao contactDao = new ContactDao();
        List<Contact> contacts = contactDao.findAll();
        addToTable(contacts);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.tablePanel.add(scrollPane, BorderLayout.CENTER); // Ajoute la JTable avec barre de défilement au centre


    }

    private void addToTable(List<Contact> contacts) {
        // Obtient le modèle de tableau associé à la JTable
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (Contact contact : contacts){
            // Ajoute une nouvelle ligne avec les valeurs spécifiées au modèle de tableau
            tableModel.addRow(new Object[]{contact.getId(), contact.getName(), contact.getNumber()});
        }


    }
}
