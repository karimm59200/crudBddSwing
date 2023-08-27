package org.example.view;

import org.example.dao.ContactDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog  extends JDialog  {

    private JTextField idField;

    private JButton okButton;

    private JButton cancelButton;

    public static void main(String[] args) {
        DeleteDialog deleteDialog = new DeleteDialog();
        deleteDialog.setVisible(true);
    }

    public DeleteDialog() {

        idField = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        JPanel jPanel = new JPanel();
        setTitle("Delete Contact");
        setBounds(100,100, 350,200);
        getContentPane().setLayout(new BorderLayout());

        JButton okButton = new JButton("OK");
        okButton.setBounds(200, 100, 80, 20);
        jPanel.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 100, 80, 20);
        jPanel.add(cancelButton);

        idField = new JTextField();
        idField.setBounds(50, 20,80, 20);
        jPanel.add(idField);
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(10,20,60,15);
        jPanel.add(labelId);




        getContentPane().add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(null);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(idField.getText());
                ContactDao contactDao = new ContactDao();
                if(contactDao.deleteContact(id)>0){
                    // si suppression ok alors message de confirmation
                    JOptionPane.showMessageDialog(null, "Contact supprimé", "Delete", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    // si suppression pas ok alors message d'erreur
                    JOptionPane.showMessageDialog(null, "Contact non supprimé", "Delete", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
//        cancelButton.addActionListener(this);
//        idField.addActionListener(this);


    }


}
