package org.example.view;


import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UpdateDialog extends JDialog {

    private JTextField idField;
    private JTextField nameField;
    private JTextField numberField;
    private JButton okButton;
    private JButton cancelButton;
    private JButton searchButton;
    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelNumber;
    private ContactDao contactDao;

    public static void main(String[] args) {
        UpdateDialog updateDialog = new UpdateDialog();
        updateDialog.setVisible(true);
    }

    public UpdateDialog() {

        idField = new JTextField();
        nameField = new JTextField();
        numberField = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        searchButton = new JButton("Search");
        labelId = new JLabel("Id");
        labelName = new JLabel("Name");
        labelNumber = new JLabel("Number");

        JPanel jPanel = new JPanel();
        setTitle("Update Contact");
        setBounds(100,100, 350,250);
        getContentPane().setLayout(new BorderLayout());

        JButton okButton = new JButton("OK");
        okButton.setBounds(250, 150, 80, 20);
        jPanel.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 150, 80, 20);
        jPanel.add(cancelButton);

        JButton SearchButton = new JButton("Search");
        SearchButton.setBounds(200, 20, 80, 20);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactDao contactDao = new ContactDao();
                Contact contact = contactDao.findById(Integer.parseInt(idField.getText()));
                nameField.setText(contact.getName());
                numberField.setText(contact.getNumber());
            }
        });
        jPanel.add(SearchButton);

        idField = new JTextField();
        idField.setBounds(80, 20,80, 20);
        jPanel.add(idField);
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(10,20,60,15);
        jPanel.add(labelId);

        nameField = new JTextField();
        nameField.setBounds(80, 50,80, 20);
        jPanel.add(nameField);
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(10,50,60,15);
        jPanel.add(labelName);

        numberField = new JTextField();
        numberField.setBounds(80, 80,80, 20);
        jPanel.add(numberField);
        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(10,80,60,15);
        jPanel.add(labelNumber);




        getContentPane().add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(null);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String number = numberField.getText();

                ContactDao contactDao = new ContactDao();
                contactDao.updateContact(Contact.builder().id(id).name(name).number(number).build());

            }
        });


//            Contact contact = contactDao.findById(Integer.parseInt(idField.getText()));
//            System.out.println(contact);
//            if(contact == null) {
//                JOptionPane.showMessageDialog(null, "Contact not found");
//                return;
//            } else {
//                //JOptionPane.showMessageDialog(null, "Contact found");
//                nameField.setText(contact.getName());
//                numberField.setText(contact.getNumber());
//            }
//            }
//
//    });

        }


//        cancelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
    }
//}
