package org.example.dao;

import org.example.connexion.ConnexionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    private Connection connection;

    private PreparedStatement ps;

    protected ResultSet resultSet;

    public int addContact(Contact contact) {
        try {
            connection = ConnexionUtil.getConnection();
            ps = connection.prepareStatement("INSERT INTO contact(name, number) VALUES (?, ?)");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteContact(int id) {
        try {
            connection = ConnexionUtil.getConnection();
            ps = connection.prepareStatement("DELETE FROM contact WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateContact(Contact contact) {
        try {
            connection = ConnexionUtil.getConnection();
            ps = connection.prepareStatement("UPDATE contact SET name = ?, number = ? WHERE id = ?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            ps.setInt(3, contact.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public  Contact findById(int id) {
        try {
            connection = ConnexionUtil.getConnection();
            ps = connection.prepareStatement("SELECT id, name, number FROM contact WHERE id = ?");
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return Contact.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .number(resultSet.getString("number"))
                        .build();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Contact> findAll() {
        try {
            connection = ConnexionUtil.getConnection();
            List<Contact>  contacts = new ArrayList<>();
            ps = connection.prepareStatement("SELECT id, name, number FROM contact");
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                contacts.add(Contact.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .number(resultSet.getString("number"))
                        .build());
            }
            return contacts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
